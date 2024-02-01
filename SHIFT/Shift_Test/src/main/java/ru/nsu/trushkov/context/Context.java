package ru.nsu.trushkov.context;

import java.io.File;

public class Context {

    private String prefix;
    private String path;
    private String[] inputFilePaths;
    private Boolean isAdd;
    private Boolean isShort;
    private Boolean isFull;

    private File fileInt = null;
    private File fileDouble = null;
    private File fileString = null;

    private int countInt = 0;
    private int countDouble = 0;
    private int countString = 0;


    public String getPrefix() {
        return prefix;
    }

    public String getPath() {
        return path;
    }

    public String[] getInputFilePaths() {
        return inputFilePaths;
    }

    public Boolean getAdd() {
        return isAdd;
    }

    public Boolean getShort() {
        return isShort;
    }

    public Boolean getFull() {
        return isFull;
    }

    public File getFileInt() {
        return fileInt;
    }

    public File getFileDouble() {
        return fileDouble;
    }

    public File getFileString() {
        return fileString;
    }

    public int getCountInt() {
        return countInt;
    }

    public int getCountDouble() {
        return countDouble;
    }

    public int getCountString() {
        return countString;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setInputFilePaths(String[] inputFilePaths) {
        this.inputFilePaths = inputFilePaths;
    }


    public void setAdd(Boolean add) {
        isAdd = add;
    }

    public void setShort(Boolean aShort) {
        isShort = aShort;
    }

    public void setFull(Boolean full) {
        isFull = full;
    }

    public void setFileInt(File fileInt) {
        this.fileInt = fileInt;
    }

    public void setFileDouble(File fileDouble) {
        this.fileDouble = fileDouble;
    }

    public void setFileString(File fileString) {
        this.fileString = fileString;
    }

    public void setCountInt(int countInt) {
        this.countInt = countInt;
    }

    public void setCountDouble(int countDouble) {
        this.countDouble = countDouble;
    }

    public void setCountString(int countString) {
        this.countString = countString;
    }
}
