package seedu.address.model.task;

import org.junit.jupiter.api.Test;
import seedu.address.testutil.TaskBuilder;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalTasks.FIRST_TASK;
import static seedu.address.testutil.TypicalTasks.SECOND_TASK;

public class TaskTest {
    @Test
    public void asObservableList_modifyList_throwsUnsupportedOperationException() {
        Task task = new TaskBuilder().build();
        assertThrows(UnsupportedOperationException.class, () -> task.getTags().remove(0));
    }

    @Test
    public void isSameTask() {
        //same object -> returns true
        assertTrue(FIRST_TASK.isSameTask(FIRST_TASK));

        //null -> returns false
        assertFalse(FIRST_TASK.isSameTask(null));

        // same name, all other attributes different -> returns true
        Task editedFirstTask = new TaskBuilder().withName("Meeting").withDate("09-01-2011")
                .withStartTime("00:00").withEndTime("01:00").withTags("hello").build();
        assertTrue(FIRST_TASK.isSameTask(editedFirstTask));

        // different name, all other attributes same -> returns false
        editedFirstTask= new TaskBuilder().withName("Swimming").withDate("09-10-2022")
                .withStartTime("09:00").withEndTime("10:00")
                .withTags("friends", "colleagues").build();
        assertFalse(FIRST_TASK.isSameTask(editedFirstTask));

        // name with trailing spaces, all other attributes same -> returns false
        editedFirstTask= new TaskBuilder().withName("Meeting  ").withDate("09-10-2022")
                .withStartTime("09:00").withEndTime("10:00")
                .withTags("friends", "colleagues").build();
        assertFalse(FIRST_TASK.isSameTask(editedFirstTask));
    }

    @Test
    public void equals() {
        // same values -> returns true
        Task firstTaskCopy = new TaskBuilder().withName("Meeting").withDate("09-10-2022")
                .withStartTime("09:00").withEndTime("10:00")
                .withTags("friends", "colleagues").build();
        assertTrue(FIRST_TASK.equals(firstTaskCopy));

        // same object -> returns true
        assertTrue(FIRST_TASK.equals(FIRST_TASK));

        // null -> returns false
        assertFalse(FIRST_TASK.equals(null));

        // different type -> returns false
        assertFalse(FIRST_TASK.equals(5));

        // different task -> returns false
        assertFalse(FIRST_TASK.equals(SECOND_TASK));

        // different name -> returns false
        Task editedFirstTask = new TaskBuilder(firstTaskCopy).withName("Swimming").build();
        assertFalse(FIRST_TASK.equals(editedFirstTask));

        // different date -> returns false
        editedFirstTask = new TaskBuilder(firstTaskCopy).withDate("01-10-2022").build();
        assertFalse(FIRST_TASK.equals(editedFirstTask));

        // different start time -> returns false
        editedFirstTask = new TaskBuilder(firstTaskCopy).withStartTime("22:00").build();
        assertFalse(FIRST_TASK.equals(editedFirstTask));

        // different end time -> returns false
        editedFirstTask = new TaskBuilder(firstTaskCopy).withEndTime("23:00").build();
        assertFalse(FIRST_TASK.equals(editedFirstTask));

        // different tags -> returns false
        editedFirstTask = new TaskBuilder(firstTaskCopy).withTags("neighbours").build();
        assertFalse(FIRST_TASK.equals(editedFirstTask));
    }
}
