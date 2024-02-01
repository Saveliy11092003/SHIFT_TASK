package ru.nsu.trushkov;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.nsu.trushkov.commandline.CommandLineParser;
import ru.nsu.trushkov.context.Context;
import ru.nsu.trushkov.filter.Filter;
import ru.nsu.trushkov.statistics.FactoryCreaterStatistics;
import ru.nsu.trushkov.statistics.WriterStatistics;

import java.io.IOException;


public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);


    public static void main(String[] args) throws IOException {
        logger.info("Create Context");
        Context context = new Context();
        logger.info("Create Manager");
        Filter filter = new Filter(context);
        logger.info("Create CommandLineParser");
        CommandLineParser commandLineParser = new CommandLineParser();
        logger.info("Start parsing args");
        commandLineParser.parse(args, context);
        for (String filePath : context.getInputFilePaths()) {
            logger.info("Start filtering the file " + filePath);
            filter.filtrate(filePath);
        }

        logger.info("start checking flags of statistics");
        if (context.getFull() || context.getShort()) {
            logger.info("Create FactoryCreaterStatistics");
            FactoryCreaterStatistics factory = new FactoryCreaterStatistics(context);
            logger.info("Create WriterStatistic");
            WriterStatistics writer = factory.create();
            logger.info("Write statistics to the console");
            writer.writeStatistics();
        }
    }
}