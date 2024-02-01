package ru.nsu.trushkov.file;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Writer {

    private static final Logger logger = LoggerFactory.getLogger(Reader.class);

    private BufferedWriter writer;

    public void write(File file, String line) throws IOException {

        logger.info("Create BufferedWriter for file - " + file);
        this.writer = new BufferedWriter(new FileWriter(file, true));
        try {
            logger.info("Write line - " + line);
            writer.write(line);
            writer.newLine();
            writer.flush();

        } catch (IOException e) {
            logger.error(e.getMessage());
        }
    }

}
