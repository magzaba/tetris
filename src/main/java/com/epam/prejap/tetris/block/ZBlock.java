package com.epam.prejap.tetris.block;

import java.util.List;

/**
 * Z-shaped block implementation of the {@link Block} class.
 *
 * @implNote This class implements static 2d array in order to create Z shape block
 *
 * @author Nika Avramchuk
 * @see Block
 */
final class ZBlock extends Block {

    private static final List<byte[][]> IMAGES = List.of(
            new byte[][]{
                    {1, 1, 0},
                    {0, 1, 1},
            },
            new byte[][]{
                    {0, 1},
                    {1, 1},
                    {1, 0},
            },
            new byte[][]{
                    {1, 1, 0},
                    {0, 1, 1},
            },
            new byte[][]{
                    {0, 1},
                    {1, 1},
                    {1, 0},
            }
    );

    ZBlock() {
        super(IMAGES, Color.CYAN);
    }

    private ZBlock(List<byte[][]> image, Color color, int imageIndex) {
        super(image, color, imageIndex);
    }

    @Override
    Block copyWithImageIndex(int imageIndex) {
        return new ZBlock(this.images, this.color, imageIndex);
    }
}
