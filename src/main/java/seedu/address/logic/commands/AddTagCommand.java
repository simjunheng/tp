package seedu.address.logic.commands;

import seedu.address.model.Model;

public class AddTagCommand extends Command {
    public static final String COMMAND_WORD = "tag-add";

    @Override
    public CommandResult execute(Model model) {
        return new CommandResult("Hello from tag-add");
    }
}
