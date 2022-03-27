package seedu.address.logic.parser;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import java.util.ArrayList;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.AddTagCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.tag.Tag;

public class AddTagCommandParser implements Parser {
    /**
     * Parses the given {@code String} of arguments in the context of the {@code DeleteTagCommand}
     * and returns a {@code DeleteTagCommand} object for execution
     * * @param args Input string by user EXCEPT COMMAND WORD
     *
     * @return DeleteTagCommand object with arguments loaded in
     * @throws ParseException If the user input does not conform to the expected format
     */
    public AddTagCommand parse(String args) throws ParseException {
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
        int indexInt = Integer.parseInt(values.get(1));
        Index index = Index.fromOneBased(indexInt); // Convert to fromOneBased index since contact list starts from 1

        // Get the tagName element in the ArrayList
        String tagName = values.get(2);
        try {
            new Tag(tagName);
        } catch (Exception e) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                    AddTagCommand.MESSAGE_USAGE));
        }

        return new AddTagCommand(index, tagName);
    }

}
