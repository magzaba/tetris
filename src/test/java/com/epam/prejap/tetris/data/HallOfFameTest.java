package com.epam.prejap.tetris.data;

import com.epam.prejap.tetris.game.Printer;
import com.epam.prejap.tetris.game.Timer;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

@Test(groups = "HallOfFame")
public class HallOfFameTest {

    private Path readPath;
    private Path writePath;
    private Timer timer;
    private Printer printer;
    private DataReader reader;
    private DataWriter writer;

    @BeforeClass
    public void setUp() {
        readPath = Paths.get("src/test/resources/testfiles/ReadFileTest.txt");
        writePath = Paths.get("src/test/resources/testfiles/WriteFileTest.txt");
        timer = new Timer(500);
        printer = new Printer(System.out, timer);
        reader = new DataReader(readPath);
        writer = new DataWriter(writePath);
    }


    @AfterMethod
    public void tearDown() throws IOException {
        Files.deleteIfExists(writePath);
    }

    @Test(dataProvider = "mockHallOfFameMembers")
    public void tryToEnterHallOfFameShallBeTrueForHigherScoreThanExistingOnes(HallOfFameMember[] mockMembers) throws IOException {
        //given
        var hallOfFame = new HallOfFame(reader, writer, printer, new ArrayList<>(Arrays.asList(mockMembers)));
        Scanner in = new Scanner("Moc");

        //when
        boolean result = hallOfFame.tryToEnterHallOfFame(100, in);

        //then
        assertTrue(result, "Shall return true, but it did not");
    }

    @Test(dataProvider = "mockHallOfFameMembers")
    public void tryToEnterHallOfFameShallBeFalseForLowerScoreThanExistingOnes(HallOfFameMember[] mockMembers) throws IOException {
        //given
        var hallOfFame = new HallOfFame(reader, writer, printer, new ArrayList<>(Arrays.asList(mockMembers)));
        Scanner in = new Scanner("Moc");

        //when
        boolean result = hallOfFame.tryToEnterHallOfFame(1, in);

        //then
        assertFalse(result, "Shall return false, but it did not");
    }

    @DataProvider()
    public static Object[] mockHallOfFameMembers() {
        HallOfFameMember[] mock1 = new HallOfFameMember[]{
                new HallOfFameMember("n10", 10),
                new HallOfFameMember("n15", 15),
                new HallOfFameMember("n20", 20),
                new HallOfFameMember("n25", 25),
                new HallOfFameMember("n30", 30),
        };

        HallOfFameMember[] mock2 = new HallOfFameMember[]{
                new HallOfFameMember("n5", 5),
                new HallOfFameMember("n6", 6),
                new HallOfFameMember("n7", 7),
                new HallOfFameMember("n8", 8),
                new HallOfFameMember("n9", 9),
        };

        return new Object[]{mock1, mock2};
    }

    @Test
    public void testEnterHallOfFame() {
        //given

        //when

        //then

    }
}
