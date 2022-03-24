package seedu.address.logic.commands;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.io.File;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.image.Image;

/**
 * Loads an image as a background image for use in StrategyPanel.
 */
public class LoadCourtCommand extends Command {
    public static final String COMMAND_WORD = "load-court";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Load an image from '/courts/' directory and sets as background image for the Strategy Panel. "
            + "Parameters: "
            + "IMAGE_NAME (" + Image.MESSAGE_CONSTRAINTS + ") "
            + "Example: " + COMMAND_WORD + " "
            + "basketball";

    public static final String MESSAGE_SUCCESS = "Image has been loaded: %1$s";

    public static final String MESSAGE_IMAGE_INVALID = "Provided image name is invalid!";

    private final Image image;

    /**
     * Constructor for LoadCourtCommand class.
     * @param image The image file.
     */
    public LoadCourtCommand(Image image) {
        requireAllNonNull(image);
        this.image = image;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireAllNonNull(model);
        checkIfThrowsException(); //throws if the image file cannot be instantiated
        return new CommandResult(generateSuccessMessage(image), false, false, true, this.image);
    }

    /**
     * Creates a test javafx.scene.image object and checks if it throws an Exception.
     * @return false if the image file can be instantiated
     * @throws CommandException if png file cannot load
     */
    public boolean checkIfThrowsException() throws CommandException {
        try {
            File imagePath = image.getImagePath();
            new javafx.scene.image.Image((imagePath.toURI().toString()));
        } catch (NullPointerException | IllegalArgumentException e) {
            throw new CommandException(MESSAGE_IMAGE_INVALID);
        }
        return false;
    }

    /**
     * Generates a command execution success message
     * {@code image}.
     */
    private String generateSuccessMessage(Image image) {
        return String.format(MESSAGE_SUCCESS, image);
    }

    @Override
    public boolean equals(Object other) {
        return other == this
                || (other instanceof LoadCourtCommand
                && (image.equals(((LoadCourtCommand) other).image)));
    }
}
