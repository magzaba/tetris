package com.epam.prejap.tetris.data;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.testng.Assert.assertEquals;

@Test(groups = "DataWriter")
public class DataWriterTest {

    private final Path writeFilePath = Paths.get("src/test/resources/testfiles/WriteFileTest.txt");

    @AfterMethod
    public void tearDown() throws IOException {
        Files.deleteIfExists(writeFilePath);
    }

    @Test(dependsOnGroups = "DataReader", dataProvider = "defaultInitialHallOfFame", dataProviderClass = DataReaderTest.class)
    public void shallWriteCorrectDataToFile(HallOfFameMember[] hallOfFameMembers) throws IOException {
        //given
        DataWriter writer = new DataWriter(writeFilePath);
        DataReader reader = new DataReader(writeFilePath);

        //when
        writer.writeToFile(hallOfFameMembers);
        HallOfFameMember[] result = reader.readFromFile();

        //then
        assertEquals(result, hallOfFameMembers);
    }
}
