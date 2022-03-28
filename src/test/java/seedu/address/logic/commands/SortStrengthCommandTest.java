package seedu.address.logic.commands;

import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.testutil.TypicalPersons.getGenericAddressBookWithSortedStrengths;
import static seedu.address.testutil.TypicalPersons.getGenericAddressBookWithUnsortedStrengths;
import static seedu.address.testutil.TypicalTasks.getTypicalTaskBook;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.StrategyBoard;
import seedu.address.model.UserPrefs;

/**
 * Contains integration tests (interaction with the Model) and unit tests for SortStrengthCommand.
 */
public class SortStrengthCommandTest {

    private Model model;
    private Model expectedModel;

    @BeforeEach
    public void setUp() {
        model = new ModelManager(getGenericAddressBookWithUnsortedStrengths(), getTypicalTaskBook(),
                new StrategyBoard(), new UserPrefs());
        expectedModel = new ModelManager(getGenericAddressBookWithSortedStrengths(),
                model.getTaskBook(), new StrategyBoard(), new UserPrefs());
    }

    @Test
    public void execute_unsortedList_success() {
        assertCommandSuccess(new SortStrengthCommand(), model, SortStrengthCommand.MESSAGE_SUCCESS, expectedModel);
    }
}
