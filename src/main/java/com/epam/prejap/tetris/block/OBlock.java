package com.epam.prejap.tetris.block;

import java.util.List;

/**
 * O-shaped block implementation of the {@link Block} abstract class.
 * <br>
 *
 * @author Pawel Kierat
 * @implNote This class implements static 2d array in order to create required "O" shape block.
 * @see Block
 */
final class OBlock extends Block {

    private static final List<byte[][]> IMAGES = List.of(
            new byte[][]{
                    {1, 1},
                    {1, 1},
            },
            new byte[][]{
                    {1, 1},
                    {1, 1},
            },
            new byte[][]{
                    {1, 1},
                    {1, 1},
            },
            new byte[][]{
                    {1, 1},
                    {1, 1},
            }
    );

    public OBlock() {
        super(IMAGES, Color.BLUE);
    }

    private OBlock(List<byte[][]> image, Color color, int imageIndex) {
        super(image, color, imageIndex);
    }

    @Override
    Block copyWithImageIndex(int imageIndex) {
        return new OBlock(this.images, this.color, imageIndex);
    }
}
