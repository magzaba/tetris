package com.epam.prejap.tetris.block;

public record ArrayPoint(int row, int column) {
    public ArrayPoint subtract(ArrayPoint point) {
        return new ArrayPoint(this.row - point.row, this.column - point.column);
    }
    public ArrayPoint divide(int divisor) {
        if (divisor == 0) {
            throw new IllegalArgumentException("Cannot divide by 0.");
        }
        return new ArrayPoint(this.row/divisor, this.column/divisor);
    }
    public ArrayPoint negate() {
        return new ArrayPoint(-this.row, -this.column);
    }
}
