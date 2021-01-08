package com.epam.prejap.tetris.block;

public class BlockRotator {

    private Block block;
    private Point blockOffset;

    public BlockRotator(Block block) {
        this.block = block;
    }


    public void rotate() {
        byte[][] rotatedImage = rotateBlockImage90DegreesClockwise();



    }

    private byte[][] rotateBlockImage90DegreesClockwise() {
        int rotatedRows = block.cols();
        int rotatedColumns = block.rows();
        Point rotatedImageSize = new Point(rotatedRows, rotatedColumns);
        byte[][] rotatedImage = emptyRotatedImage(rotatedImageSize);

        for (int row = 0; row < block.rows(); row++) {
            for (int column = 0; column < block.cols(); column++) {
                Point toRotate = new Point(row, column);
                rotatePointOnImage(rotatedImage, rotatedImageSize, toRotate);
            }
        }
        return rotatedImage;
    }

    private byte[][] emptyRotatedImage(Point rotatedImageSize) {
        return new byte[rotatedImageSize.row][rotatedImageSize.column];
    }

    private void rotatePointOnImage(byte[][] rotatedImage, Point rotatedImageSize, Point toRotate) {
        Point rotated = rotatePointOnRotatedImage(toRotate, rotatedImageSize);
        rotatedImage[rotated.row][rotated.column] = block.dotAt(toRotate.row, toRotate.column);
    }

    Point rotatePointOnRotatedImage(Point toRotate, Point rotatedImageSize) {
        int rotatedRow = toRotate.column;
        int rotatedColumn = rotatedImageSize.column - 1 - toRotate.row;
        return new Point(rotatedRow, rotatedColumn);
    }
    
}
