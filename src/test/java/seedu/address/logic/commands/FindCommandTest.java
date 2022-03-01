package seedu.address.logic.commands;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.commons.core.Messages.MESSAGE_PERSONS_LISTED_OVERVIEW;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.testutil.TypicalPersons.ALICE;
import static seedu.address.testutil.TypicalPersons.BENSON;
import static seedu.address.testutil.TypicalPersons.DANIEL;
import static seedu.address.testutil.TypicalPersons.getTypicalAddressBook;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import org.junit.jupiter.api.Test;

import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.person.Name;
import seedu.address.model.person.NameContainsKeywordsPredicate;
import seedu.address.model.tag.Tag;
import seedu.address.model.tag.TagContainsKeywordsPredicate;

/**
 * Contains integration tests (interaction with the Model) for {@code FindCommand}.
 */
public class FindCommandTest {
    private Model model = new ModelManager(getTypicalAddressBook(), new UserPrefs());
    private Model expectedModel = new ModelManager(getTypicalAddressBook(), new UserPrefs());

    @Test
    public void equals() {
        NameContainsKeywordsPredicate firstPredicate =
                new NameContainsKeywordsPredicate(Collections.singletonList(new Name("first")));
        NameContainsKeywordsPredicate secondPredicate =
                new NameContainsKeywordsPredicate(Collections.singletonList(new Name("second")));
        TagContainsKeywordsPredicate thirdPredicate =
                new TagContainsKeywordsPredicate(Collections.singleton(new Tag("third")));
        TagContainsKeywordsPredicate fourthPredicate =
                new TagContainsKeywordsPredicate(Collections.singleton(new Tag("fourth")));

        FindCommand findFirstCommand = new FindCommand(firstPredicate, thirdPredicate);
        FindCommand findSecondCommand = new FindCommand(secondPredicate, fourthPredicate);

        // same object -> returns true
        assertTrue(findFirstCommand.equals(findFirstCommand));

        // same values -> returns true
        FindCommand findFirstCommandCopy = new FindCommand(firstPredicate, thirdPredicate);
        assertTrue(findFirstCommand.equals(findFirstCommandCopy));

        // different types -> returns false
        assertFalse(findFirstCommand.equals(1));

        // null -> returns false
        assertFalse(findFirstCommand.equals(null));

        // different person -> returns false
        assertFalse(findFirstCommand.equals(findSecondCommand));
    }

    @Test
    public void execute_zeroKeywords_noPersonAndTagFound() {
        List<Name> nameList = Arrays.asList();
        HashSet<Tag> tagSet = new HashSet<>();
        String expectedMessage = String.format(MESSAGE_PERSONS_LISTED_OVERVIEW, 0);
        NameContainsKeywordsPredicate namePredicate = prepareNamePredicate(nameList);
        TagContainsKeywordsPredicate tagPredicate = prepareTagPredicate(tagSet);
        FindCommand command = new FindCommand(namePredicate, tagPredicate);
        expectedModel.updateFilteredPersonList(namePredicate.or(tagPredicate));
        assertCommandSuccess(command, model, expectedMessage, expectedModel);
        assertEquals(Collections.emptyList(), model.getFilteredPersonList());
    }

    @Test
    public void execute_multipleKeywords_multiplePersonsAndTagsFound() {
        List<Name> nameList = Arrays.asList(new Name("Alice"), new Name("Bob"));
        HashSet<Tag> tagSet = new HashSet<Tag>(Arrays.asList(new Tag("friends"), new Tag("neighbours")));
        String expectedMessage = String.format(MESSAGE_PERSONS_LISTED_OVERVIEW, 3);
        NameContainsKeywordsPredicate namePredicate = prepareNamePredicate(nameList);
        TagContainsKeywordsPredicate tagPredicate = prepareTagPredicate(tagSet);
        FindCommand command = new FindCommand(namePredicate, tagPredicate);
        expectedModel.updateFilteredPersonList(namePredicate.or(tagPredicate));
        assertCommandSuccess(command, model, expectedMessage, expectedModel);
        assertEquals(Arrays.asList(ALICE, BENSON, DANIEL), model.getFilteredPersonList());
    }

    /**
     * Creates a {@code NameContainsKeywordsPredicate} using {@code nameList}.
     */
    private NameContainsKeywordsPredicate prepareNamePredicate(List<Name> nameList) {
        return new NameContainsKeywordsPredicate(nameList);
    }
    /**
     * Creates a {@code TagContainsKeywordsPredicate} using {@code tagSet}.
     */
    private TagContainsKeywordsPredicate prepareTagPredicate(HashSet<Tag> tagSet) {
        return new TagContainsKeywordsPredicate(tagSet);
    }
}
