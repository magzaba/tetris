package com.epam.prejap.tetris.game;

import com.epam.prejap.tetris.block.ArrayPoint;
import com.epam.prejap.tetris.block.BlockFeed;
import com.epam.prejap.tetris.block.RotatableBlock;

public class Playfield {

    private final byte[][] grid;
    private final int rows;
    private final int cols;
    private final Printer printer;
    private final BlockFeed feed;

    private RotatableBlock rotatableBlock;
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
        var block = feed.nextBlock();
        rotatableBlock = RotatableBlock.of(block);
        row = 0;
        col = (cols - block.cols()) / 2;
        show();
    }

    public boolean move(Move move) {
        hide();
        boolean moved;
        switch (move) {
            case LEFT -> moveLeft();
            case RIGHT -> moveRight();
            case UP -> rotateBlock();
        }
        moved = moveDown();
        show();
        return moved;
    }

    private void rotateBlock() {
        var blockAfterRotation = rotatableBlock.rotate();
        var offsetAfterRotation =  calculateRotationPointOffset(rotatableBlock, blockAfterRotation);
        if (isValidMove(blockAfterRotation, offsetAfterRotation)) {
            rotatableBlock = blockAfterRotation;
            doMove(offsetAfterRotation);
        }
    }

    private static ArrayPoint calculateRotationPointOffset(RotatableBlock from, RotatableBlock to) {
        var fromRotationPoint = from.rotationPoint();
        var toRotationPoint = to.rotationPoint();
        return fromRotationPoint.subtract(toRotationPoint);
    }

    private boolean isValidMove(RotatableBlock rotatableBlock, ArrayPoint offset) {
        return isValidMove(rotatableBlock, offset.row(), offset.column());
    }

    private void doMove(ArrayPoint moveDistance) {
        doMove(moveDistance.row(), moveDistance.column());
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
        if (isValidMove(rotatableBlock, rowOffset, colOffset)) {
            doMove(rowOffset, colOffset);
            moved = true;
        }
        return moved;
    }

    private boolean isValidMove(RotatableBlock rotatableBlock, int rowOffset, int colOffset) {
        for (int i = 0; i < rotatableBlock.rows(); i++) {
            for (int j = 0; j < rotatableBlock.cols(); j++) {
                var dot = rotatableBlock.dotAt(i, j);
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
        forEachBrick((i, j, dot) -> grid[row + i][col + j] = 0);
    }

    private void show() {
        forEachBrick((i, j, dot) -> grid[row + i][col + j] = dot);
        printer.draw(grid);
    }

    private void doMove(int rowOffset, int colOffset) {
        row += rowOffset;
        col += colOffset;
    }

    private void forEachBrick(BrickAction action) {
        for (int i = 0; i < rotatableBlock.rows(); i++) {
            for (int j = 0; j < rotatableBlock.cols(); j++) {
                var dot = rotatableBlock.dotAt(i, j);
                if (dot > 0) {
                    action.act(i, j, dot);
                }
            }
        }
    }

    private interface BrickAction {
        void act(int i, int j, byte dot);
    }

}
