package study.socket;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClientSocket {
    // 使用Socket发送请求
    // @Test
    public void SocketSendRequest(){
        // 将Socket加入try的小括号中是因为Socket类实现了Closeable接口，我们将它放置在try语句中，try语句就会自动帮助我们关闭Socket
        // 创建Socket对象中传的参数：第一个host是：我们的指令，第二个port是：我们输入查询的端口号
        try (Socket socket = new Socket("time-A.timefreq.bldrdoc.gov", 13)) {
            // 使用socket的getInputStream方法接收当前会在DOS命令窗口输出的东西
            InputStream inputStream = socket.getInputStream();
            // 将它放置在我们的Scanner中，根据查阅相关文档可以得知：构造一个新的 Scanner ，产生从指定输入流扫描的值。
            // 这里我们希望的是能够在上面的socket中获取的字节流让我们的Scanner去这里查看输出了什么
            try (Scanner sc = new Scanner(inputStream)) {
                // 然后给他遍历打印出来，注意我们这里是扫描一行，打印一行
                while (sc.hasNextLine()) {
                    System.out.println(sc.nextLine());
                }
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // 使用Socket从服务端接收请求
    public static void main(String[] args) {
        // 创建服务，输入指定端口号
        try (ServerSocket serverSocket = new ServerSocket(7890)) {
            // 使用accept()方法接收请求
            try (Socket socket = serverSocket.accept()) {
                // 获取输入和输出
                InputStream inputStream = socket.getInputStream();
                OutputStream outputStream = socket.getOutputStream();
                // 将我们的OutputStream的输出源给到客户端，让他显示到客户端的界面
                // true表示缓冲，我们输出的时候需要进行缓冲，一次一次的输出，为了我们一次性的输出，给他赋值为true，表示一次性输出
                PrintWriter printWriter = new PrintWriter(outputStream, true);
                printWriter.println("If you want exit the window,you can input 'bye' !");
                printWriter.println("Client say : ");
                Scanner scanner = new Scanner(System.in);

                // 指定一个源，从这里接收我们所要接收的内容
                try (Scanner sc = new Scanner(inputStream)) {
                    // 打一个布尔标记，如果你想退出当前窗口的话可以在当前窗口输入exit，然后我们对其进行判断，就可以退出啦
                    boolean exit = false;
                    while (!exit && sc.hasNextLine()) {
                        // 获取请求数据，并输出
                        String inStr = sc.nextLine();
                        System.out.println("Client say : " + inStr);
                        // 打印到我们客户端上，显示为自己发送过去的也相当于服务器接收到的
                        System.out.println("Server say : ");
                        // 接收服务端的内容
                        // 接收服务器端输入的话
                        if (scanner.hasNextLine()) {
                            // 并打印出来
                            String outStr = scanner.nextLine();
                            printWriter.println("Server say :" + outStr);
                            if ("bye".equals(inStr.trim()) || "bye".equals(outStr.trim())) {
                                exit = true;
                            } else {
                                printWriter.println("Client say : ");
                            }
                        }
                        // printWriter.println("Client say : ");
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        /*ServerSocket serverSocket = null;
        Socket socket = null;
        InputStream inputStream = null;
        OutputStream outputStream = null;
        PrintWriter printWriter = null;
        Scanner sc = null;
        Scanner scanner = null;
        try {
            serverSocket = new ServerSocket(1090);
            socket = serverSocket.accept();
            inputStream = socket.getInputStream();
            outputStream = socket.getOutputStream();
            printWriter = new PrintWriter(outputStream, true);
            printWriter.println("say bye to exit! ");
            printWriter.print("Client say : ");
            scanner = new Scanner(System.in);
            sc = new Scanner(inputStream);
            boolean exit = false;
            while (!exit && sc.hasNextLine()) {
                // printWriter.print("Client say : ");
                String inStr = sc.nextLine();
                System.out.println("Client say : " + inStr);

                System.out.print("Server say : ");
                if (scanner.hasNextLine()) {
                    String outStr = scanner.nextLine();
                    printWriter.println("Server say :" + outStr);
                    if ("bye".equals(inStr.trim()) || "bye".equals(outStr.trim())) {
                        exit = true;
                    }else {
                        printWriter.print("Client say : ");
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (printWriter != null) {
                printWriter.close();
            }
            if (sc != null) {
                sc.close();
            }
            if (scanner != null) {
                scanner.close();
            }
        }*/














    }
}
