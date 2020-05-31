package ir.ac.aut.ceit.textserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server implements Runnable {
    private ServerSocket serverSocket;
    private ExecutorService executorService;

    public Server(int port) {
        try {
            serverSocket = new ServerSocket(port);
            executorService = Executors.newCachedThreadPool();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while(true) {
            try {
                Socket channel = serverSocket.accept();
                executorService.execute(new ClientHandler(channel));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
