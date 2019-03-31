package com.stone.may;

/**
 * Created by chenchen on 2017/5/27.
 */
public class Test {
    public static void main(String[] args) {
//        System.out.println("I want to change the world!");
        Person zhangsan = new Person("zhangsan", "哈儿");
        byte[] zhangsanbyte = ByteSerializationUtil.SerializationOut(zhangsan);
        System.out.println(zhangsanbyte);

        Object zsOb = ByteSerializationUtil.InSerialization(zhangsanbyte);
        Person zs = (Person)zsOb;
        System.out.println(zs);
    }
}
