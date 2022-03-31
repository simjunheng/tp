package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_PERSON;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.AddTagToTaskCommand;
import seedu.address.logic.commands.DeleteTagFromTaskCommand;

class DeleteTagFromTaskCommandParserTest {

    private static final String TAG1 = "TAG1";
    private DeleteTagFromTaskCommandParser parser = new DeleteTagFromTaskCommandParser();


    @Test
    void parse_validArgs_returnsDeleteTagFromTasksCommand() {
        DeleteTagFromTaskCommand expectedDeleteTagFromTaskCommand = new DeleteTagFromTaskCommand(INDEX_FIRST_PERSON, TAG1);
        assertParseSuccess(parser, " 1 TAG1", expectedDeleteTagFromTaskCommand);
    }

    @Test
    void parse_invalidArgs_throwsParseException() {
        assertParseFailure(parser,
                " 1 t/important", // Tags can only be alphanumeric
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, DeleteTagFromTaskCommand.MESSAGE_USAGE));
    }
}
