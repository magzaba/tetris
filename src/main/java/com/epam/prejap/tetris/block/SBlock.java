package com.epam.prejap.tetris.block;

/**
 * The class is derived from {@link Block} and represents S-shaped block:
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
}
