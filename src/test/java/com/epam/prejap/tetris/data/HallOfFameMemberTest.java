package com.epam.prejap.tetris.data;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

@Test(groups = "HallOfFameMember")
public class HallOfFameMemberTest {

    @Test(dataProvider = "lowerHigherIntPairs")
    public void shallReturnNegativeWhenComparingToLowerPoints(int lower, int higher) {
        //given
        HallOfFameMember lowerPoints = new HallOfFameMember("lower", lower);
        HallOfFameMember higherPoints = new HallOfFameMember("higher", higher);


        //when
        int actual = higherPoints.compareTo(lowerPoints);

        //then
        assertTrue(actual < 0, "Shall return negative number, but it did not");
    }

    @DataProvider()
    public static Object[][] lowerHigherIntPairs() {
        return new Object[][]{
                {0, 1},
                {1, 2},
                {2, 3},
                {3, 4},
        };
    }

    @Test(dataProvider = "lowerHigherIntPairs")
    public void shallReturnPositiveWhenComparingToHigherPoints(int lower, int higher) {
        //given
        HallOfFameMember lowerPoints = new HallOfFameMember("lower", lower);
        HallOfFameMember higherPoints = new HallOfFameMember("higher", higher);


        //when
        int actual = lowerPoints.compareTo(higherPoints);

        //then
        assertTrue(actual > 0, "Shall return positive number, but it did not");
    }
}
