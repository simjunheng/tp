package seedu.address.logic.commands;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.Model;

public class AddTagToTaskCommand extends Command {
    public static final String COMMAND_WORD = "tag-add-t";
    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Add a tag to a task from our task list. "
            + "Parameters: "
            + "INDEX (must be a positive integer) "
            + "TAG NAME (must be non-empty)\n"
            + "Example: " + COMMAND_WORD + " "
            + "1 "
            + "important";

    public final Index index;
    public final String tagName;

    public AddTagToTaskCommand(Index index, String tagName) {
        this.index = index;
        this.tagName = tagName;
    }
    
    public CommandResult execute(Model model) throws CommandException {
        return null;
    }

}
