package com.epam.prejap.tetris.game;

import com.epam.prejap.tetris.block.Block;
import com.epam.prejap.tetris.block.BlockFeed;

public class Playfield {

    private final Printer printer;
    private final BlockFeed feed;
    private Block block;
    private final Grid grid;

    /**
     * @param feed    block generator
     * @param printer displays grid to user via System.out
     * @param grid    starting
     */
    public Playfield(BlockFeed feed, Printer printer, Grid grid) {
        this.feed = feed;
        this.printer = printer;
        this.grid = grid;
    }

    /**
     * Generates new block starting at row 0 in the center column
     */
    public void nextBlock() {
        block = feed.nextBlock();
        grid.newBlock(block.cols());
        show(block);
    }

    /**
     * Attempts to perform a move and displays the updated playfield
     *
     * @param move to be performed
     * @return true if move was performed (block changed its position), false otherwise
     * @see Move
     */
    public boolean move(Move move) {
        hide(block);
        boolean moved;
        switch (move) {
            case LEFT -> moveLeft();
            case RIGHT -> moveRight();
            case DOWN -> moveToBottom();
        }
        moved = moveDown();
        show(block);
        return moved;
    }

    private void moveToBottom() {
        move(grid.maxRowOffset(block), 0);
    }

    private void moveRight() {
        move(0, 1);
    }

    private void moveLeft() {
        move(0, -1);
    }

    private boolean moveDown() {
        return move(1, 0);
    }


    private boolean move(int rowOffset, int colOffset) {
        boolean moved = false;
        if (grid.isValidMove(block, rowOffset, colOffset)) {
            grid.doMove(rowOffset, colOffset);
            moved = true;
        }
        return moved;
    }

    private void hide(Block block) {
        grid.hide(block);
    }

    private void show(Block block) {
        grid.show(block);
        printer.draw(grid.byteGrid);
    }


}
