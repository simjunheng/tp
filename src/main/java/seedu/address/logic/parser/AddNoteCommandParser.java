package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.AddNoteCommand;
import seedu.address.logic.commands.DeleteCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.note.Note;

/**
 * Parses input arguments and creates a new {@code AddNoteCommand} object
 */
public class AddNoteCommandParser implements Parser<AddNoteCommand> {
    /**
     * Parses the given {@code String} of arguments in the context of the {@code AddNoteCommand}
     * and returns a {@code AddNoteCommand} object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public AddNoteCommand parse(String args) throws ParseException {
        try {
            String[] splitArgs = args.trim().split("\\s+", 2);
            Index index = ParserUtil.parseIndex(splitArgs[0]);
            Note note = ParserUtil.parseNote(splitArgs[1]);
            return new AddNoteCommand(index, note);
        } catch (ParseException pe) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, DeleteCommand.MESSAGE_USAGE), pe);
        }
    }
}
