package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.FindCommand;
import seedu.address.model.person.Name;
import seedu.address.model.person.NameContainsKeywordsPredicate;
import seedu.address.model.tag.Tag;
import seedu.address.model.tag.TagContainsKeywordsPredicate;

public class FindCommandParserTest {

    private FindCommandParser parser = new FindCommandParser();

    @Test
    public void parse_emptyArg_throwsParseException() {
        assertParseFailure(parser, "     ", String.format(MESSAGE_INVALID_COMMAND_FORMAT, FindCommand.MESSAGE_USAGE));
    }

    @Test
    public void parse_validArgs_returnsFindCommand() {
        List<Name> nameList = Arrays.asList(new Name("Alex"), new Name("Bob"));
        HashSet<Tag> tagSet = new HashSet<>(Arrays.asList(new Tag("friends"), new Tag("neighbours")));
        // no leading and trailing whitespaces
        FindCommand expectedFindCommand =
                new FindCommand(new NameContainsKeywordsPredicate(nameList), new TagContainsKeywordsPredicate(tagSet));
        assertParseSuccess(parser, " n/Alex n/Bob t/friends t/neighbours", expectedFindCommand);

        // multiple whitespaces between keywords
        assertParseSuccess(parser, " n/Alex     n/Bob   t/friends t/neighbours    ", expectedFindCommand);
    }

}
