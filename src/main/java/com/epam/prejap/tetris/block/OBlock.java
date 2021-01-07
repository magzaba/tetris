package com.epam.prejap.tetris.block;

final class OBlock extends Block {

    private static final byte[][] IMAGE = {
        {1, 1},
        {1, 1},
    };

    public OBlock() {
        super(IMAGE);
    }

    private OBlock(byte[][] image) {
        super(image);
    }

    @Override
    public Block copyWithImage(byte[][] image) {
        return new OBlock(image);
    }
}
