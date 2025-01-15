package com.pedych.naimar.service;

import com.pedych.naimar.bean.Naimar;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

public interface NaimarService {

    List<Naimar> parseCsvToList(Path path);

}
