package seedu.address.logic.parser;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import java.util.ArrayList;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.AddTagToTaskCommand;
import seedu.address.logic.commands.DeleteTagCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.tag.Tag;

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

        // Tokenize all arguments
        ArgumentMultimap argMultimap = ArgumentTokenizer.tokenize(args, new Prefix(""));

        // Convert the argMultimap into an ArrayList<> for easier access
        // The @ArgumentTokenizer produces a map with 3 elements:
        // Element 1: Whitespace
        // Element 2: Index
        // Element 3: tagName string
        ArrayList<String> values = new ArrayList<>(argMultimap.getAllValues(new Prefix("")));

        // Get the index element in the ArrayList
        int indexInt;
        try {
            indexInt = Integer.parseInt(values.get(1));
        } catch (Exception e) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, DeleteTagCommand.MESSAGE_USAGE));

        }
        Index index = Index.fromOneBased(indexInt); // Convert to fromOneBased index since contact list starts from 1

        // Get the tagName element in the ArrayList
        String tagName;
        try {
            tagName = values.get(2);
        } catch (IndexOutOfBoundsException e) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, DeleteTagCommand.MESSAGE_USAGE));
        }
        try {
            new Tag(tagName);
        } catch (Exception e) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                    DeleteTagCommand.MESSAGE_USAGE));
        }

        return new DeleteTagCommand(index, tagName);
    }

}
