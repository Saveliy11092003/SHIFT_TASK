package ru.nsu.trushkov.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.nsu.trushkov.Main;
import ru.nsu.trushkov.context.Context;
import ru.nsu.trushkov.file.CreatorFile;
import ru.nsu.trushkov.file.Reader;
import ru.nsu.trushkov.file.Writer;
import ru.nsu.trushkov.typeline.Type;
import ru.nsu.trushkov.typeline.TypeSpecifier;

import java.io.File;
import java.io.IOException;

public class Filter {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    private final Context context;
    private boolean existInt = false;
    private boolean existDouble = false;
    private boolean existString = false;

    public Filter(Context context) {
        this.context = context;
    }

    public void filtrate(String inputFilePath) throws IOException {

        logger.info("Create Reader");
        Reader reader = new Reader(inputFilePath);

        logger.info("Create TypeSpecifier");
        TypeSpecifier typeSpecifier = new TypeSpecifier();

        String line;
        File file = null;

        logger.info("Create Writer");
        Writer writer = new Writer();

        logger.info("Create CreatorFile");
        CreatorFile creatorFile = new CreatorFile(context);

        logger.info("Init countInt, countDouble, countString");
        int countInt = 0;
        int countDouble = 0;
        int countString = 0;

        logger.info("Enter the while");

        while ((line = reader.readLine()) != null) {

            logger.info("Determine type line");
            Type typeLine = typeSpecifier.determineType(line);

            if (typeLine == Type.INTEGER && !existInt) {
                existInt = true;
                logger.info("File integers.txt exists");
                context.setFileInt(creatorFile.createFile("integers.txt"));
            }
            if (typeLine == Type.DOUBLE && !existDouble) {
                existDouble = true;
                logger.info("File floats.txt exists");
                context.setFileDouble(creatorFile.createFile("floats.txt"));
            }
            if (typeLine == Type.STRING && !existString) {
                existString = true;
                logger.info("File strings.txt exists");
                context.setFileString(creatorFile.createFile("strings.txt"));
            }

            if (typeLine == Type.INTEGER) {
                file = context.getFileInt();
                countInt++;
            }

            if (typeLine == Type.DOUBLE) {
                file = context.getFileDouble();
                countDouble++;
            }

            if (typeLine == Type.STRING) {
                file = context.getFileString();
                countString++;
            }

            logger.info("Write in file " + file);
            writer.write(file, line);

        }
        logger.info("Exit the while");

        logger.info("Update countInt, countDouble, countString in context");
        context.setCountInt(context.getCountInt() + countInt);
        context.setCountDouble(context.getCountDouble() + countDouble);
        context.setCountString(context.getCountString() + countString);

    }
}
