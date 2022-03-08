package seedu.address.testutil;

import seedu.address.model.AddressBook;
import seedu.address.model.person.Person;
import seedu.address.model.task.Task;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    private TypicalTasks() {} // prevents instantiation
}
