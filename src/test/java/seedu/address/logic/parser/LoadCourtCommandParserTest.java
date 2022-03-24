package seedu.address.logic.parser;
import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.LoadCourtCommand;
import seedu.address.model.image.Image;
import seedu.address.testutil.TestImage;

public class LoadCourtCommandParserTest {
    private LoadCourtCommandParser parser = new LoadCourtCommandParser();

    @Test
    public void parse_emptyArg_throwsParseException() {
        assertParseFailure(parser, "     ",
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, LoadCourtCommand.MESSAGE_USAGE));
    }

    @Test
    public void parse_validArgs_returnsLoadCourtCommand() {
        TestImage.createTestImage();
        Image testImage = TestImage.getTestImage();
        String testImageName = testImage.imageName;
        LoadCourtCommand expectedLoadCourtCommand = new LoadCourtCommand(testImage);

        assertParseSuccess(parser, testImageName, expectedLoadCourtCommand);

        TestImage.deleteTestImage();
    }

    @Test
    public void parse_invalidArgs_throwsParseException() {
        assertParseFailure(parser, "<test>.jpg", String.format(
                MESSAGE_INVALID_COMMAND_FORMAT, LoadCourtCommand.MESSAGE_USAGE));

        assertParseFailure(parser, "/", String.format(
                MESSAGE_INVALID_COMMAND_FORMAT, LoadCourtCommand.MESSAGE_USAGE));

        assertParseFailure(parser, "", String.format(
                MESSAGE_INVALID_COMMAND_FORMAT, LoadCourtCommand.MESSAGE_USAGE));
    }
}
