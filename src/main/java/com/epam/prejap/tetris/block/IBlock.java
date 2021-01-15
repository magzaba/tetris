package com.epam.prejap.tetris.block;

import java.util.List;

/**
 * I-shaped block implementation of the {@link Block} abstraction class.
 * <br>
 * @implNote This class implements static 2d array in order to create required "I" shape block
 * <br>
 *
 * @author Łukasz Prokop
 * @see Block
 */
final class IBlock extends Block {

    private static final List<byte[][]> IMAGES = List.of(
            new byte[][]{
                    {1},
                    {1},
                    {1},
                    {1},
            },
            new byte[][]{
                    {1, 1, 1, 1},
            },
            new byte[][]{
                    {1},
                    {1},
                    {1},
                    {1},
            },
            new byte[][]{
                    {1, 1, 1, 1},
            }
    );

    IBlock() {
        super(IMAGES, Color.GREEN);
    }

    private IBlock(List<byte[][]> image, Color color, int imageIndex) {
        super(image, color, imageIndex);
    }

    @Override
    Block copyWithImageIndex(int imageIndex) {
        return new IBlock(this.images, this.color, imageIndex);
    }
}
