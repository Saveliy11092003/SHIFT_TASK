package ru.nsu.trushkov.statistics;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.List;

public class FullStatisticsFloat {
    private static final Logger logger = LoggerFactory.getLogger(FullStatisticsFloat.class);

    private int count;
    private BigDecimal summa = BigDecimal.ZERO;
    private BigDecimal avg;
    private BigDecimal min;
    private BigDecimal max;
    private List<BigDecimal> list;

    public FullStatisticsFloat(List<BigDecimal> list) {
        this.list = list;
    }

    public void setSumma() {
        for (BigDecimal element : list) {
            summa = summa.add(element);
        }
    }

    public void setAvg() {
        BigDecimal integer = new BigDecimal(String.valueOf(list.size()));
        avg = summa.divide(integer);
    }

    public void setCount() {
        count = list.size();
    }

    public void setMaxAndMin() {
        list.sort(BigDecimal::compareTo);

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
