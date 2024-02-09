package utils;

import commands.AddCommand;
import commands.CommandType;
import commands.Command;
import commands.MarkCommand;
import commands.UnmarkCommand;
import commands.ListCommand;
import commands.DeleteCommand;
import commands.ExitCommand;

/**
 * The Parser class parses user input and returns the corresponding command object.
 */
public class Parser {
    /**
     * Parses the user input and returns the corresponding command object.
     *
     * @param input The user input as an array of strings.
     * @return The command object corresponding to the user input.
     * @throws IllegalArgumentException If the input is invalid.
     */
    public static Command parse(String[] input) throws IllegalArgumentException {
        String commandString = input[0];
        CommandType command = CommandType.valueOf(commandString.toUpperCase());
        switch (command) {
        case LIST:
            return new ListCommand();
        case TODO:
            return new AddCommand(CommandType.TODO, input);
        case DEADLINE:
            return new AddCommand(CommandType.DEADLINE, input);
        case EVENT:
            return new AddCommand(CommandType.EVENT, input);
        case MARK:
            return new MarkCommand(Integer.parseInt(input[1]));
        case UNMARK:
            return new UnmarkCommand(Integer.parseInt(input[1]));
        case DELETE:
            return new DeleteCommand(Integer.parseInt(input[1]));
        default:
            return new ExitCommand();
        }
    }
}