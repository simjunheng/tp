package seedu.address.logic.commands;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.note.Note;

/**
 * Adds a note to a person in the address book.
 */
public class AddNoteCommand extends Command {
    private final Index index;
    private final Note note;

    public static final String COMMAND_WORD = "note-add";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Add a note to a selected person from our contact list. "
            + "Parameters: "
            + "INDEX (must be a positive integer) "
            + "NOTE_DESCRIPTION (must be non-empty)\n"
            + "Example: " + COMMAND_WORD + " "
            + "1"
            + "Surgery Scheduled for tomorrow";

    public static final String MESSAGE_NOT_IMPLEMENTED_YET =
            "AddNote command not implemented yet";

    public static final String MESSAGE_SUCCESS = "New note added: %1$s";
    public static final String MESSAGE_DUPLICATE_PERSON = "This person already exists in the address book";

    public static final String MESSAGE_ARGUMENTS = "Index: %1$d, Remark: %2$s";

    /**
     * @param index of the person in the filtered person list to add the note
     * @param note of the person to be added
     */
    public AddNoteCommand(Index index, Note note) {
        requireAllNonNull(index, note);

        this.index = index;
        this.note = note;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException{
        throw new CommandException(
                String.format(MESSAGE_ARGUMENTS, index.getOneBased(), note));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof AddNoteCommand // instanceof handles nulls
                && (index.equals(((AddNoteCommand) other).index)
                    && note.equals(((AddNoteCommand) other).note)));
    }
}
