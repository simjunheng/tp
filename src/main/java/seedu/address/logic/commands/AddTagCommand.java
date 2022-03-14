package seedu.address.logic.commands;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import seedu.address.commons.core.index.Index;
import seedu.address.model.Model;

public class AddTagCommand extends Command {
    public static final String COMMAND_WORD = "tag-add";
    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Add a tag to a person from our contact list. "
            + "Parameters: "
            + "INDEX (must be a positive integer) "
            + "TAG NAME (must be non-empty)\n"
            + "Example: " + COMMAND_WORD + " "
            + "1 "
            + "friend";


    private final Index index;
    private final String tagName;

    public AddTagCommand(Index index, String tagName) {
        requireAllNonNull(index, tagName);

        this.index = index;
        this.tagName = tagName;
    }

    @Override
    public CommandResult execute(Model model) {
        System.out.println(this.index);
        System.out.printf(this.tagName);
        return new CommandResult("Hello from tag-add");
    }
}
