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
    public void shallReadCorrectDataFromFile(HallOfFameMember[] expected) throws IOException {
        //given
        DataReader reader = new DataReader(path);

        //when
        HallOfFameMember[] result = reader.readFromFile();

        //then
        assertEquals(result, expected);
    }

    @DataProvider()
    public static Object[][] defaultInitialHallOfFame() {
        HallOfFameMember player1 = new HallOfFameMember("Pl1", 1);
        HallOfFameMember player2 = new HallOfFameMember("Pl2", 2);
        HallOfFameMember player3 = new HallOfFameMember("Pl3", 3);
        HallOfFameMember player4 = new HallOfFameMember("Pl4", 4);
        HallOfFameMember player5 = new HallOfFameMember("Pl5", 5);
        HallOfFameMember player6 = new HallOfFameMember("Pl6", 6);
        HallOfFameMember player7 = new HallOfFameMember("Pl7", 7);
        HallOfFameMember player8 = new HallOfFameMember("Pl8", 8);
        HallOfFameMember player9 = new HallOfFameMember("Pl9", 9);
        HallOfFameMember player10 = new HallOfFameMember("P10", 10);

        return new HallOfFameMember[][]{{player1, player2, player3, player4, player5, player6, player7, player8, player9, player10}};
    }
}
