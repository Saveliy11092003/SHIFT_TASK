package ru.nsu.trushkov.statistics;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.nsu.trushkov.context.Context;

public class FactoryCreaterStatistics {

    private static final Logger logger = LoggerFactory.getLogger(FactoryCreaterStatistics.class);

    private final Context context;

    public FactoryCreaterStatistics(Context context) {
        this.context = context;
    }

    public WriterStatistics create() {
        if (context.getFull()) {
            logger.info("Create WriterFullStatistics");
            return new WriterFullStatistics(context);
        } else {
            logger.info("Create WriterSimpleStatistics");
            return new WriterSimpleStatistics(context);
        }
    }
}
