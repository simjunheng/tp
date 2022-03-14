package seedu.address.logic.parser;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TAG;

import seedu.address.commons.core.index.Index;
import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.logic.commands.DeleteTagCommand;
import seedu.address.logic.parser.exceptions.ParseException;

public class DeleteTagCommandParser implements Parser {
    /**
     * Parses the given {@code String} of arguments in the context of the {@code DeleteTagCommand}
     * and returns a {@code DeleteTagCommand} object for execution
     * * @param args Input string by user EXCEPT COMMAND WORD
     *
     * @return DeleteTagCommand object with arguments loaded in
     * @throws ParseException If the user input does not conform to the expected format
     */
    public DeleteTagCommand parse(String args) throws ParseException {
        requireNonNull(args);
        ArgumentMultimap argMultimap = ArgumentTokenizer.tokenize(args, PREFIX_TAG);

        // Get index with ParserUtil instead of ArgumentTokenizer methods
        Index index;
        try {
            index = ParserUtil.parseIndex(argMultimap.getPreamble());
        } catch (IllegalValueException ive) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, DeleteTagCommand.MESSAGE_USAGE), ive);
        }

        // Get tag name with ArgumentTokenizer
        String tagName = argMultimap.getValue(PREFIX_TAG).orElse("");

        return new DeleteTagCommand(index, tagName);
    }

}
