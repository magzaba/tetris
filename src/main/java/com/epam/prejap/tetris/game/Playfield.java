package com.epam.prejap.tetris.game;

import com.epam.prejap.tetris.block.Block;
import com.epam.prejap.tetris.block.BlockFeed;

public class Playfield {

    private final byte[][] grid;
    private final int rows;
    private final int cols;
    private final Printer printer;
    private final BlockFeed feed;

    private Block block;
    private int row;
    private int col;

    public Playfield(int rows, int cols, BlockFeed feed, Printer printer) {
        this.rows = rows;
        this.cols = cols;
        this.feed = feed;
        this.printer = printer;
        grid = new byte[this.rows][this.cols];
    }

    public void nextBlock() {
        block = feed.nextBlock();
        row = 0;
        col = (cols - block.cols()) / 2;
        show();
    }

    /**
     * Attempts to perform a move and displays the updated playfield
     * @param move to be performed
     * @return true if move was performed (block changed its position), false otherwise
     * @see Move
     */
    public boolean move(Move move) {
        hide();
        boolean moved;
        switch (move) {
            case LEFT -> moveLeft();
            case RIGHT -> moveRight();
            case DOWN -> moveToBottom();
        }
        moved = moveDown();
        show();
        return moved;
    }

    private void moveToBottom() {
        move(maxRowOffset()-1,0);
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

    private int maxRowOffset() {
        var maxRowCount=rows;
        for (int blockCol=0;blockCol<block.cols();blockCol++){
            var offsetInColumn=0;
            for(int i = row+ block.lowestOccupiedRowInColumn(blockCol)+1; i<rows; i++) {
                if (grid[i][col + blockCol] > 0) {
                    maxRowCount=Integer.min(offsetInColumn, maxRowCount);
                }
                offsetInColumn++;
            }
        }
        return maxRowCount;
    }

    private boolean move(int rowOffset, int colOffset) {
        boolean moved = false;
        if (isValidMove(block, rowOffset, colOffset)) {
            doMove(rowOffset, colOffset);
            moved = true;
        }
        return moved;
    }

    private boolean isValidMove(Block block, int rowOffset, int colOffset) {
        for (int i = 0; i < block.rows(); i++) {
            for (int j = 0; j < block.cols(); j++) {
                var dot = block.dotAt(i, j);
                if (dot > 0) {
                    int newRow = row + i + rowOffset;
                    int newCol = col + j + colOffset;
                    if (newRow >= rows || newCol >= cols || grid[newRow][newCol] > 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private void hide() {
        forEachBrick((i, j) -> grid[row + i][col + j] = 0);
    }

    private void show() {
        forEachBrick((i, j) -> grid[row + i][col + j] = block.getColorId());
        printer.draw(grid);
    }

    private void doMove(int rowOffset, int colOffset) {
        row += rowOffset;
        col += colOffset;
    }

    private void forEachBrick(BrickAction action) {
        for (int i = 0; i < block.rows(); i++) {
            for (int j = 0; j < block.cols(); j++) {
                var dot = block.dotAt(i, j);
                if (dot > 0) {
                    action.act(i, j);
                }
            }
        }
    }

    private interface BrickAction {
        void act(int i, int j);
    }
}
