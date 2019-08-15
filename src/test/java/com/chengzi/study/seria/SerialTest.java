package com.zhouw.seria;

/**
 * Created by zhouwei on 2018/10/29
 **/
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerialTest {

    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("Person.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(TestEnum.T1);
        oos.flush();
        oos.close();
    }
}