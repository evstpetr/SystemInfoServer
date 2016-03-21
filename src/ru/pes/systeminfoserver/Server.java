package ru.pes.systeminfoserver;

import java.io.IOException;
import java.net.ServerSocket;
import org.apache.log4j.Logger;


public class Server implements Runnable{

    private final int PORT;
    private static final Logger logger = Logger.getLogger(Server.class);
    
    public Server(int port) {
        logger.info("Server started.");
        this.PORT = port;
    }
    
    @Override
    public void run() {
                
        ServerSocket server = null;
        
        try {
            server = new ServerSocket(PORT);
        } catch (IOException e) {
            logger.error("Порт " + PORT + " уже используется! ", e);
            System.exit(-1);
        }
        
        while (true) {  
            Worker w;
            try {
                w = new Worker(server.accept());
                Thread t = new Thread(w);
                t.start();
            } catch (IOException e) {
                logger.error("Неудалось создать новый поток ", e);
                System.exit(-1);
            }
        }
    }
    
}
