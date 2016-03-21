package ru.pes.systeminfoserver;


public class SystemInfoServer {

    
    public static void main(String[] args) {
        new Thread(new Server(8080)).start();
    }
    
}
