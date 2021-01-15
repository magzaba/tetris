package com.epam.prejap.tetris.block;

import java.util.function.Supplier;

public class TestMockBlockFeed extends BlockFeed {

    private final Supplier<Block> blockSupplier;

    public static BlockFeed iBlockFeed() {
        return new TestMockBlockFeed(IBlock::new);
    }

    public static BlockFeed jBlockFeed() {
        return new TestMockBlockFeed(JBlock::new);
    }

    public static BlockFeed lBlockFeed() {
        return new TestMockBlockFeed(LBlock::new);
    }

    public static BlockFeed oBlockFeed() {
        return new TestMockBlockFeed(OBlock::new);
    }

    public static BlockFeed sBlockFeed() {
        return new TestMockBlockFeed(SBlock::new);
    }

    public static BlockFeed zBlockFeed() {
        return new TestMockBlockFeed(ZBlock::new);
    }

    private TestMockBlockFeed(Supplier<Block> blockSupplier) {
        this.blockSupplier = blockSupplier;
    }

    @Override
    public Block nextBlock() {
        return blockSupplier.get();
    }

}
