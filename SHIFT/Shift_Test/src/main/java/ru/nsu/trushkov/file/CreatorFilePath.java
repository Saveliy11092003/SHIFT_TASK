package ru.nsu.trushkov.file;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.nsu.trushkov.Main;

public class CreatorFilePath {

    private static final Logger logger = LoggerFactory.getLogger(CreatorFilePath.class);

    private final String path;
    private final String prefix;
    private final String nameFile;

    public CreatorFilePath(String path, String prefix, String nameFile) {
        this.path = path;
        this.prefix = prefix;
        this.nameFile = nameFile;
    }

    public String createFilePath() {
        logger.info("Create filePath");
        if (path == null && prefix != null) {
            return prefix + nameFile;
        } else if (path != null && prefix != null) {
            return path + "/" + prefix + nameFile;
        } else if (path == null) {
            return nameFile;
        } else {
            return path + "/" + nameFile;
        }
    }
}
