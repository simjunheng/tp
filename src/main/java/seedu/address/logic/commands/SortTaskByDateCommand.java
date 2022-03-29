package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.management.ConstructorParameters;

import seedu.address.commons.core.Messages;
import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.task.Date;
import seedu.address.model.task.Task;

/**
 * Deletes a task identified using its index from the TaskList.
 */
public class SortTaskByDateCommand extends Command {

    public static final String COMMAND_WORD = "sort-date";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Sorts the task list by date, earlier dates first";

    public static final String MESSAGE_SORT_TASKS_SUCCESS = "Sorted tasks by date";



    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        List<Task> lastShownList = model.getFilteredTaskList(); // Unmodifiable tasklist of model
        List<Task> listSortedByDate = sortTaskListByDate(lastShownList);
        clearAllTasksInModel(model);
        addAllTasksToModel(model, listSortedByDate);

        return new CommandResult(String.format(MESSAGE_SORT_TASKS_SUCCESS));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof SortTaskByDateCommand); // instanceof handles nulls
    }

    /**
     * Sorts a List<Task> by date
     * @param oldList List to be sorted
     * @return List with tasks sorted by date
     */
    private List<Task> sortTaskListByDate(List<Task> oldList) {
        Comparator<Task>  taskComparator = new Comparator<Task>() {
            @Override
            public int compare(Task t1, Task t2) {
                return t1.getDate().compareTo(t2.getDate());
            }
        };

        Collections.sort(oldList, taskComparator);

        return oldList;
    }

    /**
     * Removes all tasks displayed in the current model
     * @model Current model object
     */
    private void clearAllTasksInModel(Model model) {
        List<Task> lastShownList = model.getFilteredTaskList();
        for (Task t : lastShownList) {
            model.deleteTask(t);
        }
    }

    /**
     * Add tasks to the model according to the given list
     * @
     */
    private void addAllTasksToModel(Model model, List<Task> taskList) {
        for (Task t : taskList) {
            model.addTask(t);
        }
    }
}
