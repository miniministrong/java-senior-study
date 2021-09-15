package study.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

// 多线程解决聊天问题
public class MultServerSocket {
    public static void main(String[] args) {
        ServerSocket ss = null;
        try {
            ss = new ServerSocket(7890);
            int i = 0;
            while (true) {
                Socket socket = ss.accept();
                Runnable r = new ThreadSocket(socket);
                Thread t = new Thread(r);
                t.setName("t" + i++);
                t.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ThreadSocket implements Runnable {
    Socket socket;

    public ThreadSocket(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        InputStream in = null;
        OutputStream out = null;
        try {
            in = socket.getInputStream();
            out = socket.getOutputStream();
            PrintWriter dosOut = new PrintWriter(out, true);
            dosOut.println("If you want exit the window,you can input 'bye' !");
            dosOut.println(Thread.currentThread().getName() + " say : ");
            Scanner sc = new Scanner(in);
            boolean exit = false;
            while (!exit && sc.hasNextLine()) {
                String inStr = sc.nextLine();
                System.out.println("Client " + Thread.currentThread().getName() + " : " + inStr);
                if ("bye".equals(inStr.trim())) {
                    exit = true;
                }
            }
            out.flush();
            dosOut.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}