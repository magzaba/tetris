package com.epam.prejap.tetris.data;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Path;

/**
 * The DataReader class is responsible for reading data to file of specified {@link DataReader#path}.
 */
final class DataReader {

    private final Path path;

    public DataReader(final Path path) {
        this.path = path;
    }

    /**
     * Returns array of {@link HallOfFameMember} objects.
     *
     * <p>Data is read from resource file of specified {@link DataReader#path} using Jackson library, when unsuccessful
     * error message is printed out and empty array returned.
     *
     * <p>File contains array of JSON object mapped to array of {@link HallOfFameMember}.
     *
     * @return HallOfFame[]
     */
    public HallOfFameMember[] readFromFile() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(path.toFile(), HallOfFameMember[].class);
        } catch (IOException e) {
            System.err.println("Returned empty array. Error occurred when reading HallOfFame members from file, path: " + path);
        }
        return new HallOfFameMember[0];
    }

}
