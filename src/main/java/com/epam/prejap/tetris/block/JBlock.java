package com.epam.prejap.tetris.block;

import java.util.List;

/**
 * J-shaped block implementation of the {@link Block} abstract class.
 * <br>
 *
 * @author Łukasz Bulczak
 * @implNote This class implements static 2d array in order to create required "J" shape block.
 * @see Block
 */
final class JBlock extends Block {

    private static final List<byte[][]> IMAGES = List.of(
            new byte[][]{
                    {0, 1},
                    {0, 1},
                    {1, 1},
            },
            new byte[][]{
                    {1, 0, 0},
                    {1, 1, 1},
            },
            new byte[][]{
                    {1, 1},
                    {1, 0},
                    {1, 0},
            },
            new byte[][]{
                    {1, 1, 1},
                    {0, 0, 1},
            }
    );

    JBlock() {
        super(IMAGES, Color.YELLOW);
    }

    private JBlock(List<byte[][]> image, Color color, int imageIndex) {
        super(image, color, imageIndex);
    }

    @Override
    Block copyWithImageIndex(int imageIndex) {
        return new JBlock(this.images, this.color, imageIndex);
    }
}
