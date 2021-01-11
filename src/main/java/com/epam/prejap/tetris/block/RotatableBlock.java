package com.epam.prejap.tetris.block;

public interface RotatableBlock {
    static RotatableBlock of(Block block) {
        return new RotatingBlock(block);
    }
    int rows();
    int cols();
    byte dotAt(int i, int j);
    RotatableBlock rotate();
    ArrayPoint rotationPoint();
    Block asBlock();
}
