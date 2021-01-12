package com.epam.prejap.tetris.block;

class BlockRotations {

    static final Object[][] I_BLOCK_ROTATION_IMAGES = new Object[][]{
            new byte[][] {
                    {1},
                    {1},
                    {1},
                    {1},
            },
            new byte[][] {
                    {1, 1, 1, 1},
            },
    };

    static final ArrayPoint[] I_BLOCK_ROTATION_POINTS = new ArrayPoint[]{
            new ArrayPoint(2, 0),
            new ArrayPoint(0, 1),
            new ArrayPoint(1, 0),
            new ArrayPoint(0, 2),
    };

    static final Object[] L_BLOCK_ROTATION_IMAGES = new Object[]{
            new byte[][] {
                    {1, 0},
                    {1, 0},
                    {1, 1},
            },
            new byte[][] {
                    {1, 1, 1},
                    {1, 0, 0},
            },
            new byte[][] {
                    {1, 1},
                    {0, 1},
                    {0, 1},
            },
            new byte[][] {
                    {0, 0, 1},
                    {1, 1, 1},
            },
    };

    static final ArrayPoint[] L_BLOCK_ROTATION_POINTS = new ArrayPoint[]{
            new ArrayPoint(1, 1),
            new ArrayPoint(1, 1),
            new ArrayPoint(1, 0),
            new ArrayPoint(0, 1),
    };

    static final Object[][] J_BLOCK_ROTATION_IMAGES = new Object[][]{
            new byte[][] {
                    {0, 1},
                    {0, 1},
                    {1, 1},
            },
            new byte[][] {
                    {1, 0, 0},
                    {1, 1, 1},
            },
            new byte[][] {
                    {1, 1},
                    {1, 0},
                    {1, 0},
            },
            new byte[][] {
                    {1, 1, 1},
                    {0, 0, 1},
            },
    };

    static final ArrayPoint[] J_BLOCK_ROTATION_POINTS = new ArrayPoint[]{
            new ArrayPoint(1, 1),
            new ArrayPoint(1, 1),
            new ArrayPoint(1, 0),
            new ArrayPoint(0, 1),
    };

    static final Object[][] O_BLOCK_ROTATION_IMAGES = new Object[][]{
            new byte[][] {
                    {1, 1},
                    {1, 1},
            },
    };

    static final ArrayPoint[] O_BLOCK_ROTATION_POINTS = new ArrayPoint[]{
            new ArrayPoint(1, 1),
    };

}
