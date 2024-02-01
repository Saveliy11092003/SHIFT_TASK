package ru.nsu.trushkov.statistics;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.nsu.trushkov.context.Context;
import ru.nsu.trushkov.file.CreatorFilePath;
import ru.nsu.trushkov.file.Reader;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

public class WriterSimpleStatistics implements WriterStatistics {

    private static final Logger logger = LoggerFactory.getLogger(WriterSimpleStatistics.class);

    private final Context context;

    public WriterSimpleStatistics(Context context) {
        this.context = context;
    }

    @Override
    public void writeStatistics() throws IOException {
        if (context.getFileInt() != null) {
            writeStatisticsInt();
        }
        if (context.getFileDouble() != null) {
            writeStatisticsDouble();
        }
        if (context.getFileString() != null) {
            writeStatisticsString();
        }
    }

    private void writeStatisticsInt() throws FileNotFoundException {
        logger.info("Create CreatorFilePath");
        CreatorFilePath creator = new CreatorFilePath(context.getPath(), context.getPrefix(), "integers.txt");

        logger.info("Start creating filepath and prefix for output files");
        String filePath = creator.createFilePath();

        Reader reader = new Reader(filePath);
        List<BigInteger> list = reader.readListInt();
        System.out.println(filePath);
        System.out.println("Count: " + list.size());
        logger.info("Count: " + list.size());
        System.out.println();
    }

    private void writeStatisticsDouble() throws FileNotFoundException {
        logger.info("Create CreatorFilePath");
        CreatorFilePath creator = new CreatorFilePath(context.getPath(), context.getPrefix(), "floats.txt");

        logger.info("Start creating filepath and prefix for output files");
        String filePath = creator.createFilePath();

        Reader reader = new Reader(filePath);
        List<BigDecimal> list = reader.readListDouble();
        System.out.println(filePath);
        System.out.println("Count: " + list.size());
        logger.info("Count: " + list.size());
        System.out.println();
    }

    private void writeStatisticsString() throws FileNotFoundException {
        logger.info("Create CreatorFilePath");
        CreatorFilePath creator = new CreatorFilePath(context.getPath(), context.getPrefix(), "strings.txt");

        logger.info("Start creating filepath and prefix for output files");
        String filePath = creator.createFilePath();

        Reader reader = new Reader(filePath);
        List<String> list = reader.readListString();
        System.out.println(filePath);
        System.out.println("Count: " + list.size());
        logger.info("Count: " + list.size());
    }

}
