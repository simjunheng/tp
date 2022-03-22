package seedu.address.logic.parser.strategy;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import seedu.address.logic.commands.strategy.AddPlayerCommand;
import seedu.address.logic.parser.Parser;
import seedu.address.logic.parser.exceptions.ParseException;

/**
 * Parses input arguments and creates a new AddPlayerCommand object
 */

public class AddPlayerCommandParser implements Parser<AddPlayerCommand> {
    /**
     * Parses the given {@code String} of arguments in the context of the {@code AddPlayerCommand}
     * and returns an {@code AddPlayerCommand} object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public AddPlayerCommand parse(String args) throws ParseException {
        try {
            String[] splitArgs = args.trim().split("\\s+", 1);
            return new AddPlayerCommand(splitArgs[0]);
        } catch (IndexOutOfBoundsException pe) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, AddPlayerCommand.MESSAGE_USAGE), pe);
        }
    }
}
