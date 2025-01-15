package com.pedych.naimar.csv;

import com.pedych.naimar.bean.Naimar;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomCsvParser implements CsvParser<String, Naimar> {

    @Override
    public Naimar parseLine(String line) {
        List<String> values = new ArrayList<>();
        StringBuilder current = new StringBuilder();
        boolean inQuotes = false;
        for (char c : line.toCharArray()) {
            if (c == '\"') {
                inQuotes = !inQuotes;
            } else if (c == ',' && !inQuotes) {
                values.add(current.toString());
                current.setLength(0);
            } else {
                current.append(c);
            }
        }
        values.add(current.toString());
        return new Naimar(values.get(0), values.get(1), values.get(2), values.get(3));
    }
}
