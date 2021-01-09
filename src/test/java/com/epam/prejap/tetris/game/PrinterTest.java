package com.epam.prejap.tetris.game;

import com.epam.prejap.tetris.data.HallOfFame;
import com.epam.prejap.tetris.data.HallOfFameMember;
import org.mockito.Mockito;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

import static org.testng.Assert.*;

@Test(groups = "Timer")
public class PrinterTest {

    private ByteArrayOutputStream bos;
    private final byte[][] emptyGrid = new byte[][]{new byte[]{}};

    @BeforeMethod
    public void setUp() {
        bos = new ByteArrayOutputStream();
    }

    @DataProvider
    public Object[][] validTimerDurations() {
        return new Object[][]{{500, 14, "Time: 00:00:07"},
                {1000, 167, "Time: 00:02:47"},
                {1000, 4224, "Time: 01:10:24"},
                {3600000, 25, "Time: 25:00:00"},
                {1000, 25, "Time: 00:00:25"},
                {1000, 84, "Time: 00:01:24"},
                {1000, 5840, "Time: 01:37:20"},
                {3600000, 26, "Time: 26:00:00"}};
    }

    @Test(dataProvider = "validTimerDurations")
    public void drawShouldPrintValidHeader(int tickDurationInMillis, int cycles, String message) {
        // given
        Timer timer = new Timer(tickDurationInMillis);
        Printer printer = Mockito.spy(new Printer(new PrintStream(bos), timer));
        for (int i = 0; i < cycles; i++) {
            timer.tick();
        }
        // when
        printer.draw(emptyGrid);
        // then
        Mockito.verify(printer).header();
        assertTrue(bos.toString().contains(message));
    }

    @Test(dataProvider = "mockHallOfFame30Members")
    public void hallOfFameShallPrintMax25Entries(HallOfFameMember[] mockMembers){
        //given
        SoftAssert softAssert = new SoftAssert();
        Timer timer = new Timer(1);
        Printer printer = new Printer(new PrintStream(bos), timer);

        //when
        printer.hallOfFame(new ArrayList<>(Arrays.asList(mockMembers)));

        //then
        softAssert.assertTrue(bos.toString().contains("1"));
        softAssert.assertTrue(bos.toString().contains("25"));
        softAssert.assertFalse(bos.toString().contains("26"));
        softAssert.assertFalse(bos.toString().contains("30"));
        softAssert.assertAll("Shall print only 25 elements, but it did not");

    }

    @Test(dataProvider = "scannerMoreThan3CharsInput", expectedExceptions = InputMismatchException.class)
    public void shallNotReadNameWithMoreThan3Chars(String name){
        //given
        Timer timer = new Timer(1);
        Printer printer = new Printer(new PrintStream(bos), timer);
        Scanner in = new Scanner(name);

        //when
        HallOfFameMember actual = printer.readInitials(1, in);

        //then
        assertThrows(InputMismatchException::new);
    }

    @DataProvider()
    public static Object[] mockHallOfFame30Members() {
        HallOfFameMember[] mock1 = new HallOfFameMember[30];
        Arrays.fill(mock1, new HallOfFameMember("one", 1));
        return new Object[]{mock1};
    }

    @DataProvider()
    public static Object[] scanner3CharsInput() {
        return new Object[]{
                "one",
                "two",
                "123",
                "...",
                "!`!"
        };
    }

    @DataProvider()
    public static Object[] scannerMoreThan3CharsInput() {
        return new Object[]{
                "oneone",
                "twotwo",
                "123123",
                "......",
                "!`!!`!"
        };
    }
}
