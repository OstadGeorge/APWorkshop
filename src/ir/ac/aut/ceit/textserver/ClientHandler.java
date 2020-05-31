package ir.ac.aut.ceit.textserver;

import java.io.*;
import java.net.Socket;

public class ClientHandler implements Runnable {
    private final Socket socket;
    private String text;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            InputStream inputStream = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            OutputStream outputStream = socket.getOutputStream();

            while(true) {
                int sz = inputStream.available();
                if(sz > 0) {
                    byte[] input = new byte[sz];
                    inputStream.read(input);
                    if(String.valueOf(input).toLowerCase().equals("over")) {
                        break;
                    }
                    text += String.valueOf(input);
                    outputStream.write(text.getBytes());
                }
            }
            socket.close();
            inputStream.close();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
