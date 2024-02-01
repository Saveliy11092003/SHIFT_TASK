package ru.nsu.trushkov.file;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Reader {

    private static final Logger logger = LoggerFactory.getLogger(Reader.class);

    private final BufferedReader reader;

    public Reader(String filePath) throws FileNotFoundException {
        logger.info("In Reader Constructor");
        logger.info("Create file " + filePath);
        File file = new File(filePath);
        logger.info("Create BufferedReader");
        this.reader = new BufferedReader(new FileReader(file));
    }

    public String readLine() {
        String line = null;
        try {
            line = reader.readLine();
            logger.info("Line read - " + line);
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
        return line;
    }

    public List<BigInteger> readListInt() {
        logger.info("Create List<BigInteger>");
        List<BigInteger> list = new ArrayList<>();
        String line;
        while ((line = readLine()) != null) {
            BigInteger integer = new BigInteger(line);
            logger.info("Add to list - " + integer);
            list.add(integer);
        }
        return list;
    }

    public List<BigDecimal> readListDouble() {
        logger.info("Create List<BigDecimal>");
        List<BigDecimal> list = new ArrayList<>();
        String line;
        while ((line = readLine()) != null) {
            BigDecimal decimal = new BigDecimal(line);
            logger.info("Add to list - " + decimal);
            list.add(decimal);
        }
        return list;
    }

    public List<String> readListString() {
        logger.info("Create List<BigString>");
        List<String> list = new ArrayList<>();
        String line;
        while ((line = readLine()) != null) {
            logger.info("Add to list - " + line);
            list.add(line);
        }
        return list;
    }
}
