package com.epam.prejap.tetris.block;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.function.Supplier;

@Test(groups = "Block")
public class BlockFeedTests {

    @Test
    public void blockListContainsSBlock() {
        BlockFeed blockFeed = new BlockFeed();
        boolean containsSBlock = blockFeed.getAllBlocks().stream().map(Supplier::get).anyMatch(e -> e instanceof SBlock);
        Assert.assertTrue(containsSBlock, "Block feed must contain SBlock");
    }
}
