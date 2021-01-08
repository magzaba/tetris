package com.epam.prejap.tetris.block;

import java.util.HashMap;

public abstract class Block {

    final byte[][] image;
    final int rows;
    final int cols;

    Block(byte[][] dots) {
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
     * Creates and returns a copy of this object with {@link Block#image}
     * field changed to the value passed as {@code image} argument.
     *
     * @implSpec should create a defensive copy of implementing object's fields.
     *
     * @param   image new block image that will be the image of a returned object
     * @return  a copy of this object with changed {@link Block#image} field,
     *          returned object also has the same type as this concrete object
     */
    abstract Block copyWithImage(byte[][] image);

}
