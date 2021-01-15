package com.epam.prejap.tetris.game;

import com.epam.prejap.tetris.block.ArrayPoint;
import com.epam.prejap.tetris.block.BlockFeed;

public class Playfield {

    private final Printer printer;
    private final BlockFeed feed;
    private RotatableBlock rotatableBlock;
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
        var nextBlock = feed.nextBlock();
        rotatableBlock = RotatableBlock.of(nextBlock);
        grid.newBlock(rotatableBlock.cols());
        showBlockOnGrid();
    }

    /**
     * Shifts current block left or right one column, then down one row
     *
     * @param move direction of movement
     * @return block moved down one row
     */
    public boolean move(Move move) {
        hideBlockOnGrid();
        boolean moved;
        switch (move) {
            case LEFT -> moveLeft();
            case RIGHT -> moveRight();
            case UP -> rotateBlock();
        }
        moved = moveDown();
        showBlockOnGrid();
        return moved;
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

    private void rotateBlock() {
        var blockAfterRotation = rotatableBlock.rotate();
        var offsetAfterRotation =  calculateRotationPointOffset(rotatableBlock, blockAfterRotation);
        if (isValidRotation(blockAfterRotation, offsetAfterRotation)) {
            doRotate(blockAfterRotation, offsetAfterRotation);
        }
    }

    private static ArrayPoint calculateRotationPointOffset(RotatableBlock from, RotatableBlock to) {
        var fromRotationPoint = from.rotationPoint();
        var toRotationPoint = to.rotationPoint();
        return fromRotationPoint.subtract(toRotationPoint);
    }

    private boolean isValidRotation(RotatableBlock rotatableBlock, ArrayPoint offsetAfterRotation) {
        return grid.isValidMove(rotatableBlock.asBlock(), offsetAfterRotation.row(), offsetAfterRotation.column());
    }

    private void doRotate(RotatableBlock blockAfterRotation, ArrayPoint offsetAfterRotation) {
        rotatableBlock = blockAfterRotation;
        grid.doMove(offsetAfterRotation.row(), offsetAfterRotation.column());
    }

    private boolean move(int rowOffset, int colOffset) {
        boolean moved = false;
        if (grid.isValidMove(rotatableBlock.asBlock(), rowOffset, colOffset)) {
            grid.doMove(rowOffset, colOffset);
            moved = true;
        }
        return moved;
    }

    private void hideBlockOnGrid() {
        grid.hide(rotatableBlock.asBlock());
    }

    private void showBlockOnGrid() {
        grid.show(rotatableBlock.asBlock());
        printer.draw(grid.byteGrid);
    }
}
