package com.stone;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by chenchen on 2017/5/27.
 *
 * 原子更新引用，更新多个变量
 * 1、AtomicReference 原子更新引用
 * 2、AtomicReferenceFiledUpdater 原子更新引用类型里的类型
 * 3、AtomicMarkableReference 原子更新带有标记的引用类型
 *
 * 调用compareAndSet方法进行原子的更新操作
 */
public class AtomicReferenceTest {

    public static AtomicReference<User> atomicReference = new AtomicReference<User>();

    public static void main(String[] args) {
        User user = new User("ss", 10);
        atomicReference.set(user);
        User updateUser = new User("Ahdhkf", 12);
        atomicReference.compareAndSet(user, updateUser);
        System.out.println(atomicReference.get().getUserName());
        System.out.println(atomicReference.get().getOld());
    }
}
