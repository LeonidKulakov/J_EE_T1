package server.logger;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

/**
 * Класс логгер
 * */
public final class LogStorage {

    private LogStorage() {
    }

    public static void logInfo(String ip, String quote) {
        try (var bufferWriter = new BufferedWriter(new FileWriter("log.txt", true))) {
            bufferWriter.write("Quote: " + quote + " (" + ip + ") ");
            bufferWriter.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void logInfo(String ip) {
        try (var bufferWriter = new BufferedWriter(new FileWriter("log.txt", true))) {
            bufferWriter.write("Disconnected: " + ip + " " + new Date());
            bufferWriter.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
