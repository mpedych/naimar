package com.pedych.naimar.csv;

public interface CsvParser<I, O> {
    O parseLine(I input);
}
