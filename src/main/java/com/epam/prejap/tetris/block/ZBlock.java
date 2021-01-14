package com.epam.prejap.tetris.block;

/**
 * Z-shaped block implementation of the {@link Block} class.
 *
 * @implNote This class implements static 2d array in order to create Z shape block
 *
 * @author Nika Avramchuk
 * @see Block
 */
final class ZBlock extends Block {

    private static final byte[][] IMAGE = {
            {1, 1, 0},
            {0, 1, 1},
    };

    ZBlock() {
        super(IMAGE, Color.CYAN);
    }

    private ZBlock(byte[][] image, Color color) {
        super(image, color);
    }

    @Override
    Block copyWithImage(byte[][] image) {
        return new ZBlock(image, this.color);
    }
}
