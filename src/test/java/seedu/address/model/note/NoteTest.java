package seedu.address.model.note;

import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;


public class NoteTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new Note(null));
    }

    @Test
    public void constructor_invalidNote_throwsIllegalArgumentException() {
        // a String of length 51
        String invalidNote = "0123456789"
                + "0123456789"
                + "0123456789"
                + "0123456789"
                + "0123456789"
                + "0";
        assertThrows(IllegalArgumentException.class, () -> new Note(invalidNote));
    }

    @Test
    public void isValidNote() {
        // null tag name
        assertThrows(NullPointerException.class, () -> Note.isValidNote(null));
    }
}
