package main;
import javax.swing.SwingUtilities;

import animation.Animation;
import aquarium.server.AquariumServer;

import java.io.IOException;
import java.util.Objects;

public class Start
{
    public static void main(String[] args) {
    	SwingUtilities.invokeLater(() -> {
    	    if (Objects.equals(args[0], "-c")) {
                new Animation("Aquarium");
            }
    	    else if (Objects.equals(args[0], "-s")) {
    	        int port;
    	        try {
                    port = Integer.parseInt(args[1]);
                }
    	        catch (NumberFormatException e) {
    	            System.out.println("Invalid port format");
    	            return;
                }
    	        try {
    	            new AquariumServer(port).start();
                }
    	        catch (IOException e) {
    	            e.printStackTrace();
    	            return;
                }
            }
    	    else {
    	        System.out.println("Specify -c for client or -s for server");
            }

    	});
    }
}