package com.epam.prejap.tetris.block;

import java.util.List;

/**
 * The class represents S-shaped block:
 * <pre> ##<br/>## </pre>
 *
 * @author  Aleksander Konieczny
 */
final class SBlock extends Block {

    private static final List<byte[][]> IMAGES = List.of(
            new byte[][]{
                    {0, 1, 1},
                    {1, 1, 0},
            },
            new byte[][]{
                    {1, 0},
                    {1, 1},
                    {0, 1},
            },
            new byte[][]{
                    {0, 1, 1},
                    {1, 1, 0},
            },
            new byte[][]{
                    {1, 0},
                    {1, 1},
                    {0, 1},
            }
    );

    public SBlock() {
        super(IMAGES, Color.MAGENTA);
    }

    private SBlock(List<byte[][]> image, Color color, int imageIndex) {
        super(image, color, imageIndex);
    }

    @Override
    Block copyWithImageIndex(int imageIndex) {
        return new SBlock(this.images, this.color, imageIndex);
    }
}
