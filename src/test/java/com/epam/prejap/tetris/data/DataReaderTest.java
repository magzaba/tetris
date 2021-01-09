package com.epam.prejap.tetris.data;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.testng.Assert.assertEquals;

@Test(groups = "DataReader")
public class DataReaderTest {

    private final Path path = Paths.get("src/test/resources/testfiles/ReadFileTest.txt");

    @Test
    public void shallReadArrayWithLength10() throws IOException {
        //given
        DataReader reader = new DataReader(path);
        int expected = 10;

        //when
        int result = reader.readFromFile().length;

        //then
        assertEquals(result, expected);
    }


    @Test(dependsOnMethods = "shallReadArrayWithLength10", dataProvider = "defaultInitialHallOfFame")
    public void shallReadCorrectDataFromFile(HallOfFame[] expected) throws IOException {
        //given
        DataReader reader = new DataReader(path);

        //when
        HallOfFame[] result = reader.readFromFile();

        //then
        assertEquals(result, expected);
    }

    @DataProvider()
    public static Object[][] defaultInitialHallOfFame() {
        HallOfFame player1 = new HallOfFame("Pl1", 1);
        HallOfFame player2 = new HallOfFame("Pl2", 2);
        HallOfFame player3 = new HallOfFame("Pl3", 3);
        HallOfFame player4 = new HallOfFame("Pl4", 4);
        HallOfFame player5 = new HallOfFame("Pl5", 5);
        HallOfFame player6 = new HallOfFame("Pl6", 6);
        HallOfFame player7 = new HallOfFame("Pl7", 7);
        HallOfFame player8 = new HallOfFame("Pl8", 8);
        HallOfFame player9 = new HallOfFame("Pl9", 9);
        HallOfFame player10 = new HallOfFame("Pl10", 10);

        return new HallOfFame[][]{{player1, player2, player3, player4, player5, player6, player7, player8, player9, player10}};
    }
}
