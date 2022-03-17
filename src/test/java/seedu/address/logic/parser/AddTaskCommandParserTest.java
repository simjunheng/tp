package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.commands.CommandTestUtil.DATE_DESC_TASK1;
import static seedu.address.logic.commands.CommandTestUtil.DATE_DESC_TASK2;
import static seedu.address.logic.commands.CommandTestUtil.ENDTIME_DESC_TASK1;
import static seedu.address.logic.commands.CommandTestUtil.ENDTIME_DESC_TASK2;
import static seedu.address.logic.commands.CommandTestUtil.NAME_DESC_TASK1;
import static seedu.address.logic.commands.CommandTestUtil.NAME_DESC_TASK2;
import static seedu.address.logic.commands.CommandTestUtil.PREAMBLE_WHITESPACE;
import static seedu.address.logic.commands.CommandTestUtil.STARTTIME_DESC_TASK1;
import static seedu.address.logic.commands.CommandTestUtil.STARTTIME_DESC_TASK2;
import static seedu.address.logic.commands.CommandTestUtil.TAG_DESC_EVENT;
import static seedu.address.logic.commands.CommandTestUtil.TAG_DESC_MEET;
import static seedu.address.logic.commands.CommandTestUtil.VALID_DATE_TASK1;
import static seedu.address.logic.commands.CommandTestUtil.VALID_ENDTIME_TASK1;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NAME_TASK1;
import static seedu.address.logic.commands.CommandTestUtil.VALID_STARTTIME_TASK1;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TAG_EVENT;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TAG_MEET;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;
import static seedu.address.testutil.TypicalTasks.TASK1;
import static seedu.address.testutil.TypicalTasks.TASK2;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.AddTaskCommand;
import seedu.address.model.task.Task;
import seedu.address.testutil.TaskBuilder;


public class AddTaskCommandParserTest {
    private AddTaskCommandParser parser = new AddTaskCommandParser();

    @Test
    public void parse_allFieldsPresent_success() {
        Task expectedTask = new TaskBuilder(TASK2).withTags(VALID_TAG_MEET).build();

        // whitespace only preamble
        assertParseSuccess(parser, PREAMBLE_WHITESPACE + NAME_DESC_TASK2 + DATE_DESC_TASK2
                + STARTTIME_DESC_TASK2 + ENDTIME_DESC_TASK2 + TAG_DESC_MEET, new AddTaskCommand(expectedTask));

        // multiple names - last name accepted
        assertParseSuccess(parser, NAME_DESC_TASK1 + NAME_DESC_TASK2 + DATE_DESC_TASK2 + STARTTIME_DESC_TASK2
                + ENDTIME_DESC_TASK2 + TAG_DESC_MEET, new AddTaskCommand(expectedTask));

        // multiple date - last date accepted
        assertParseSuccess(parser, NAME_DESC_TASK2 + DATE_DESC_TASK1 + DATE_DESC_TASK2 + STARTTIME_DESC_TASK2
                + ENDTIME_DESC_TASK2 + TAG_DESC_MEET, new AddTaskCommand(expectedTask));

        // multiple starttime - last starttime accepted
        assertParseSuccess(parser, NAME_DESC_TASK2 + DATE_DESC_TASK2 + STARTTIME_DESC_TASK1
                + STARTTIME_DESC_TASK2 + ENDTIME_DESC_TASK2 + TAG_DESC_MEET, new AddTaskCommand(expectedTask));

        // multiple endtime - last endtime accepted
        assertParseSuccess(parser, NAME_DESC_TASK2 + DATE_DESC_TASK2 + STARTTIME_DESC_TASK2
                + ENDTIME_DESC_TASK1 + ENDTIME_DESC_TASK2 + TAG_DESC_MEET, new AddTaskCommand(expectedTask));

        // multiple tags - all accepted
        Task expectedTaskMultipleTags = new TaskBuilder(TASK2).withTags(VALID_TAG_EVENT, VALID_TAG_MEET)
                .build();
        assertParseSuccess(parser, NAME_DESC_TASK2 + DATE_DESC_TASK2 + STARTTIME_DESC_TASK2
                + ENDTIME_DESC_TASK2 + TAG_DESC_EVENT + TAG_DESC_MEET, new AddTaskCommand(expectedTaskMultipleTags));
    }

    @Test
    public void parse_optionalFieldsMissing_success() {
        // no tags
        Task expectedTask = new TaskBuilder(TASK1).withTags().build();
        assertParseSuccess(parser,
                NAME_DESC_TASK1 + DATE_DESC_TASK1 + STARTTIME_DESC_TASK1 + ENDTIME_DESC_TASK1,
                new AddTaskCommand(expectedTask));
    }

    @Test
    public void parse_compulsoryFieldMissing_failure() {
        String expectedMessage = String.format(MESSAGE_INVALID_COMMAND_FORMAT, AddTaskCommand.MESSAGE_USAGE);

        // missing name prefix
        assertParseFailure(parser, VALID_NAME_TASK1 + DATE_DESC_TASK1 + STARTTIME_DESC_TASK1
                + ENDTIME_DESC_TASK1, expectedMessage);

        // missing date prefix
        assertParseFailure(parser, NAME_DESC_TASK1 + VALID_DATE_TASK1 + STARTTIME_DESC_TASK1
                + ENDTIME_DESC_TASK1, expectedMessage);

        // missing starttime prefix
        assertParseFailure(parser, NAME_DESC_TASK1 + DATE_DESC_TASK1 + VALID_STARTTIME_TASK1
                + ENDTIME_DESC_TASK1, expectedMessage);

        // missing endtime prefix
        assertParseFailure(parser, NAME_DESC_TASK1 + DATE_DESC_TASK1 + STARTTIME_DESC_TASK1
                + VALID_ENDTIME_TASK1, expectedMessage);

        // all prefixes missing
        assertParseFailure(parser, VALID_NAME_TASK1 + VALID_DATE_TASK1 + VALID_STARTTIME_TASK1
                + VALID_ENDTIME_TASK1, expectedMessage);
    }
}
