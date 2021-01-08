package com.epam.prejap.tetris.data;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Path;

final class DataReader {

    private final Path path;

    DataReader(final Path path) {
        this.path = path;
    }

    HallOfFame[] readFromFile() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(path.toFile(), HallOfFame[].class);
    }

}
