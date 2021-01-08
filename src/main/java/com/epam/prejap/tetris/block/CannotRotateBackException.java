package com.epam.prejap.tetris.block;

/**
 * Thrown when at least one call to {@link BlockRotator#rotate()} wasn't made
 * before a call to {@link BlockRotator#rotateBack()}.
 *
 * @see BlockRotator
 * @see BlockRotator#rotate()
 * @see BlockRotator#rotateBack()
 */
public class CannotRotateBackException extends RuntimeException {

    /**
     * Constructs a CannotRotateBackException with the exception message.
     *
     * @param message the exception message
     */
    public CannotRotateBackException(String message) {
        super(message);
    }
}
