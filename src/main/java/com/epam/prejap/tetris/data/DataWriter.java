package com.epam.prejap.tetris.data;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Path;

public class DataWriter {

    private final Path path;

    DataWriter(final Path path) {
        this.path = path;
    }

    void writeToFile(HallOfFame[] hallOfFames) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        mapper.writeValue(path.toFile(), hallOfFames);
    }

}
