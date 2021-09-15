package study.io.数据流;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class DataInputStreamTest {

    private static DataInputStream dataInputStream;

    public static void main(String[] args) throws IOException {
        dataInputStream = new DataInputStream(new FileInputStream("dataOutput"));
        byte b = dataInputStream.readByte();
        short s = dataInputStream.readShort();
        int i = dataInputStream.readInt();
        long l = dataInputStream.readLong();
        float f = dataInputStream.readFloat();
        double d = dataInputStream.readDouble();
        boolean sex = dataInputStream.readBoolean();
        char c = dataInputStream.readChar();

        System.out.println(b);
        System.out.println(s);
        System.out.println(i);
        System.out.println(l);
        System.out.println(f);
        System.out.println(d);
        System.out.println(sex);
        System.out.println(c);

        dataInputStream.close();
    }
}
