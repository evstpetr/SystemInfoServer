package ru.pes.systeminfoserver;

import java.io.IOException;
import java.net.ServerSocket;


public class Server implements Runnable{

    private final int PORT;
    
    public Server(int port) {
        this.PORT = port;
    }
    
    @Override
    public void run() {
                
        ServerSocket server = null;
        
        try {
            server = new ServerSocket(PORT);
        } catch (IOException e) {
            System.out.println("Порт " + PORT + " уже используется! " + e.getMessage());
            System.exit(-1);
        }
        
        while (true) {  
            Worker w;
            try {
                w = new Worker(server.accept());
                Thread t = new Thread(w);
                t.start();
            } catch (IOException e) {
                System.out.println("Неудалось создать подключение на порту 4321! " + e.getMessage());
                System.exit(-1);
            }
        }
    }
    
}
