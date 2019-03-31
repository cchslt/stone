package com.stone.spark.streaming;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.*;
import org.apache.spark.streaming.Durations;
import org.apache.spark.streaming.api.java.JavaDStream;
import org.apache.spark.streaming.api.java.JavaPairDStream;
import org.apache.spark.streaming.api.java.JavaReceiverInputDStream;
import org.apache.spark.streaming.api.java.JavaStreamingContext;
import scala.Tuple2;

import java.util.Arrays;
import java.util.Iterator;

public class ReadLocalTxtStreaming {

    public static void main(String[] args) throws InterruptedException {
        SparkConf sparkConf = new SparkConf().setAppName("ReadLocalTxtStreaming").setMaster("local[2]");
        JavaSparkContext jsc = new JavaSparkContext(sparkConf);
        JavaStreamingContext jssc = new JavaStreamingContext(jsc, Durations.seconds(5));

//        JavaDStream<String> lines = jssc.textFileStream("/Users/shi/log/streaming/student.txt");
        JavaReceiverInputDStream<String> lines = jssc.socketTextStream("localhost", 9999);


        JavaDStream<String> words = lines.flatMap(new FlatMapFunction<String, String>() {
            @Override
            public Iterator<String> call(String s) throws Exception {
                return Arrays.asList(s.split(",")).iterator();
            }
        });


        JavaPairDStream<String, Integer> pairDStream = words.mapToPair(new PairFunction<String, String, Integer>() {
            @Override
            public Tuple2<String, Integer> call(String s) throws Exception {
                return new Tuple2<String, Integer>(s, 1);
            }
        });

        JavaPairDStream<String, Integer> wordCounts = pairDStream.reduceByKey(new Function2<Integer, Integer, Integer>() {
            @Override
            public Integer call(Integer integer, Integer integer2) throws Exception {
                return integer + integer2;
            }
        });

        wordCounts.print();


        jssc.start();
        jssc.awaitTermination();
        jssc.close();

    }
}
