package ir.ac.aut.ceit.textserver;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client implements Runnable {
    private InputStream inputStream;
    private OutputStream outputStream;
    private Socket socket;

    public void connectServer() {
        try (Socket socket = new Socket("127.0.0.1", 8888)) {
            inputStream = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            outputStream = socket.getOutputStream();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print(":: Enter Your String:\n>> ");
            try {
                String entered = scanner.next();
                if(entered.toLowerCase().equals("over")) return;
                outputStream.write(entered.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                int sz = inputStream.available();
                if(sz > 0) {
                    byte[] resp = new byte[sz];
                    inputStream.read(resp);
                    System.out.println(":: Server Response:\n>>");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
