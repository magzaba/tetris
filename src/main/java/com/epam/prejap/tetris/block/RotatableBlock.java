package com.epam.prejap.tetris.block;

/**
 * The {@code RotatableBlock} interface wraps a {@code Block} object
 * and provides the rotation functionality for it.
 *
 * @see Block
 */
public interface RotatableBlock {

    /**
     * Creates a wrapper with additional rotation functionality around the {@code block} param and returns it.
     *
     * @param   block {@code Block} around which returned object will be wrapped
     * @return  wrapper of a {@code Block} object which can be rotated clockwise by 90 degrees
     * @see     Block
     */
    static RotatableBlock of(Block block) {
        return new RotatingBlock(block);
    }
    
    int rows();
    int cols();
    byte dotAt(int i, int j);

    /**
     * Returns next clockwise 90 degrees rotation of this block.
     *
     * @return this {@code RotatableBlock} block rotated by 90 degrees clockwise
     */
    RotatableBlock rotate();

    /**
     * Returns rotation a {@code ArrayPoint} around which this object's image should be rotated.
     *
     * @return  this block's rotation point coordinates as {@code ArrayPoint}
     * @see     ArrayPoint
     */
    ArrayPoint rotationPoint();

    Block asBlock();
}
