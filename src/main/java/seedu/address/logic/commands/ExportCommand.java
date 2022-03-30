package seedu.address.logic.commands;

import seedu.address.ui.MainWindow;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.image.Image;
import seedu.address.logic.commands.exceptions.CommandException;

import java.util.UUID;

import static seedu.address.commons.core.Tabs.DEFAULT;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

public class ExportCommand extends Command{

    public static final String COMMAND_WORD = "export";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Exports current Strategy Panel as a .png image into user selected directory. "
            + "Example: " + COMMAND_WORD;

    public static final String SHOWING_EXPORT_MESSAGE = "Strategy Panel is being exported.";

    private String fileName;

    /**
     * Constructor for ExportCommand class.
     */

    @Override
    public CommandResult execute(Model model) {
        requireAllNonNull(model);
        return new CommandResult(SHOWING_EXPORT_MESSAGE, false, false, DEFAULT, false, null, true);
    }


    /**
     * Randomized file names
     */
    private static String imageRandomFileString() {
        return UUID.randomUUID().toString();
    }
}