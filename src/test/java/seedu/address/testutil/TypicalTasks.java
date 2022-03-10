package seedu.address.testutil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import seedu.address.model.TaskBook;
import seedu.address.model.task.Task;

/**
 * A utility class containing a list of {@code Task} objects to be used in tests.
 */
public class TypicalTasks {
    public static final Task FIRST_TASK = new TaskBuilder().withName("Meeting").withDate("09-10-2022")
            .withStartTime("09:00").withEndTime("10:00")
            .withTags("friends", "colleagues").build();
    public static final Task SECOND_TASK = new TaskBuilder().withName("Training").withDate("29-02-2020")
            .withStartTime("14:00").withEndTime("16:00")
            .withTags("colleagues").build();
    public static final Task THIRD_TASK = new TaskBuilder().withName("Shareholder Meeting").withDate("29-02-2020")
            .withStartTime("14:00").withEndTime("16:00")
            .withTags("colleagues").build();

    // Manually added
    public static final Task FOURTH_TASK = new TaskBuilder().withName("Soccer Training").withDate("01-03-2020")
            .withStartTime("14:30").withEndTime("16:00")
            .withTags("team2").build();
    public static final Task FIFTH_TASK = new TaskBuilder().withName("Basketball Training").withDate("02-03-2020")
            .withStartTime("14:30").withEndTime("16:00")
            .withTags("team1").build();

    private TypicalTasks() {} // prevents instantiation

    /**
     * Returns an {@code TaskBook} with all the typical persons.
     */
    public static TaskBook getTypicalTaskBook() {
        TaskBook tb = new TaskBook();
        for (Task task : getTypicalTasks()) {
            tb.addTask(task);
        }
        return tb;
    }

    public static List<Task> getTypicalTasks() {
        return new ArrayList<>(Arrays.asList(FIRST_TASK, SECOND_TASK, THIRD_TASK));
    }
}
