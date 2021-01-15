package com.epam.prejap.tetris.block;

record TestBlockRotations(Block block, Object[] rotationImages) {

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

    private static final Object[] Z_BLOCK_ROTATION_IMAGES = new Object[]{
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
            },
    };

    static TestBlockRotations iBlock() {
        return new TestBlockRotations(new IBlock(), I_BLOCK_ROTATION_IMAGES);
    }

    static TestBlockRotations jBlock() {
        return new TestBlockRotations(new JBlock(), J_BLOCK_ROTATION_IMAGES);
    }

    static TestBlockRotations lBlock() {
        return new TestBlockRotations(new LBlock(), L_BLOCK_ROTATION_IMAGES);
    }

    static TestBlockRotations oBlock() {
        return new TestBlockRotations(new OBlock(), O_BLOCK_ROTATION_IMAGES);
    }

    static TestBlockRotations sBlock() {
        return new TestBlockRotations(new SBlock(), S_BLOCK_ROTATION_IMAGES);
    }

    static TestBlockRotations zBlock() {
        return new TestBlockRotations(new ZBlock(), Z_BLOCK_ROTATION_IMAGES);
    }

}
