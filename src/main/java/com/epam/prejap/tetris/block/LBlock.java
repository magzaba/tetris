package com.epam.prejap.tetris.block;

import java.util.List;

/**
 * The LBlock class represents block shape of "L" in tetris game.
 *
 * <p>Implementation note: It contains byte 2d array with '1' and '0',
 * arranged in a way to form required shape.
 *
 */
final class LBlock extends Block {

    private static final List<byte[][]> IMAGES = List.of(
            new byte[][]{
                    {1, 0},
                    {1, 0},
                    {1, 1},
            },
            new byte[][]{
                    {1, 1, 1},
                    {1, 0, 0},
            },
            new byte[][]{
                    {1, 1},
                    {0, 1},
                    {0, 1},
            },
            new byte[][]{
                    {0, 0, 1},
                    {1, 1, 1},
            }
    );

    LBlock() {
        super(IMAGES, Color.RED);
    }

    private LBlock(List<byte[][]> image, Color color, int imageIndex) {
        super(image, color, imageIndex);
    }

    @Override
    Block copyWithImageIndex(int imageIndex) {
        return new LBlock(this.images, this.color, imageIndex);
    }
}
