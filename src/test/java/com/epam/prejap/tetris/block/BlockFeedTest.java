package com.epam.prejap.tetris.block;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

@Test(groups = {"Block", "BlockFeed"})
public class BlockFeedTest {

    @Test
    public void shallContainLBlock() {
        //given
        BlockFeed feed = new BlockFeed();

        //when
        boolean containsLBlock = feed.blocks()
                .stream()
                .map(Supplier::get)
                .anyMatch(e -> e instanceof LBlock);

        //then
        assertTrue(containsLBlock);
    }

    @Test(dependsOnMethods = "shallContainLBlock")
    public void shallContainOnlyOneLBlock() {
        //given
        BlockFeed feed = new BlockFeed();

        //when
        List<Block> blocks = feed.blocks()
                .stream()
                .map(Supplier::get)
                .filter(e -> e instanceof LBlock)
                .collect(Collectors.toList());

        //then
        assertEquals(blocks.size(), 1);
    }

    @Test
    public void shallContainSBlock() {
        //given
        BlockFeed blockFeed = new BlockFeed();

        //when
        boolean containsSBlock = blockFeed.blocks()
                .stream()
                .map(Supplier::get)
                .anyMatch(e -> e instanceof SBlock);

        //then
        assertTrue(containsSBlock, "Block feed must contain SBlock");
    }

    @Test(dependsOnMethods = "shallContainSBlock")
    public void shallContainOnlyOneSBlock() {
        //given
        BlockFeed feed = new BlockFeed();

        //when
        List<Block> blocks = feed.blocks()
                .stream()
                .map(Supplier::get)
                .filter(e -> e instanceof SBlock)
                .collect(Collectors.toList());

        //then
        assertEquals(blocks.size(), 1, "Block feed should contain only one SBlock");
    }
}
