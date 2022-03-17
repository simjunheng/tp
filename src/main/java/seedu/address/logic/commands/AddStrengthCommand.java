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
 * Adds a strength note to a person in the address book.
 */
public class AddStrengthCommand extends Command {
    public static final String COMMAND_WORD = "strength-add";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Add a strength to a selected person from our contact list. "
            + "Parameters: "
            + "INDEX (must be a positive integer) "
            + "NOTE_DESCRIPTION (must be non-empty and not more than 50 characters)\n"
            + "Example: " + COMMAND_WORD + " "
            + "1 "
            + "Good at defense";

    public static final String MESSAGE_NOT_IMPLEMENTED_YET =
            "AddStrength command not implemented yet";

    public static final String MESSAGE_SUCCESS = "New strength added: %1$s";

    public static final String MESSAGE_ARGUMENTS = "Index: %1$d, Strength: %2$s";

    private final Index index;
    private final Note strength;

    /**
     * @param index of the person in the filtered person list to add the strength
     * @param strength of the person to be added
     */
    public AddStrengthCommand(Index index, Note strength) {
        requireAllNonNull(index, strength);

        this.index = index;
        this.strength = strength;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        List<Person> lastShownList = model.getFilteredPersonList();

        if (index.getZeroBased() >= lastShownList.size()) {
            throw new CommandException(Messages.MESSAGE_INVALID_PERSON_DISPLAYED_INDEX);
        }

        Person personToEdit = lastShownList.get(index.getZeroBased());
        List<Note> newStrength = new ArrayList<>(personToEdit.getStrengths());
        newStrength.add(strength);

        Person editedPerson = new Person(
                personToEdit.getName(), personToEdit.getPhone(), personToEdit.getEmail(),
                personToEdit.getAddress(), personToEdit.getTags(), newStrength, personToEdit.getWeaknesses(),
                personToEdit.getMiscellaneous());

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
                || (other instanceof AddStrengthCommand // instanceof handles nulls
                && (index.equals(((AddStrengthCommand) other).index)
                    && strength.equals(((AddStrengthCommand) other).strength)));
    }
}
