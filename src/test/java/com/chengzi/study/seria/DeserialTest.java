package com.chengzi.study.seria;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeserialTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        TestEnum testEnum = TestEnum.valueOf("T1");
        FileInputStream fis = new FileInputStream("Person.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        TestEnum t1 = (TestEnum) ois.readObject();
        ois.close();
    }

}