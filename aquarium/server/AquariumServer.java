package aquarium.server;

import aquarium.items.*;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class AquariumServer {
    private ServerSocket serverSocket;
    private ArrayList<AquariumItem> items;
    private Thread main;
    public boolean isServerRunning = false;

    AquariumServer(int port) throws IOException
    {
        serverSocket = new ServerSocket(port);
        items = new ArrayList<AquariumItem>();
        main = new Thread(() -> {
            while(isServerRunning)
            {
                Socket socket;
                try
                {
                    socket = serverSocket.accept();
                }
                catch (IOException e)
                {
                    System.out.println(e.getMessage());
                }

            }
        });
    }

    public void start()
    {
        main.start();
        System.out.println("Server has started...");
        // TODO implement simulation based on client implementation (waiting for Ryan)
    }

    class Broadcast implements Runnable
    {
        Socket socket;

        Broadcast(Socket socket)
        {
            this.socket = socket;
        }

        @Override
        public void run() {

        }
    }
}
