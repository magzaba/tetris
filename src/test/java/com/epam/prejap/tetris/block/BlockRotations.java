package com.epam.prejap.tetris.block;

record BlockRotations(Block block, Object[] rotationImages, ArrayPoint[] rotationPoints) {

    private static final Object[] I_BLOCK_ROTATION_IMAGES = new Object[]{
            new byte[][]{
                    {1},
                    {1},
                    {1},
                    {1},
            },
            new byte[][]{
                    {1, 1, 1, 1},
            },
    };

    private static final ArrayPoint[] I_BLOCK_ROTATION_POINTS = new ArrayPoint[]{
            new ArrayPoint(2, 0),
            new ArrayPoint(0, 1),
            new ArrayPoint(1, 0),
            new ArrayPoint(0, 2),
    };

    private static final Object[] L_BLOCK_ROTATION_IMAGES = new Object[]{
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
            },
    };

    private static final ArrayPoint[] L_BLOCK_ROTATION_POINTS = new ArrayPoint[]{
            new ArrayPoint(1, 1),
            new ArrayPoint(1, 1),
            new ArrayPoint(1, 0),
            new ArrayPoint(0, 1),
    };

    private static final Object[] J_BLOCK_ROTATION_IMAGES = new Object[]{
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
            },
    };

    private static final ArrayPoint[] J_BLOCK_ROTATION_POINTS = new ArrayPoint[]{
            new ArrayPoint(1, 1),
            new ArrayPoint(1, 1),
            new ArrayPoint(1, 0),
            new ArrayPoint(0, 1),
    };

    private static final Object[] O_BLOCK_ROTATION_IMAGES = new Object[]{
            new byte[][]{
                    {1, 1},
                    {1, 1},
            },
    };

    private static final ArrayPoint[] O_BLOCK_ROTATION_POINTS = new ArrayPoint[]{
            new ArrayPoint(1, 1),
    };

    private static final Object[] S_BLOCK_ROTATION_IMAGES = new Object[]{
            new byte[][]{
                    {0, 1, 1},
                    {1, 1, 0},
            },
            new byte[][]{
                    {1, 0},
                    {1, 1},
                    {0, 1},
            },
    };

    private static final ArrayPoint[] S_BLOCK_ROTATION_POINTS = new ArrayPoint[]{
            new ArrayPoint(1, 1),
            new ArrayPoint(1, 0),
            new ArrayPoint(0, 1),
            new ArrayPoint(1, 1),
    };

    static BlockRotations iBlock() {
        return new BlockRotations(new IBlock(), I_BLOCK_ROTATION_IMAGES, I_BLOCK_ROTATION_POINTS);
    }

    static BlockRotations jBlock() {
        return new BlockRotations(new JBlock(), J_BLOCK_ROTATION_IMAGES, J_BLOCK_ROTATION_POINTS);
    }

    static BlockRotations lBlock() {
        return new BlockRotations(new LBlock(), L_BLOCK_ROTATION_IMAGES, L_BLOCK_ROTATION_POINTS);
    }

    static BlockRotations oBlock() {
        return new BlockRotations(new OBlock(), O_BLOCK_ROTATION_IMAGES, O_BLOCK_ROTATION_POINTS);
    }

    static BlockRotations sBlock() {
        return new BlockRotations(new SBlock(), S_BLOCK_ROTATION_IMAGES, S_BLOCK_ROTATION_POINTS);
    }

}
