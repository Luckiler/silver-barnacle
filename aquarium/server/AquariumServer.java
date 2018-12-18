package aquarium.server;

import aquarium.items.*;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

public class AquariumServer {
    private ServerSocket serverSocket;
    private ArrayList<AquariumItem> items;
    private Thread main;
    public boolean isServerRunning = false;

    public AquariumServer(int port) throws IOException
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
                    new Thread(new Broadcast(socket)).start();
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
        ObjectOutputStream outputStream;

        public Broadcast(Socket socket) throws IOException
        {
            this.socket = socket;
            outputStream = new ObjectOutputStream(socket.getOutputStream());
        }

        @Override
        public void run() {
            while(true) {
                LinkedHashMap<UUID, ItemUpdateInfo> itemUpdateInfos = new LinkedHashMap<>();
                for (AquariumItem item : items) {
                    ItemUpdateInfo itemUpdateInfo = new ItemUpdateInfo(item.position, item.id);
                    itemUpdateInfos.put(itemUpdateInfo.uuid, itemUpdateInfo);
                }
                try {
                    outputStream.writeObject(itemUpdateInfos);
                } catch (IOException e) {
                    e.printStackTrace();
                    break;
                }
                try {
                    Thread.sleep(1000 / 30);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    break;
                }
            }
        }
    }
}
