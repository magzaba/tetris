package com.epam.prejap.tetris.block;

import java.util.stream.IntStream;
import java.util.Objects;

public abstract class Block {

    final byte[][] image;
    final int rows;
    final int cols;
    private final Color color;

    Block(byte[][] dots, Color color) {
        this.color = color;
        rows = dots.length;
        if (dots.length == 0) {
            throw new IllegalArgumentException("Image has height equal to 0");
        }
        cols = dots[0].length;
        image = new byte[rows][cols];
        for (int i = 0; i < dots.length; i++) {
            if (dots[i].length != cols) {
                throw new IllegalArgumentException("Image is not a rectangle");
            }
            for (int j = 0; j < cols; j++) {
                byte dot = dots[i][j];
                if (dot < 0) {
                    throw new IllegalArgumentException("Invalid dot value");
                }
                image[i][j] = dot;
            }
        }
    }

    public int rows() {
        return rows;
    }

    public int cols() {
        return cols;
    }

    public byte dotAt(int i, int j) {
        return image[i][j];
    }

    /**
     * Calculates the lowest position of the block that is occupied in the inspected column
     * @param col index of the column being checked
     * @return index of the lowest occupied row in the given column
     * @throws java.util.NoSuchElementException if the column of block is empty
     * @throws java.lang.ArrayIndexOutOfBoundsException if there is no such column in block
     * @author Madgalena Żaba
     */
    public int lowestOccupiedRowInColumn(int col){
        return IntStream.range(0,rows).filter(i->dotAt(i,col)>0).max().getAsInt();
    }

    public byte getColorId() {
        return Objects.requireNonNullElse(color, Color.BLACK).getId();
    }

}
