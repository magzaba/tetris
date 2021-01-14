package com.epam.prejap.tetris.block;

class RotatingBlock implements RotatableBlock {

    private final Block block;
    private final ArrayPoint rotationPoint;

    RotatingBlock(Block block) {
        this(block, calculateRotationPoint(block));
    }

    private static ArrayPoint calculateRotationPoint(Block block) {
        return new ArrayPoint(block.rows(), block.cols()).divide(2);
    }

    private RotatingBlock(Block block, ArrayPoint rotationPoint) {
        this.block = block;
        this.rotationPoint = rotationPoint;
    }

    @Override
    public int rows() {
        return block.rows();
    }

    @Override
    public int cols() {
        return block.cols();
    }

    @Override
    public byte dotAt(int row, int column) {
        return block.dotAt(row, column);
    }

    @Override
    public RotatableBlock rotate() {
        var rotatedImageSize = getBlockImageSize().transpose();
        byte[][] rotatedImage = rotateBlockImage90DegreesClockwise(rotatedImageSize);
        var rotationPointAfterRotation = rotateRotationPoint(rotationPoint, rotatedImageSize);

        return new RotatingBlock(block.copyWithImage(rotatedImage), rotationPointAfterRotation);
    }

    private static ArrayPoint rotateRotationPoint(ArrayPoint toRotate, ArrayPoint rotatedImageSize) {
        boolean isImageSquare = rotatedImageSize.row() == rotatedImageSize.column();
        if (isImageSquare) {
            return toRotate;
        }
        return rotatePointOnImage(toRotate, rotatedImageSize);
    }

    private ArrayPoint getBlockImageSize() {
        return new ArrayPoint(block.rows(), block.cols());
    }

    private byte[][] rotateBlockImage90DegreesClockwise(ArrayPoint rotatedImageSize) {
        byte[][] rotatedImage = emptyRotatedImage(rotatedImageSize);

        for (int row = 0; row < block.rows(); row++) {
            for (int column = 0; column < block.cols(); column++) {
                ArrayPoint toRotate = new ArrayPoint(row, column);
                ArrayPoint rotated = rotatePointOnImage(toRotate, rotatedImageSize);
                putOnRotatedImage(rotatedImage, rotated, toRotate);
            }
        }
        return rotatedImage;
    }

    private static byte[][] emptyRotatedImage(ArrayPoint rotatedImageSize) {
        return new byte[rotatedImageSize.row()][rotatedImageSize.column()];
    }

    private static ArrayPoint rotatePointOnImage(ArrayPoint toRotate, ArrayPoint rotatedImageSize) {
        int rotatedRow = toRotate.column();
        int rotatedColumn = rotatedImageSize.column() - 1 - toRotate.row();
        return new ArrayPoint(rotatedRow, rotatedColumn);
    }

    private void putOnRotatedImage(byte[][] rotatedImage, ArrayPoint rotated, ArrayPoint toRotate) {
        rotatedImage[rotated.row()][rotated.column()] = block.dotAt(toRotate.row(), toRotate.column());
    }

    @Override
    public ArrayPoint rotationPoint() {
        return rotationPoint;
    }

    @Override
    public Block asBlock() {
        return block;
    }

    @Override
    public byte getColorId() {
        return block.getColorId();
    }
}
