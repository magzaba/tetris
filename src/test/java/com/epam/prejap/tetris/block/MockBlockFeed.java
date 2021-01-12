package com.epam.prejap.tetris.block;

public class MockBlockFeed extends BlockFeed {

    private final int returnedBlockIndex;

    public MockBlockFeed(int returnedBlockIndex) {
        this.returnedBlockIndex = returnedBlockIndex;
    }

    @Override
    public Block nextBlock() {
        return blocks().get(returnedBlockIndex).get();
    }

}
