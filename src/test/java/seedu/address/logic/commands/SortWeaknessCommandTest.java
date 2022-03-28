package seedu.address.logic.commands;

import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.testutil.TypicalPersons.getGenericAddressBookWithSortedWeaknesses;
import static seedu.address.testutil.TypicalPersons.getGenericAddressBookWithUnsortedWeaknesses;
import static seedu.address.testutil.TypicalTasks.getTypicalTaskBook;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.StrategyBoard;
import seedu.address.model.UserPrefs;

/**
 * Contains integration tests (interaction with the Model) and unit tests for SortWeaknessCommand.
 */
public class SortWeaknessCommandTest {

    private Model model;
    private Model expectedModel;

    @BeforeEach
    public void setUp() {
        model = new ModelManager(getGenericAddressBookWithUnsortedWeaknesses(), getTypicalTaskBook(),
                new StrategyBoard(), new UserPrefs());
        expectedModel = new ModelManager(getGenericAddressBookWithSortedWeaknesses(),
                model.getTaskBook(), new StrategyBoard(), new UserPrefs());
    }

    @Test
    public void execute_unsortedList_success() {
        assertCommandSuccess(new SortWeaknessCommand(), model, SortWeaknessCommand.MESSAGE_SUCCESS, expectedModel);
    }
}
