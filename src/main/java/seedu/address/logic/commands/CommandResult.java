package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import java.util.Objects;

import seedu.address.model.image.Image;


/**
 * Represents the result of a command execution.
 */
public class CommandResult {

    private final String feedbackToUser;

    /**
     * Help information should be shown to the user.
     */
    private final boolean showHelp;

    /**
     * The application should exit.
     */
    private final boolean exit;

    /**
     * The background image of StrategyBoard should be changed
     */
    private final boolean isLoadImage;

    /**
     * The background image of StrategyBoard
     */
    private final Image image;

    /**
     * Constructs a {@code CommandResult} with the specified fields.
     * <p>
     * Specifically used for loading background image for Strategy Panel.
     */
    public CommandResult(String feedbackToUser, boolean showHelp, boolean exit, boolean isLoadImage, Image image) {
        this.feedbackToUser = requireNonNull(feedbackToUser);
        this.showHelp = showHelp;
        this.isLoadImage = isLoadImage;
        this.image = image;
        this.exit = exit;
    }

    /**
     * Constructs a {@code CommandResult} with the specified fields,
     * and isLoadImage set to false.
     */
    public CommandResult(String feedbackToUser, boolean showHelp, boolean exit) {
        this(feedbackToUser, showHelp, exit, false, null);
    }

    /**
     * Constructs a {@code CommandResult} with the specified {@code feedbackToUser},
     * and other fields set to their default value.
     */
    public CommandResult(String feedbackToUser) {
        this(feedbackToUser, false, false);
    }

    public String getFeedbackToUser() {
        return feedbackToUser;
    }

    public boolean isShowHelp() {
        return showHelp;
    }

    public boolean isExit() {
        return exit;
    }

    public boolean isLoadImageCommand() {
        return isLoadImage;
    }

    public Image getBackgroundImage() {
        return image;
    }


    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof CommandResult)) {
            return false;
        }

        CommandResult otherCommandResult = (CommandResult) other;
        return feedbackToUser.equals(otherCommandResult.feedbackToUser)
                && showHelp == otherCommandResult.showHelp
                && exit == otherCommandResult.exit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(feedbackToUser, showHelp, exit);
    }

    @Override
    public String toString() {
        return "CommandResult{"
                + "feedbackToUser='" + feedbackToUser + '\''
                + ", showHelp=" + showHelp
                + ", exit=" + exit
                + '}';
    }
}
