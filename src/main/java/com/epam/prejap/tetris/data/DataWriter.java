package com.epam.prejap.tetris.data;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Path;

/**
 * The DataWriter class is responsible for writing data to file of specified {@link DataWriter#path}.
 */
final class DataWriter {

    private final Path path;

    public DataWriter(final Path path) {
        this.path = path;
    }

    /**
     * Writes array of {@link HallOfFameMember} objects to file.
     *
     * <p>Data is saved from array of {@link HallOfFameMember} objects to file of {@link DataWriter#path} in JSON array format
     * using Jackson library.
     *
     * <p>When there is IOException thrown by ObjectMapper, error is printed out.
     *
     * @param hallOfFameMembers - an array of {@link HallOfFameMember} objects
     */
    void writeToFile(HallOfFameMember[] hallOfFameMembers) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);

        try {
            mapper.writeValue(path.toFile(), hallOfFameMembers);
        } catch (IOException e) {
            System.err.println("Error occurred when writing to file");
        }
    }

}
