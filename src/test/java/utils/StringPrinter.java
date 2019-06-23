package utils;

import mower.Printer;

import java.util.List;

public class StringPrinter implements Printer {


    private final StringBuilder builder;

    public StringPrinter() {
        this.builder = new StringBuilder();
    }

    public String showOutPut() {
        return builder.toString().trim();
    }


    @Override
    public void printMowing(List<String> results) {
        for (String line : results) {
            builder.append(line).append("\n");
        }

    }
}
