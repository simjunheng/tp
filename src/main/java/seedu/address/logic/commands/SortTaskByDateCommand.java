package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.TaskBook;
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
        List<Task> lastShownList = new ArrayList<>(model.getFilteredTaskList());
        List<Task> listSortedByDate = new ArrayList<>(sortTaskListByDate(lastShownList));

        int filteredListSize = lastShownList.size();
        for (int i = 0; i < filteredListSize; i++) {
            model.deleteTask(lastShownList.get(i));
            model.addTask(lastShownList.get(i));
        }


        return new CommandResult(String.format(MESSAGE_SORT_TASKS_SUCCESS));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof SortTaskByDateCommand); // instanceof handles nulls
    }

    /**
     * Sorts a task list by date
     *
     * @param oldList List to be sorted
     * @return List with tasks sorted by date
     */
    private List<Task> sortTaskListByDate(List<Task> oldList) {
        Collections.sort(oldList, (t1, t2) -> t1.compareTo(t2));

        return oldList;
    }
}
