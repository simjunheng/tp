package seedu.address.model.tag;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

import org.junit.jupiter.api.Test;

import seedu.address.testutil.PersonBuilder;

public class TagContainsKeywordsPredicateTest {

    @Test
    public void equals() {
        HashSet<Tag> firstPredicateKeywordList = new HashSet<>(Collections.singletonList(new Tag("first")));
        HashSet<Tag> secondPredicateKeywordList = new HashSet<>(Arrays.asList(new Tag("first"), new Tag("second")));

        TagContainsKeywordsPredicate firstPredicate = new TagContainsKeywordsPredicate(firstPredicateKeywordList);
        TagContainsKeywordsPredicate secondPredicate = new TagContainsKeywordsPredicate(secondPredicateKeywordList);

        // same object -> returns true
        assertTrue(firstPredicate.equals(firstPredicate));

        // same values -> returns true
        TagContainsKeywordsPredicate firstPredicateCopy = new TagContainsKeywordsPredicate(firstPredicateKeywordList);
        assertTrue(firstPredicate.equals(firstPredicateCopy));

        // different types -> returns false
        assertFalse(firstPredicate.equals(1));

        // null -> returns false
        assertFalse(firstPredicate.equals(null));

        // different person -> returns false
        assertFalse(firstPredicate.equals(secondPredicate));
    }

    @Test
    public void test_tagContainsKeywords_returnsTrue() {
        // One keyword
        TagContainsKeywordsPredicate predicate =
                new TagContainsKeywordsPredicate(new HashSet<>(Collections.singletonList(new Tag("Alice"))));
        assertTrue(predicate.test(new PersonBuilder().withTags("Alice", "Bob").build()));

        // Multiple keywords
        predicate = new TagContainsKeywordsPredicate(new HashSet<>(Arrays.asList(new Tag("Alice"), new Tag("Bob"))));
        assertTrue(predicate.test(new PersonBuilder().withTags("Alice", "Bob").build()));

        // Only one matching keyword
        predicate = new TagContainsKeywordsPredicate(new HashSet<>(Arrays.asList(new Tag("Bob"), new Tag("Carol"))));
        assertTrue(predicate.test(new PersonBuilder().withTags("Alice", "Carol").build()));

        // Mixed-case keywords
        predicate = new TagContainsKeywordsPredicate(new HashSet<>(Arrays.asList(new Tag("aLIce"), new Tag("bOB"))));
        assertTrue(predicate.test(new PersonBuilder().withTags("Alice", "Bob").build()));
    }

    @Test
    public void test_nameDoesNotContainKeywords_returnsFalse() {
        // Zero keywords
        TagContainsKeywordsPredicate predicate =
                new TagContainsKeywordsPredicate(new HashSet<>(Collections.emptyList()));
        assertFalse(predicate.test(new PersonBuilder().withTags("Alice").build()));

        // Non-matching keyword
        predicate = new TagContainsKeywordsPredicate(new HashSet<>(Arrays.asList(new Tag("Carol"))));
        assertFalse(predicate.test(new PersonBuilder().withTags("Alice", "Bob").build()));

        // Keywords match phone, and address, but does not match name
        predicate = new TagContainsKeywordsPredicate(
                new HashSet<>(Arrays.asList(new Tag("12345"), new Tag("Main"), new Tag("Street"))));
        assertFalse(predicate.test(new PersonBuilder().withName("Alice").withPhone("12345")
                .withEmail("alice@email.com").withAddress("Main Street").build()));
    }
}
