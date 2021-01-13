package com.epam.prejap.tetris.game;

class PlayfieldBlockRotations {

    static final int GRID_ROWS = 7;
    static final int GRID_COLUMNS = 5;

    private enum TimesUPKeyIsPressed { ZERO, ONE, TWO, THREE, FOUR };

    static final Object[][] L_BLOCK_ROTATIONS_ON_GRID = new Object[][]{
            {
                TimesUPKeyIsPressed.ZERO.ordinal(), """
                +-----+
                | #   |
                | #   |
                | ##  |
                |     |
                |     |
                |     |
                |     |
                +-----+"""
            },
            {
                TimesUPKeyIsPressed.ONE.ordinal(), """
                +-----+
                |     |
                | ### |
                | #   |
                |     |
                |     |
                |     |
                |     |
                +-----+"""
            },
            {
                TimesUPKeyIsPressed.TWO.ordinal(), """
                +-----+
                |     |
                |     |
                |  ## |
                |   # |
                |   # |
                |     |
                |     |
                +-----+"""
            },
            {
                TimesUPKeyIsPressed.THREE.ordinal(), """
                +-----+
                |     |
                |     |
                |     |
                |     |
                |   # |
                | ### |
                |     |
                +-----+"""
            },
            {
                TimesUPKeyIsPressed.FOUR.ordinal(), """
                +-----+
                |     |
                |     |
                |     |
                |     |
                | #   |
                | #   |
                | ##  |
                +-----+"""
            },
    };

    static final Object[][] O_BLOCK_ROTATIONS_ON_GRID = new Object[][]{
            {
                TimesUPKeyIsPressed.ZERO.ordinal(), """
                +-----+
                | ##  |
                | ##  |
                |     |
                |     |
                |     |
                |     |
                |     |
                +-----+"""
            },
            {
                TimesUPKeyIsPressed.ONE.ordinal(), """
                +-----+
                |     |
                | ##  |
                | ##  |
                |     |
                |     |
                |     |
                |     |
                +-----+"""
            },
            {
                TimesUPKeyIsPressed.TWO.ordinal(), """
                +-----+
                |     |
                |     |
                | ##  |
                | ##  |
                |     |
                |     |
                |     |
                +-----+"""
            },
            {
                TimesUPKeyIsPressed.THREE.ordinal(), """
                +-----+
                |     |
                |     |
                |     |
                | ##  |
                | ##  |
                |     |
                |     |
                +-----+"""
            },
            {
                TimesUPKeyIsPressed.FOUR.ordinal(), """
                +-----+
                |     |
                |     |
                |     |
                |     |
                | ##  |
                | ##  |
                |     |
                +-----+"""
            },
    };

}
