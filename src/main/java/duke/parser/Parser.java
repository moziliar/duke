package duke.parser;

import duke.DukeException;
import duke.command.Command;
import duke.command.DoneCommand;
import duke.command.ByeCommand;
import duke.command.ListCommand;
import duke.command.DeleteCommand;
import duke.command.TodoCommand;
import duke.command.DeadlineCommand;
import duke.command.EventCommand;
import duke.command.FindCommand;

public class Parser {

    /**
     * Parses the input string and generates Command object
     * based on the input task type and relevant details.
     * Throws DukeException when the input does not fit into
     * any type.
     *
     * @param input Input string.
     * @return Command generated.
     * @throws DukeException When input does not fit any types.
     */
    public Command parse(String input) throws DukeException {
        String taskType = input.split(" ")[0];
        int index;

        switch (taskType) {
        case "bye":
            return new ByeCommand();
        case "done":
            index = Integer.parseInt(input.split(" ")[1]);
            return new DoneCommand(index);
        case "list":
            return new ListCommand();
        case "delete":
            index = Integer.parseInt(input.split(" ")[1]);
            return new DeleteCommand(index);
        case "todo":
            return new TodoCommand(input.substring(5));
        case "deadline":
            return new DeadlineCommand(input.substring(5));
        case "event":
            return new EventCommand(input.substring(5));
        case "find":
            return new FindCommand(input.substring(5));
        default:
            throw new DukeException("     OOPS!!! I'm sorry, "
                    + "but I don't know what that means :-(");
        }
    }
}
