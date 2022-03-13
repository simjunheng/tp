package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;
import static seedu.address.testutil.TypicalIndexes.INDEX_SECOND_PERSON;
import static seedu.address.testutil.TypicalIndexes.NOTE_INDEX_SECOND_PERSON;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.DeleteNoteCommand;

/**
 * Contains tests for
 * {@code DeleteNoteCommandParser}.
 */
public class DeleteNoteCommandParserTest {
    private DeleteNoteCommandParser parser = new DeleteNoteCommandParser();

    @Test
    public void parse_validArgs_returnsDeleteCommand() {
        assertParseSuccess(parser, "2 1", new DeleteNoteCommand(INDEX_SECOND_PERSON, NOTE_INDEX_SECOND_PERSON));
    }

    @Test
    public void parse_invalidArgs_throwsParseException() {
        assertParseFailure(parser, "2", String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                DeleteNoteCommand.MESSAGE_USAGE));
    }
}
