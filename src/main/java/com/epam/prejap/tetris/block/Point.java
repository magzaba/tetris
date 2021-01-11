package com.epam.prejap.tetris.block;

public record Point(int row, int column) {
    public Point subtract(Point point) {
        return new Point(this.row - point.row, this.column - column);
    }
    public Point negate() {
        return new Point(-this.row, -this.column);
    }
}
