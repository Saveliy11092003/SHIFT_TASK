package ru.nsu.trushkov.typeline;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.math.BigInteger;

public class TypeSpecifier {

    private static final Logger logger = LoggerFactory.getLogger(TypeSpecifier.class);

    public Type determineType(String str) {

        if (isInteger(str)) {
            logger.info("Type line INTEGER");
            return Type.INTEGER;
        } else if (isDouble(str)) {
            logger.info("Type line DOUBLE");
            return Type.DOUBLE;
        } else {
            logger.info("Type line STRING");
            return Type.STRING;
        }

    }


    private static boolean isInteger(String input) {
        try {
            logger.info("Check for integer type");
            BigInteger integer = new BigInteger(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }


    private static boolean isDouble(String input) {
        try {
            logger.info("Check for integer type");
            BigDecimal decimal = new BigDecimal(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
