package ru.pes.systeminfoserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringReader;
import java.net.Socket;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import org.apache.log4j.Logger;
import ru.pes.systeminfoserver.utils.ServerUtil;

// Класс для взаимодествия с клиентской частью
public class Worker implements Runnable {

    private final Socket CLIENT;
    private boolean run = true;
    private BufferedReader in = null;
    private PrintWriter out = null;
    private static final Logger logger = Logger.getLogger(Worker.class);

    public Worker(Socket client) {
        this.CLIENT = client;
    }

    @Override
    public void run() {
        String line;
        JsonObject jsonSystem = null;
        JsonObject jsonSoft = null;

        try {
            in = new BufferedReader(new InputStreamReader(CLIENT.getInputStream(), "Cp1251"));
            out = new PrintWriter(CLIENT.getOutputStream(), true);
        } catch (IOException e) {
            logger.error("Неудалось создать поток ввода/вывоа", e);
        }

        while (run) {
            try {
                line = in.readLine();
                if (line == null) {
                    break;
                }
                if (line.equals("off")) {
                    shutDown();
                } else {
                    // Читаем информацию от клиента и пишем в БД
                    if (line.length() > 5 && line.substring(0, line.indexOf("{")).equals("sys")) {
                        System.out.println(line.substring(line.indexOf("{")));
                        JsonReader reader = Json.createReader(new StringReader(line.substring(line.indexOf("{"))));
                        jsonSystem = reader.readObject();
                    } else if (line.length() > 5 && line.substring(0, line.indexOf("{")).equals("soft")) {
                        System.out.println(line.substring(line.indexOf("{")));
                        JsonReader reader = Json.createReader(new StringReader(line.substring(line.indexOf("{"))));
                        jsonSoft = reader.readObject();
                        ServerUtil.saveSystemInformationIntoBase(jsonSystem, jsonSoft);
                        out.println("0");
                    }

                }
            } catch (IOException e) {
                logger.error("Неудалось прочитать сообщение от клиента ", e);
            }
        }

    }

    private void shutDown() {
        run = false;
        try {
            out.close();
            in.close();
            CLIENT.close();
        } catch (IOException e) {
            logger.error("Неудалось закрыть подключение ", e);
        }
    }

}
