package com.epam.prejap.tetris.game;

import com.epam.prejap.tetris.block.BlockFeed;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.regex.Pattern;

import static org.testng.Assert.assertTrue;

@Test(groups = "Playfield", dependsOnGroups = "BlockRotation")
public class PlayfieldBlockRotationTest {

    private static final Pattern ANSI_COLOR_ESCAPE_CODES = Pattern.compile("\u001B\\[\\d*m");
    private static final ByteArrayOutputStream OUTPUT = new ByteArrayOutputStream();

    private final Referee referee = new Referee();
    private final Printer printer = new Printer(
            new PrintStream(OUTPUT),
            new Timer(500),
            referee
    );

    private final BlockFeed mockBlockFeed;
    private final Object[][] blockRotationsOnGridAfterUPKeyPresses;
    private final int gridRows;
    private final int gridColumns;

    public PlayfieldBlockRotationTest(TestPlayfieldBlockRotations testPlayfieldBlockRotations) {
        this.mockBlockFeed = testPlayfieldBlockRotations.mockBlockfeed();
        this.blockRotationsOnGridAfterUPKeyPresses = testPlayfieldBlockRotations.blockRotationsOnGrid();
        this.gridRows = testPlayfieldBlockRotations.gridRows();
        this.gridColumns = testPlayfieldBlockRotations.gridColumns();
    }

    @Test(groups = "BlockRotationInGame", dataProvider = "blockRotationsOnGridAfterUPKeyPresses")
    public void EachTimeUPKeyIsPressedBlockShallRotateOnlyOnceBeforeBeingMovedDown(
            int timesUPKeyIsPressed,
            String expectedGrid) {

        // given
        OUTPUT.reset();
        var gridWithoutObstacles = createGridWithoutObstacles();
        var playfield = new Playfield(mockBlockFeed, printer, gridWithoutObstacles, List.of(referee));
        playfield.nextBlock();

        // when
        for (int i = 0; i < timesUPKeyIsPressed; i++) {
            playfield.move(Move.UP);
        }

        // then
        assertTrue(
                ANSI_COLOR_ESCAPE_CODES
                        .matcher(OUTPUT.toString())
                        .replaceAll("")
                        .contains(expectedGrid)
        );
    }

    @DataProvider
    public Object[][] blockRotationsOnGridAfterUPKeyPresses() {
        return blockRotationsOnGridAfterUPKeyPresses;
    }

    private Grid createGridWithoutObstacles() {
        boolean areExtraBlockAdded = false;
        return Grid.getNewGrid(mockBlockFeed, gridRows, gridColumns, areExtraBlockAdded);
    }

}
