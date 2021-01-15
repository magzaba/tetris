package com.epam.prejap.tetris;

import com.epam.prejap.tetris.game.Move;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

@Test(groups = "NavigationKeys")
public class CommandLineAnalystTest {

    @DataProvider
    public static Object[] inputWithExactly5Characters() {
        return new Object[]{
                "q s d f w",
                " a   z  y  f  g  "
        };
    }

    @Test(dataProvider = "inputWithExactly5Characters")
    public void userCanModifyDefaultNavigationKeysProviding3CharactersSeparatedBySpaces(String input){
        //given
        char[] providedKeys = extractKeysFromInput(input);

        //when
        char[] navigationKeys = CommandLineAnalyst.checkArgsForNavigationKeys(input);

        //then
        assertEquals(navigationKeys, providedKeys, String.join("\n",
                "Navigation keys should have been modified but were not",
                "when providing 5 characters separated by spaces within the quotes \" \"."));
    }

    private char[] extractKeysFromInput(String arg0) {
        return arg0.replaceAll("\\s", "").toCharArray();
    }

    @DataProvider
    public static Object[] nullOrBlankArgument() {
        return new Object[]{
                null,
                "",
                " ",
                "        "
        };
    }

    @Test(dataProvider = "nullOrBlankArgument")
    public void gameContinuesWithDefaultKeysIfNoOrBlankArgumentProvided(String input) {
        //given
        char[] defaultKeys = Move.DEFAULT_KEYS;

        //when
        char[] navigationKeys = CommandLineAnalyst.checkArgsForNavigationKeys(input);

        //then
        assertEquals(navigationKeys, defaultKeys,
                "Navigation keys should be default but are not when no argument or blank argument provided.");
    }

    @DataProvider
    public static Object[] incorrectAmountOfValues() {
        return new Object[]{
                "a",
                "a s",
                "a s d f",
                "a s d f g y"
        };
    }

    @Test(
            dataProvider = "incorrectAmountOfValues",
            expectedExceptions = IllegalArgumentException.class,
            expectedExceptionsMessageRegExp = "Incorrect amount of values provided for navigation keys."
    )
    public void programThrowsExceptionWhenIncorrectAmountOfValuesProvided(String input) {
        CommandLineAnalyst.checkArgsForNavigationKeys(input);
    }

    @DataProvider
    public static Object[] inputWithNonCharacterValues() {
        return new Object[]{
                "aa s d f x",
                "a ss d f x",
                "a s dd f x",
                "aa ss dd ff xx"
        };
    }

    @Test(
            dataProvider = "inputWithNonCharacterValues",
            expectedExceptions = IllegalArgumentException.class,
            expectedExceptionsMessageRegExp = "Each navigation key should be represented by a single character."
    )
    public void programThrowsExceptionWhenInputWithNonCharacterValuesProvided(String input) {
        CommandLineAnalyst.checkArgsForNavigationKeys(input);
    }

    @DataProvider
    public static Object[] inputWithRepeatingKeys() {
        return new Object[]{
                "a a a a a",
                "a a s d d",
                "a s a s a",
                "s a a d a"
        };
    }

    @Test(
            dataProvider = "inputWithRepeatingKeys",
            expectedExceptions = IllegalArgumentException.class,
            expectedExceptionsMessageRegExp = "Each navigation key should be represented by a different character."
    )
    public void programThrowsExceptionWhenInputWithRepeatingKeysProvided(String input) {
        CommandLineAnalyst.checkArgsForNavigationKeys(input);
    }
}
