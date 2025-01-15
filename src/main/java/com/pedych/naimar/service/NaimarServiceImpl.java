package com.pedych.naimar.service;

import com.pedych.naimar.bean.Naimar;
import com.pedych.naimar.csv.CsvParser;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

@Component
public class NaimarServiceImpl implements NaimarService {

    private final CsvParser<String, Naimar> csvParser;

    public NaimarServiceImpl(CsvParser<String, Naimar> csvParser) {
        this.csvParser = csvParser;
    }

    @Override
    public List<Naimar> parseCsvToList(Path path) {
        try (Stream<String> lines = Files.lines(path)) {
            return lines.skip(1)//TODO refactor skip header option
                    .map(csvParser::parseLine)
                    .toList();
        } catch (IOException e) {
            //TODO log exception
            throw new RuntimeException(e);
        }
    }

}
