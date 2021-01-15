package com.epam.prejap.tetris.data;

import com.epam.prejap.tetris.game.Printer;
import com.epam.prejap.tetris.game.Timer;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

import static org.testng.Assert.*;

@Test(groups = "HallOfFameList")
public class HallOfFameTest {

    private Path readPath;
    private Path writePath;
    private Timer timer;
    private Printer printer;
    private DataReader reader;
    private DataWriter writer;


    @BeforeClass
    public void setUp() {
        readPath = Paths.get("src/test/resources/testfiles/ReadFileTest.json");
        writePath = Paths.get("src/test/resources/testfiles/WriteFileTest.txt");
        timer = new Timer(500);
        printer = new Printer(System.out, timer, null);
        reader = new DataReader(readPath);
        writer = new DataWriter(writePath);
    }

    @AfterMethod
    public void tearDown() throws IOException {
        Files.deleteIfExists(writePath);
    }

    @Test(groups = "TryToEnter", dataProvider = "mockHallOfFameMembers")
    public void tryToEnterHallOfFameShallBeTrueForHigherScoreThanExistingOnes(HallOfFameMember[] mockMembers) {
        //given
        var hallOfFame = new HallOfFame(reader, writer, printer, new ArrayList<>(Arrays.asList(mockMembers)));

        //when
        boolean result = hallOfFame.tryToEnter(100);

        //then
        assertTrue(result, "Shall have returned true, but it did not");
    }

    @Test(groups = "TryToEnter", dataProvider = "mockHallOfFameMembers")
    public void tryToEnterHallOfFameShallBeFalseForLowerScoreThanExistingOnes(HallOfFameMember[] mockMembers) {
        //given
        var hallOfFame = new HallOfFame(reader, writer, printer, new ArrayList<>(Arrays.asList(mockMembers)));

        //when
        boolean result = hallOfFame.tryToEnter(1);

        //then
        assertFalse(result, "Shall have returned false, but it did not");
    }

    @DataProvider()
    public static Object[] mockHallOfFameMembers() {
        HallOfFameMember[] mock1 = IntStream.range(10,20)
                .mapToObj(i -> new HallOfFameMember("P" + i, i))
                .toArray(HallOfFameMember[]::new);

        HallOfFameMember[] mock2 = IntStream.range(4,14)
                .mapToObj(i -> new HallOfFameMember("P" + i, i))
                .toArray(HallOfFameMember[]::new);

        return new Object[]{mock1, mock2};
    }

    @Test(dependsOnGroups = "TryToEnter", dataProvider = "mockHallOfFameMembers")
    public void shallAddOneNewMemberToHallOfFame(HallOfFameMember[] mockMembers) {
        //given
        SoftAssert softAssert = new SoftAssert();
        var hallOfFame = new HallOfFame(reader, writer, printer, new ArrayList<>(Arrays.asList(mockMembers)));
        HallOfFameMember newMember = new HallOfFameMember("tst", 0);

        //when
        List<HallOfFameMember> updatedMembers = hallOfFame.enterHallOfFame(newMember);
        boolean containsNewMember = updatedMembers.contains(newMember);
        long onlyOne = updatedMembers.stream()
                .filter(e -> e.equals(newMember))
                .count();

        //then
        softAssert.assertTrue(containsNewMember);
        softAssert.assertEquals(onlyOne, 1L);
        softAssert.assertEquals(updatedMembers.size(), mockMembers.length + 1);
        softAssert.assertAll("Should have added element to list once, but it did not");
    }

    @Test(dataProvider = "playerInitialsLongerThan3Chars")
    public void shallReducePlayersNameWhenLongerThan3Chars(String name) {
        //given
        SoftAssert softAssert = new SoftAssert();
        Timer timer = new Timer(1);
        HallOfFame hallOfFame = new HallOfFame(printer);

        //when
        HallOfFameMember actual = hallOfFame.createNewMember(1, name);

        //then
        softAssert.assertEquals(actual.name().length(), 3);
        softAssert.assertEquals(actual.name(), name.substring(0, 3));
        softAssert.assertAll("Shall shorten name to 3 characters but it did not");
    }

    @Test(dataProvider = "playerInitialsNoLongerThan3Chars")
    public void shallNotReducePlayersNameWhenNoLongerThan3Chars(String name) {
        //given
        Timer timer = new Timer(1);
        HallOfFame hallOfFame = new HallOfFame(printer);

        //when
        HallOfFameMember actual = hallOfFame.createNewMember(1, name);

        //then
        assertEquals(actual.name(), name);
    }

    @DataProvider()
    public static Object[] playerInitialsLongerThan3Chars() {
        return new Object[]{
                "oneone",
                "twotwo",
                "123123",
                "......",
                "!`!!`!"
        };
    }

    @DataProvider()
    public static Object[] playerInitialsNoLongerThan3Chars() {
        return new Object[]{
                "one",
                "12",
                "1",
                "",
        };
    }

    @Test(dataProvider = "mockHallOfFame30Members")
    public void toStringShallContainMax25Entries(HallOfFameMember[] mockMembers) {
        //given
        SoftAssert softAssert = new SoftAssert();
        HallOfFame hallOfFame = new HallOfFame(reader, writer, printer, Arrays.asList(mockMembers));

        //when
        String actual = hallOfFame.toString();

        //then
        softAssert.assertTrue(actual.contains("1"));
        softAssert.assertTrue(actual.contains("25"));
        softAssert.assertFalse(actual.contains("26"));
        softAssert.assertFalse(actual.contains("30"));
        softAssert.assertAll("Should have printed only 25 elements, but it did not");

    }


    @DataProvider()
    public static Object[] mockHallOfFame30Members() {
        HallOfFameMember[] mock1 = new HallOfFameMember[30];
        Arrays.fill(mock1, new HallOfFameMember("one", 1));
        return new Object[]{mock1};
    }

}
