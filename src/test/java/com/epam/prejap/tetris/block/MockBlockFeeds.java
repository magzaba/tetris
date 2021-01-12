package com.epam.prejap.tetris.block;

import java.util.function.Supplier;

public class MockBlockFeeds extends BlockFeed {

    private final Supplier<Block> blockSupplier;

    public static BlockFeed iBlockFeed() {
        return new MockBlockFeeds(IBlock::new);
    }

    public static BlockFeed jBlockFeed() {
        return new MockBlockFeeds(JBlock::new);
    }

    public static BlockFeed lBlockFeed() {
        return new MockBlockFeeds(LBlock::new);
    }

    public static BlockFeed oBlockFeed() {
        return new MockBlockFeeds(OBlock::new);
    }

    private MockBlockFeeds(Supplier<Block> blockSupplier) {
        this.blockSupplier = blockSupplier;
    }

    @Override
    public Block nextBlock() {
        return blockSupplier.get();
    }

}
