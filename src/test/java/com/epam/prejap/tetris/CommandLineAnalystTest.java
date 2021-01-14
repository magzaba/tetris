package com.epam.prejap.tetris;

import com.epam.prejap.tetris.game.Move;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

@Test(groups = "NavigationKeys")
public class CommandLineAnalystTest {

    @DataProvider
    public static Object[] inputWithExactly4Characters() {
        return new Object[]{
                "q s d f",
                " a   z      g    f"
        };
    }

    @Test(dataProvider = "inputWithExactly4Characters")
    public void userCanModifyDefaultNavigationKeysProviding4CharactersSeparatedBySpaces(String input){
        //given
        char[] providedKeys = extractKeysFromInput(input);

        //when
        char[] navigationKeys = CommandLineAnalyst.checkArgsForNavigationKeys(input);

        //then
        assertEquals(navigationKeys, providedKeys, String.join("\n",
                "Navigation keys should have been modified but were not",
                "when providing 4 characters separated by spaces within the quotes \" \"."));
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
                "a s d",
                "a s d f g"
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
                "aa s d f",
                "a s dd f",
                "aa ss dd ff"
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
                "a a a a",
                "a a s d",
                "a s a s",
                "s a a d"
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
