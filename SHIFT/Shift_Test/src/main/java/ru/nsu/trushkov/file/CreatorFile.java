package ru.nsu.trushkov.file;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.nsu.trushkov.context.Context;

import java.io.File;
import java.io.IOException;

public class CreatorFile {

    private static final Logger logger = LoggerFactory.getLogger(CreatorFile.class);

    private final Context context;

    public CreatorFile(Context context) {
        this.context = context;
    }

    public File createFile(String nameFile) {

        logger.info("Create CreatorFilePath");
        CreatorFilePath creator = new CreatorFilePath(context.getPath(), context.getPrefix(), nameFile);

        logger.info("Start creating filepath and prefix for output files");
        String filePath = creator.createFilePath();

        File file = new File(filePath);

        if (!context.getAdd()) {
            boolean deleted = file.delete();
            if (deleted) {
                logger.info("File deleted because no flag -a");
            } else {
                logger.info("File wasn't deleted because there is flag -a");
            }
        }

        logger.info("checking file path is not null");
        if (context.getPath() != null) {

            logger.info("Getting parent directory");
            File parentDirectory = file.getParentFile();
            if (!parentDirectory.exists()) {
                logger.info("Parent directory doesn't exist" + parentDirectory);
                if (parentDirectory.mkdirs()) {
                    logger.info("Create parent directory");
                } else {
                    logger.info("Failed to create parent directory");
                }
            }

            try {
                logger.info("Attempt of creating file ");
                boolean created = file.createNewFile();
                if (created) {
                    logger.info("File created " + filePath);
                } else {
                    logger.info("File already exists or couldn't be created: " + filePath);
                }
            } catch (IOException e) {
                logger.error("Failed to create file " + filePath);
                logger.error(e.getMessage());
                throw new RuntimeException(e);
            }
        }

        return file;
    }
}
