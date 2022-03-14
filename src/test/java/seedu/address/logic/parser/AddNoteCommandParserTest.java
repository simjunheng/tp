package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NOTE_AMY;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_PERSON;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.AddNoteCommand;
import seedu.address.model.note.Note;

class AddNoteCommandParserTest {

    private AddNoteCommandParser parser = new AddNoteCommandParser();

    @Test
    public void parse_emptyArg_throwsParseException() {
        assertParseFailure(parser, "     ",
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, AddNoteCommand.MESSAGE_USAGE));
    }

    @Test
    public void parse_validArgs_returnsAddNoteCommand() {
        // no leading and trailing whitespaces
        AddNoteCommand expectedAddNoteCommand =
                new AddNoteCommand(INDEX_FIRST_PERSON, new Note(VALID_NOTE_AMY));
        assertParseSuccess(parser, "1 Amy", expectedAddNoteCommand);

        // multiple whitespaces between keywords
        assertParseSuccess(parser, " \n 1 \n \t Amy  \t", expectedAddNoteCommand);
    }

    @Test
    public void parse_invalidArgs_throwsParseException() {
        assertParseFailure(parser, "2           ",
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, AddNoteCommand.MESSAGE_USAGE));

        assertParseFailure(parser, "         Amy",
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, AddNoteCommand.MESSAGE_USAGE));
    }
}
