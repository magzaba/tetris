package com.epam.prejap.tetris.block;

import java.util.function.Supplier;

public class MockBlockFeed extends BlockFeed {

    private final Supplier<Block> blockSupplier;

    public static BlockFeed iBlockFeed() {
        return new MockBlockFeed(IBlock::new);
    }

    public static BlockFeed jBlockFeed() {
        return new MockBlockFeed(JBlock::new);
    }

    public static BlockFeed lBlockFeed() {
        return new MockBlockFeed(LBlock::new);
    }

    public static BlockFeed oBlockFeed() {
        return new MockBlockFeed(OBlock::new);
    }

    private MockBlockFeed(Supplier<Block> blockSupplier) {
        this.blockSupplier = blockSupplier;
    }

    @Override
    public Block nextBlock() {
        return blockSupplier.get();
    }

}
