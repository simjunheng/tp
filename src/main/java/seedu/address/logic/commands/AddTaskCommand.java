package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_DATE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_ENDTIME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_STARTTIME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TAG;

import java.util.List;
import java.util.Set;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.name.Name;
import seedu.address.model.person.Person;
import seedu.address.model.task.Task;


/**
 * Adds a task to the task list.
 */
public class AddTaskCommand extends Command {

    public static final String COMMAND_WORD = "add-task";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Adds a task to the TaskList. "
            + "Parameters: "
            + PREFIX_NAME + "NAME "
            + PREFIX_DATE + "DATE "
            + PREFIX_STARTTIME + "START TIME "
            + PREFIX_ENDTIME + "END TIME "
            + "[" + PREFIX_TAG + "TAG]...\n"
            + "Example: " + COMMAND_WORD + " "
            + PREFIX_NAME + "Investor introduction "
            + PREFIX_DATE + "08-04-2022 "
            + PREFIX_STARTTIME + "13:00 "
            + PREFIX_ENDTIME + "15:00 "
            + PREFIX_TAG + "funding "
            + PREFIX_TAG + "meeting ";

    public static final String MESSAGE_SUCCESS = "New task added: %1$s";
    public static final String MESSAGE_DUPLICATE_TASK = "This task already exists in the task book";
    public static final String MESSAGE_CONTACT_NOT_FOUND = "The person cannot be found in the current address book";

    private final Task toAdd;

    /**
     * Creates an AddTaskCommand to add the specified {@code Task}
     */
    public AddTaskCommand(Task task) {
        requireNonNull(task);
        toAdd = task;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        List<Person> lastShownList = model.getFilteredPersonList();
        Set<Name> persons = toAdd.getPersons();
        //Checks if persons are in lastShownList
        for (Name name: persons) {
            boolean notFound = true;
            for (Person person: lastShownList) {
                if (person.getName().equals(name)) {
                    notFound = false;
                }
            }
            if (notFound) {
                throw new CommandException(MESSAGE_CONTACT_NOT_FOUND);
            }
        }

        if (model.hasTask(toAdd)) {
            throw new CommandException(MESSAGE_DUPLICATE_TASK);
        }

        model.addTask(toAdd);
        return new CommandResult(String.format(MESSAGE_SUCCESS, toAdd));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof AddTaskCommand // instanceof handles nulls
                && toAdd.equals(((AddTaskCommand) other).toAdd));
    }
}
