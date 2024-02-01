package ru.nsu.trushkov.statistics;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class FullStatisticsString {
    private static final Logger logger = LoggerFactory.getLogger(FullStatisticsString.class);

    private int count;
    private int min;
    private int max;
    private List<String> list;

    public FullStatisticsString(List<String> list) {
        this.list = list;
    }

    public void setCount() {
        count = list.size();
    }

    public void setMaxAndMin() {
        list.sort((x, y) -> {
            if (x.length() > y.length()) {
                return 1;
            } else if (x.length() < y.length()) {
                return -1;
            } else {
                return 0;
            }
        });

        min = list.get(0).length();
        max = list.get(list.size() - 1).length();
    }

    @Override
    public String toString() {
        return "Statistics - {" +
                "count=" + count +
                ", min=" + min +
                ", max=" + max +
                '}';
    }
}
