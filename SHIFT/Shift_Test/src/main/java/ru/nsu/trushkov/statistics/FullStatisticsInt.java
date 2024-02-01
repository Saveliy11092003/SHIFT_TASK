package ru.nsu.trushkov.statistics;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigInteger;
import java.util.List;

public class FullStatisticsInt {

    private static final Logger logger = LoggerFactory.getLogger(FullStatisticsInt.class);

    private int count;
    private BigInteger summa = BigInteger.ZERO;
    private BigInteger avg;
    private BigInteger min;
    private BigInteger max;
    private List<BigInteger> list;

    public FullStatisticsInt(List<BigInteger> list) {
        this.list = list;
    }

    public void setSumma() {
        for (BigInteger element : list) {
            summa = summa.add(element);
        }
    }

    public void setAvg() {
        BigInteger integer = new BigInteger(String.valueOf(list.size()));
        avg = summa.divide(integer);
    }

    public void setCount() {
        count = list.size();
    }

    public void setMaxAndMin() {
        list.sort(BigInteger::compareTo);

        min = list.get(0);
        max = list.get(list.size() - 1);
    }

    @Override
    public String toString() {
        return "Statistics - {" +
                "count=" + count +
                ", summa=" + summa +
                ", avg=" + avg +
                ", min=" + min +
                ", max=" + max +
                '}';
    }
}
