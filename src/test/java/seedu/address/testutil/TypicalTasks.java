package seedu.address.testutil;

import static seedu.address.logic.commands.CommandTestUtil.VALID_DATE_TASK1;
import static seedu.address.logic.commands.CommandTestUtil.VALID_DATE_TASK2;
import static seedu.address.logic.commands.CommandTestUtil.VALID_ENDTIME_TASK1;
import static seedu.address.logic.commands.CommandTestUtil.VALID_ENDTIME_TASK2;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NAME_TASK1;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NAME_TASK2;
import static seedu.address.logic.commands.CommandTestUtil.VALID_STARTTIME_TASK1;
import static seedu.address.logic.commands.CommandTestUtil.VALID_STARTTIME_TASK2;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TAG_EVENT;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TAG_MEET;

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

    // Manually added - Task details found in {@code CommandTestUtil}
    public static final Task TASK1 = new TaskBuilder().withName(VALID_NAME_TASK1).withDate(VALID_DATE_TASK1)
            .withStartTime(VALID_STARTTIME_TASK1).withEndTime(VALID_ENDTIME_TASK1).withTags(VALID_TAG_MEET).build();
    public static final Task TASK2 = new TaskBuilder().withName(VALID_NAME_TASK2).withDate(VALID_DATE_TASK2)
            .withStartTime(VALID_STARTTIME_TASK2).withEndTime(VALID_ENDTIME_TASK2)
            .withTags(VALID_TAG_EVENT, VALID_TAG_MEET).build();

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
