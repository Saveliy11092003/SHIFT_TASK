package ru.nsu.trushkov.commandline;

import org.apache.commons.cli.*;
import org.apache.commons.cli.Options;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.nsu.trushkov.context.Context;


public class CommandLineParser {
    private static final Logger logger = LoggerFactory.getLogger(CommandLineParser.class);

    public void parse(String[] args, Context context) {
        Options options = new Options();

        logger.info("Add command line flags");
        options.addOption("p", "prefix", true, "Prefix  for output files");
        options.addOption("o", "output", true, "Output path");
        options.addOption("a", "add", false, "Add info to existing files");
        options.addOption("s", "short", false, "Short statistics");
        options.addOption("f", "full", false, "Full statistics");

        logger.info("Create DefaultParser");
        DefaultParser parser = new DefaultParser();
        try {
            logger.info("Parse command line");
            CommandLine cmd = parser.parse(options, args);

            logger.info("Init filepath in context");
            context.setPath(cmd.getOptionValue("output"));

            logger.info("Init prefix in context");
            context.setPrefix(cmd.getOptionValue("prefix"));

            logger.info("Init isAdd in context");
            context.setAdd(cmd.hasOption("add"));

            logger.info("Init isShort in context");
            context.setShort(cmd.hasOption("short"));

            logger.info("Init isFull in context");
            context.setFull(cmd.hasOption("full"));

            logger.info("Init input filepaths in context");
            context.setInputFilePaths(cmd.getArgs());

        } catch (ParseException e) {
            logger.error("Error parsing command line: " + e.getMessage());
        }
    }
}
