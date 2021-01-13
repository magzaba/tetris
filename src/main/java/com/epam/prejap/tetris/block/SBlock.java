package com.epam.prejap.tetris.block;

/**
 * The class represents S-shaped block:
 * <pre> ##<br/>## </pre>
 *
 * @author  Aleksander Konieczny
 */
final class SBlock extends Block {

    private static final byte[][] IMAGE = {
            {0, 1, 1},
            {1, 1, 0},
    };

    public SBlock() {
        super(IMAGE);
    }

    private SBlock(byte[][] image) {
        super(image);
    }

    @Override
    Block copyWithImage(byte[][] image) {
        return new SBlock(image);
    }
}
