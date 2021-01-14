package com.epam.prejap.tetris.block;

/**
 * The {@code RotatableBlock} interface wraps a {@code Block} object
 * and provides the rotation functionality for it.
 *
 * @see Block
 */
public interface RotatableBlock {

    /**
     * Creates and returns a wrapper around {@code block} param,
     * allowing rotation of this {@code block} around its rotation point.
     * <p></p>
     * Created {@code RotatableBlock} has its initial rotation point of type
     * {@code ArrayPoint} set to {@code (row = block.rows()/2, column = block.cols()/2)},
     * where {@code block} is this method's passed argument.
     *
     * @param   block {@code Block} that the returned object wraps
     * @return  wrapper of a {@code Block} object which allows it to be rotated
     *          clockwise by 90 degrees around its rotation point
     * @see     Block
     * @see     ArrayPoint
     */
    static RotatableBlock of(Block block) {
        return new RotatingBlock(block);
    }

    /**
     * Returns the number of rows of wrapped {@code Block}'s image array.
     *
     * @return number of rows of wrapped {@code Block}'s image array
     */
    int rows();

    /**
     * Returns the number of columns of wrapped {@code Block}'s image array.
     *
     * @return number of columns of wrapped {@code Block}'s image array
     */
    int cols();


    /**
     * Returns the dot that's at the {@code row} and {@code column}
     * of a wrapped {@code Block}'s image array.
     *
     * index of the element to return
     *
     * @param   row row at which the image's dot to return is
     * @param   column column at which the image's dot to return is
     * @return  dot that's at the {@code row} and {@code column}
     *          of a wrapped {@code Block}'s image array
     * @throws  ArrayIndexOutOfBoundsException if {@code row} or {@code column} is outside the image
     *          ({@code row < 0 || row >= rows()})
     *          or
     *          ({@code column < 0 || column >= cols()})
     */
    byte dotAt(int row, int column);

    /**
     * Returns the {@code RotatableBlock} containing next clockwise 90 degrees rotation of wrapped block's image.
     * <p></p>
     * Image array of rotated wrapped {@code Block} is different from the original in the following way:
     * <pre>
     *     original (size 2x3):
     *     [a, b, c]
     *     [d, e, f]
     *     rotated (size 3x2):
     *     [d, a]
     *     [e, b]
     *     [f, c]
     * </pre>
     *
     * @return this {@code RotatableBlock} block rotated by 90 degrees clockwise
     * @see Block
     */
    RotatableBlock rotate();

    /**
     * Returns rotation a {@code ArrayPoint} around which this object's image should be rotated.
     *
     * @return  this block's rotation point coordinates as {@code ArrayPoint}
     * @see     ArrayPoint
     */
    ArrayPoint rotationPoint();

    /**
     * Returns a {@code Block} object that this object wraps.
     *
     * @return {@code Block} that this object wraps.
     */
    Block asBlock();

    byte getColorId();
}
