package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.List;
import java.util.Set;

import seedu.address.commons.core.Messages;
import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.Model;
import seedu.address.model.name.Name;
import seedu.address.model.task.Date;
import seedu.address.model.task.EndTime;
import seedu.address.model.task.StartTime;
import seedu.address.model.task.Task;

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
        requireAllNonNull(index, tagName);

        this.index = index;
        this.tagName = tagName;
    }
    
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        List<Task> lastShownList = model.getFilteredTaskList();

        // Exception when index out of bounds
        if (index.getZeroBased() >= lastShownList.size()) {
            throw new CommandException(Messages.MESSAGE_INVALID_TASK_DISPLAYED_INDEX);

            Task taskToEdit = lastShownList.get(index.getZeroBased());
            Task editedTask;
        }

    }

    /**
     * Creates and returns a {@code Task} with a new tag {@code tagName} added to
     * {@code taskToEdit}
     *
     * @param taskToEdit Person to be edited
     * @return New Task object with the tag added (tag list updated)
     */
    private Task addTaskToPerson(Task taskToEdit) throws CommandException {
        // Keep all other fields the same
        Name updatedName = taskToEdit.getName();
        Date updatedDate = taskToEdit.getDate();
        StartTime updatedStartTime = taskToEdit.getStartTime();
        EndTime updatedEndTime = taskToEdit.getEndTime();
        Set<Name> updatedPersons = taskToEdit.getPersons();



    }


}
