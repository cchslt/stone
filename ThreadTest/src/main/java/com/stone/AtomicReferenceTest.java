package com.stone;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by chenchen on 2017/5/27.
 *
 * ԭ�Ӹ������ã����¶������
 * 1��AtomicReference ԭ�Ӹ�������
 * 2��AtomicReferenceFiledUpdater ԭ�Ӹ������������������
 * 3��AtomicMarkableReference ԭ�Ӹ��´��б�ǵ���������
 *
 * ����compareAndSet��������ԭ�ӵĸ��²���
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
