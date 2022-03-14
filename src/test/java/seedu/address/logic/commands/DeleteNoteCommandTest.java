package seedu.address.logic.commands;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandFailure;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalIndexes.INDEX_SECOND_PERSON;
import static seedu.address.testutil.TypicalIndexes.NOTE_FIRST_INDEX;
import static seedu.address.testutil.TypicalIndexes.NOTE_SECOND_INDEX;
import static seedu.address.testutil.TypicalPersons.getTypicalAddressBook;
import static seedu.address.testutil.TypicalTasks.getTypicalTaskBook;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import seedu.address.commons.core.Messages;
import seedu.address.commons.core.index.Index;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.note.Note;
import seedu.address.model.person.Person;

/**
 * Contains integration tests (interaction with the Model) for
 * {@code DeleteNoteCommand}.
 */
public class DeleteNoteCommandTest {

    private final Model model = new ModelManager(getTypicalAddressBook(), getTypicalTaskBook(), new UserPrefs());

    @Test
    public void constructor_nullIndex_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new DeleteNoteCommand(null, null));
    }

    @Test
    public void execute_validNoteIndexUnfilteredList_success() throws Exception {
        Person personToDeleteNoteFrom = model.getFilteredPersonList().get(INDEX_SECOND_PERSON.getZeroBased());
        List<Note> newNotes = new ArrayList<>(personToDeleteNoteFrom.getNotes());
        newNotes.remove(NOTE_FIRST_INDEX.getZeroBased());
        Person personWithModifiedNote = new Person(personToDeleteNoteFrom.getName(), personToDeleteNoteFrom.getPhone(),
                personToDeleteNoteFrom.getEmail(), personToDeleteNoteFrom.getAddress(),
                personToDeleteNoteFrom.getTags(), newNotes);

        DeleteNoteCommand deleteNoteCommand = new DeleteNoteCommand(INDEX_SECOND_PERSON, NOTE_FIRST_INDEX);

        String expectedMessage = String.format(DeleteNoteCommand.MESSAGE_SUCCESS, personWithModifiedNote);

        ModelManager expectedModel = new ModelManager(model.getAddressBook(),
                model.getTaskBook(), new UserPrefs());
        deleteNoteCommand.execute(expectedModel);
        assertCommandSuccess(deleteNoteCommand, model, expectedMessage, expectedModel);
    }

    @Test
    public void execute_invalidNoteIndexUnfilteredList_throwsCommandException() {
        Index outOfBoundNoteIndex = Index.fromOneBased(model.getFilteredPersonList().get(
                INDEX_SECOND_PERSON.getZeroBased()).getNotes().size() + 1);
        DeleteNoteCommand deleteNoteCommand = new DeleteNoteCommand(INDEX_SECOND_PERSON, outOfBoundNoteIndex);

        assertCommandFailure(deleteNoteCommand, model, Messages.MESSAGE_INVALID_NOTE_DISPLAYED_INDEX);
    }

    @Test
    public void execute_invalidPersonIndexUnfilteredList_throwsCommandException() {
        Index outOfBoundNoteIndex = Index.fromOneBased(model.getFilteredPersonList().size() + 1);
        DeleteNoteCommand deleteNoteCommand = new DeleteNoteCommand(outOfBoundNoteIndex, NOTE_FIRST_INDEX);

        assertCommandFailure(deleteNoteCommand, model, Messages.MESSAGE_INVALID_PERSON_DISPLAYED_INDEX);
    }

    @Test
    public void equals() {
        DeleteNoteCommand deleteNoteFirstCommand = new DeleteNoteCommand(INDEX_SECOND_PERSON, NOTE_FIRST_INDEX);
        DeleteNoteCommand deleteNoteSecondCommand = new DeleteNoteCommand(INDEX_SECOND_PERSON, NOTE_SECOND_INDEX);

        // same object -> returns true
        assertTrue(deleteNoteFirstCommand.equals(deleteNoteFirstCommand));

        // same values -> returns true
        DeleteNoteCommand deleteNoteFirstCommandCopy = new DeleteNoteCommand(INDEX_SECOND_PERSON, NOTE_FIRST_INDEX);
        assertTrue(deleteNoteFirstCommand.equals(deleteNoteFirstCommandCopy));

        // different types -> returns false
        assertFalse(deleteNoteFirstCommand.equals(1));

        // null -> returns false
        assertFalse(deleteNoteFirstCommand.equals(null));

        // different person -> returns false
        assertFalse(deleteNoteFirstCommand.equals(deleteNoteSecondCommand));
    }
}
