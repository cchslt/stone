package com.stone.may;

import java.io.*;

public class ByteSerializationUtil {

    public static byte[] SerializationOut(Object o) {
        byte[] bytes = null;
        try {
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(os);

            out.writeObject(o);
            bytes = os.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bytes;
    }

    public static Object InSerialization(byte[] bytes) {
        Object o = null;
        try {
            ByteArrayInputStream is = new ByteArrayInputStream(bytes);
            ObjectInputStream in = new ObjectInputStream(is);
            o = in.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return o;
    }
}
