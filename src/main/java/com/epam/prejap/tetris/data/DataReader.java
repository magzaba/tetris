package com.epam.prejap.tetris.data;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Path;

/**
 * The DataReader class is responsible for reading data to file of specified {@link DataReader#path}.
 */
public final class DataReader {

    private final Path path;

    public DataReader(final Path path) {
        this.path = path;
    }

    /**
     * Returns array of {@link HallOfFame} objects.
     *
     * <p>Data is read from resource file of specified {@link DataReader#path} using Jackson library.
     *
     * <p>File contains array of JSON object mapped to array of {@link HallOfFame}.
     *
     * @return HallOfFame[]
     * @throws IOException if reading file unsuccessful
     */
    public HallOfFame[] readFromFile() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(path.toFile(), HallOfFame[].class);
    }

}
