package com.epam.prejap.tetris.block;

public interface RotatableBlock {
    int rows();
    int cols();
    byte dotAt(int i, int j);
    RotatableBlock rotate();
    Point rotationPoint();
    Block asBlock();
}
