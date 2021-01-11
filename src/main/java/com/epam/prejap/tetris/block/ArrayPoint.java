package com.epam.prejap.tetris.block;

/**
 * Holds coordinates ({@code row} and {@code column}) of an element inside a 2D array.
 * <p></p>
 * Although array coordinates consist of non-negative integers, this object can also hold negative values.
 * This allows offsetting a coordinate up and right, or down and left in one operation.
 */
public record ArrayPoint(int row, int column) {
    /**
     * Returns a {@code ArrayPoint} which has a value
     * of this object subtracted by {@code point} param.
     *
     * @implSpec returned {@code ArrayPoint} has {@code row} equal to {@code this.row - param.row}
     *           and {@code column} equal to {@code this.column - param.column}.
     *
     * @param   point {@code ArrayPoint} to be subtracted from this object
     * @return  this object subtracted by {@code point} param
     */
    public ArrayPoint subtract(ArrayPoint point) {
        return new ArrayPoint(this.row - point.row, this.column - point.column);
    }

    /**
     * Returns a {@code ArrayPoint} which has a value of this object's
     * {@code row} and {@code column} divided by {@code divisor} param.
     *
     * @param   divisor number by which this object's {@code row} and {@code column} will be divided
     * @return  {@code ArrayPoint} with this object's {@code row} and {@code column} divided by {@code point} param
     * @throws  ArithmeticException if {@code divisor} is equal to 0
     */
    public ArrayPoint divide(int divisor) {
        if (divisor == 0) {
            throw new ArithmeticException("Cannot divide by 0");
        }
        return new ArrayPoint(row/divisor, column/divisor);
    }

    /**
     * Returns a {@code ArrayPoint} which has a values of this object's
     * {@code row} and {@code column} swapped together.
     *
     * @return {@code ArrayPoint} with {@code row} equal to {@code this.column}
     *         and {@code column} equal to {@code this.row}
     */
    public ArrayPoint transpose() {
        return new ArrayPoint(column, row);
    }

}
