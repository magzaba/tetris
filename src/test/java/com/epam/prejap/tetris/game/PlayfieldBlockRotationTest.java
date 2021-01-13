package com.epam.prejap.tetris.game;

import com.epam.prejap.tetris.block.BlockFeed;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.testng.Assert.assertTrue;

@Test(groups = "BlockRotationInGame", dependsOnGroups = "BlockRotation")
public class PlayfieldBlockRotationTest {

    private final BlockFeed mockBlockFeed;
    private final Object[][] blockRotationsOnGridAfterUPKeyPresses;
    private final int gridRows;
    private final int gridColumns;

    public PlayfieldBlockRotationTest(PlayfieldBlockRotations playfieldBlockRotations) {
        this.mockBlockFeed = playfieldBlockRotations.mockBlockfeed();
        this.blockRotationsOnGridAfterUPKeyPresses = playfieldBlockRotations.blockRotationsOnGrid();
        this.gridRows = playfieldBlockRotations.gridRows();
        this.gridColumns = playfieldBlockRotations.gridColumns();
    }

    @Test(dataProvider = "blockRotationsOnGridAfterUPKeyPresses")
    public void EachTimeUPKeyIsPressedBlockShallRotateOnlyOnceBeforeBeingMovedDown(
            int timesUPKeyIsPressed,
            String expectedGrid) {

        // given
        var bos = new ByteArrayOutputStream();
        var printer = new Printer(new PrintStream(bos), new Timer(1));
        Playfield playfield = new Playfield(gridRows, gridColumns, mockBlockFeed, printer);
        playfield.nextBlock();

        // when
        for (int i = 0; i < timesUPKeyIsPressed; i++) {
            playfield.move(Move.UP);
        }

        // then
        assertTrue(bos.toString().contains(expectedGrid));
    }

    @DataProvider
    public Object[][] blockRotationsOnGridAfterUPKeyPresses() {
        return blockRotationsOnGridAfterUPKeyPresses;
    }

}
