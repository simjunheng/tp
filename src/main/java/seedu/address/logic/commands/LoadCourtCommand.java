package seedu.address.logic.commands;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

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

        return new CommandResult(generateSuccessMessage(image), false, false, true, this.image);
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
