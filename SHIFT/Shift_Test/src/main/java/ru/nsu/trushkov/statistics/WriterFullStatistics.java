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
import java.math.MathContext;
import java.util.List;

public class WriterFullStatistics implements WriterStatistics {

    private static final Logger logger = LoggerFactory.getLogger(WriterFullStatistics.class);

    private final Context context;

    public WriterFullStatistics(Context context) {
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
        logger.info("In writeStatisticsInt()");

        logger.info("Create CreatorFilePath");
        CreatorFilePath creator = new CreatorFilePath(context.getPath(), context.getPrefix(), "integers.txt");

        logger.info("Start creating filepath and prefix for output files");
        String filePath = creator.createFilePath();

        System.out.println(filePath);

        Reader reader = new Reader(filePath);
        List<BigInteger> list = reader.readListInt();

        FullStatisticsInt statisticsInt = new FullStatisticsInt(list);

        statisticsInt.setCount();
        statisticsInt.setSumma();
        statisticsInt.setAvg();
        statisticsInt.setMaxAndMin();
        System.out.println(statisticsInt);
        System.out.println();
    }

    private void writeStatisticsDouble() throws FileNotFoundException {
        logger.info("In writeStatisticsDouble()");

        logger.info("Create CreatorFilePath");
        CreatorFilePath creator = new CreatorFilePath(context.getPath(), context.getPrefix(), "floats.txt");

        logger.info("Start creating filepath and prefix for output files");
        String filePath = creator.createFilePath();

        Reader reader = new Reader(filePath);
        List<BigDecimal> list = reader.readListDouble();

        FullStatisticsFloat statisticsFloat = new FullStatisticsFloat(list);

        System.out.println(filePath);
        statisticsFloat.setCount();
        statisticsFloat.setSumma();
        statisticsFloat.setAvg();
        statisticsFloat.setMaxAndMin();
        System.out.println(statisticsFloat);
        System.out.println();
    }

    private void writeStatisticsString() throws FileNotFoundException {
        logger.info("In writeStatisticsString()");

        logger.info("Create CreatorFilePath");
        CreatorFilePath creator = new CreatorFilePath(context.getPath(), context.getPrefix(), "strings.txt");

        logger.info("Start creating filepath and prefix for output files");
        String filePath = creator.createFilePath();

        Reader reader = new Reader(filePath);
        List<String> list = reader.readListString();
        FullStatisticsString statisticsString = new FullStatisticsString(list);
        System.out.println(filePath);
        statisticsString.setCount();
        statisticsString.setMaxAndMin();
        System.out.println(statisticsString);
        System.out.println();

    }
}
