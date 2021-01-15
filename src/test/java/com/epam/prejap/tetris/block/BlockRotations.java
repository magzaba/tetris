package com.epam.prejap.tetris.block;

record BlockRotations(Block block, Object[] rotationImages) {

    private enum Image {
        INITIAL, FIRST_ROTATION, SECOND_ROTATION, THIRD_ROTATION, FOURTH_ROTATION
    }

    private static final Object[][] I_BLOCK_ROTATION_IMAGES = new Object[][]{
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
            },
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

    private static final Object[] O_BLOCK_ROTATION_IMAGES = new Object[]{
            new byte[][]{
                    {1, 1},
                    {1, 1},
            },
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

    static BlockRotations iBlock() {
        return new BlockRotations(new IBlock(), I_BLOCK_ROTATION_IMAGES);
    }

    static BlockRotations jBlock() {
        return new BlockRotations(new JBlock(), J_BLOCK_ROTATION_IMAGES);
    }

    static BlockRotations lBlock() {
        return new BlockRotations(new LBlock(), L_BLOCK_ROTATION_IMAGES);
    }

    static BlockRotations oBlock() {
        return new BlockRotations(new OBlock(), O_BLOCK_ROTATION_IMAGES);
    }

    static BlockRotations sBlock() {
        return new BlockRotations(new SBlock(), S_BLOCK_ROTATION_IMAGES);
    }

}
