package com.epam.prejap.tetris.data;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Path;

/**
 * The DataWriter class is responsible for writing data to file of specified {@link DataWriter#path}.
 */
public final class DataWriter {

    private final Path path;

    DataWriter(final Path path) {
        this.path = path;
    }

    /**
     * Writes array of {@link HallOfFame} objects to file.
     *
     * <p>Data is saved from array of {@link HallOfFame} objects to file of {@link DataWriter#path} in JSON array format
     * using Jackson library.
     *
     * @param hallOfFames - an array of {@link HallOfFame} objects
     * @throws IOException if writing to file unsuccessful
     */
    void writeToFile(HallOfFame[] hallOfFames) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        mapper.writeValue(path.toFile(), hallOfFames);
    }

}
