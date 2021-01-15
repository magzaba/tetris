package com.epam.prejap.tetris.block;

import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public abstract class Block implements Iterable<Block> {

    private final static int INITIAL_IMAGE_INDEX = 0;

    final int imageIndex;
    final List<byte[][]> images;
    final Color color;

    Block(List<byte[][]> images, Color color, int imageIndex) {
        for (byte[][] image : images) {
            checkImageDimensions(image);
        }
        this.imageIndex = imageIndex;
        this.images = images;
        this.color = color;
    }

    Block(List<byte[][]> images, Color color) {
        this(images, color, INITIAL_IMAGE_INDEX);
    }

    private byte[][] image() {
        return images.get(imageIndex);
    }

    private static void checkImageDimensions(byte[][] image) {
        int rows = image.length;
        if (rows == 0) {
            throw new IllegalArgumentException("Image has height equal to 0");
        }
        int columns = image[0].length;
        for (int i = 0; i < image.length; i++) {
            if (image[i].length != columns) {
                throw new IllegalArgumentException("Image is not a rectangle");
            }
            for (int j = 0; j < columns; j++) {
                byte dot = image[i][j];
                if (dot < 0) {
                    throw new IllegalArgumentException("Invalid dot value");
                }
            }
        }
    }

    public int rows() {
        return image().length;
    }

    public int cols() {
        return image()[0].length;
    }

    public byte dotAt(int i, int j) {
        return image()[i][j];
    }

    /**
     * Calculates the lowest position of the block that is occupied in the inspected column
     * @param col index of the column being checked
     * @return index of the lowest occupied row in the given column
     * @throws java.util.NoSuchElementException if the column of block is empty
     * @throws java.lang.ArrayIndexOutOfBoundsException if there is no such column in block
     * @author Madgalena Żaba
     */
    public int lowestOccupiedRowInColumn(int col){
        return IntStream.range(0,rows()).filter(i->dotAt(i,col)>0).max().getAsInt();
    }

    public byte getColorId() {
        return Objects.requireNonNullElse(color, Color.BLACK).getId();
    }

    public Block rotate() {
        var blockIterator = iterator();
        blockIterator.next(); // skip current image
        return blockIterator.next();
    }

    @Override
    public Iterator<Block> iterator() {
        return new BlockItr();
    }

    abstract Block copyWithImageIndex(int imageIndex);

    private final class BlockItr implements Iterator<Block> {

        int cursor = imageIndex;

        @Override
        public boolean hasNext() {
            return true;
        }

        @Override
        public Block next() {
            int currentImage = cursor;
            cursor++;
            if (cursor == images.size()) {
                cursor = 0;
            }
            return copyWithImageIndex(currentImage);
        }
    }
}
