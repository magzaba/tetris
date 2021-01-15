package com.epam.prejap.tetris.data;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.IntStream;

import static org.testng.Assert.assertEquals;

@Test(groups = "DataReader")
public class DataReaderTest {

    private final Path path = Paths.get("src/test/resources/testfiles/ReadFileTest.json");

    @Test
    public void shallReadArrayWithLength10() {
        //given
        DataReader reader = new DataReader(path);
        int expected = 10;

        //when
        int result = reader.readFromFile().length;

        //then
        assertEquals(result, expected);
    }


    @Test(dependsOnMethods = "shallReadArrayWithLength10", dataProvider = "defaultInitialHallOfFame")
    public void shallReadCorrectDataFromFile(HallOfFameMember[] expected) {
        //given
        DataReader reader = new DataReader(path);

        //when
        HallOfFameMember[] result = reader.readFromFile();

        //then
        assertEquals(result, expected);
    }

    @DataProvider()
    public static Object[][] defaultInitialHallOfFame() {

        HallOfFameMember[] members = IntStream.range(1, 11)
                .mapToObj(i -> new HallOfFameMember("P" + i, i))
                .toArray(HallOfFameMember[]::new);

        return new HallOfFameMember[][]{members};
    }
}
