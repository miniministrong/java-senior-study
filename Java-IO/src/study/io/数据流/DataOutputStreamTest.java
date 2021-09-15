package study.io.数据流;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * java.io.DataOutputStream：数据专属的流
 * 这个流生成的文件在记事本中打不开，因此，他不是普通的文本文档
 */
public class DataOutputStreamTest {
    public static void main(String[] args) throws IOException {
        DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream("dataOutput"));
        byte b = 1;
        short s = 2;
        int i = 3;
        long l = 4L;
        float f = 5.0F;
        double d = 6.0;
        boolean sex = false;
        char c = '7';
        // 他可以将数据传过去，也可以将数据的类型也一并传过去
        dataOutputStream.writeByte(b);
        dataOutputStream.writeShort(s);
        dataOutputStream.writeInt(i);
        dataOutputStream.writeLong(l);
        dataOutputStream.writeFloat(f);
        dataOutputStream.writeDouble(d);
        dataOutputStream.writeBoolean(sex);
        dataOutputStream.writeChar(c);
        dataOutputStream.flush();
        dataOutputStream.close();
    }
}
