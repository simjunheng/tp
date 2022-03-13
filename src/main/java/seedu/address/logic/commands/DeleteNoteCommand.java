package seedu.address.logic.commands;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;
import static seedu.address.model.Model.PREDICATE_SHOW_ALL_PERSONS;

import java.util.ArrayList;
import java.util.List;

import seedu.address.commons.core.Messages;
import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.note.Note;
import seedu.address.model.person.Person;

/**
 * Delete a note from a person in the address book
 */
public class DeleteNoteCommand extends Command {
    public static final String COMMAND_WORD = "note-del";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Delete a note from the note-list of selected person from our contact list. "
            + "Parameters: "
            + "INDEX (must be a positive integer) "
            + "NOTE-INDEX (must be a positive)\n"
            + "Example: " + COMMAND_WORD + " "
            + "1 "
            + "2";

    public static final String MESSAGE_NOT_IMPLEMENTED_YET =
            "DeleteNote command not implemented yet";

    public static final String MESSAGE_SUCCESS = "Note has been deleted: %1$s";

    public static final String MESSAGE_ARGUMENTS = "Index: %1$d, Index: %2$d";

    private final Index index;
    private final Index noteIndex;

    /**
     * Constructor of DeleteNoteCommand class
     * @param index index of the person in the filtered person list
     * @param noteIndex index of the note from the person's note-list to be deleted
     */
    public DeleteNoteCommand(Index index, Index noteIndex) {
        requireAllNonNull(index, noteIndex);
        this.index = index;
        this.noteIndex = noteIndex;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        List<Person> lastShownList = model.getFilteredPersonList();

        if (index.getZeroBased() >= lastShownList.size()) {
            throw new CommandException(Messages.MESSAGE_INVALID_PERSON_DISPLAYED_INDEX);
        }

        Person personToEdit = lastShownList.get(index.getZeroBased());
        List<Note> newNotes = new ArrayList<>(personToEdit.getNotes());

        if (noteIndex.getZeroBased() >= newNotes.size()) {
            throw new CommandException(Messages.MESSAGE_INVALID_NOTE_DISPLAYED_INDEX);
        }
        newNotes.remove(noteIndex.getZeroBased());

        Person editedPerson = new Person(
                personToEdit.getName(), personToEdit.getPhone(), personToEdit.getEmail(),
                personToEdit.getAddress(), personToEdit.getTags(), newNotes);

        model.setPerson(personToEdit, editedPerson);
        model.updateFilteredPersonList(PREDICATE_SHOW_ALL_PERSONS);

        return new CommandResult(generateSuccessMessage(editedPerson));
    }

    /**
     * Generates a command execution success message
     * {@code personToEdit}.
     */
    private String generateSuccessMessage(Person personToEdit) {
        return String.format(MESSAGE_SUCCESS, personToEdit);
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof DeleteNoteCommand // instanceof handles nulls
                && (index.equals(((DeleteNoteCommand) other).index)
                && noteIndex.equals(((DeleteNoteCommand) other).noteIndex)));
    }
}
