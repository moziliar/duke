package duke.parser;

import duke.DukeException;
import duke.command.Command;
import duke.command.DoneCommand;
import duke.command.ByeCommand;
import duke.command.PrintCommand;
import duke.command.DeleteCommand;
import duke.command.TodoCommand;
import duke.command.DeadlineCommand;
import duke.command.EventCommand;
import duke.command.FindCommand;

public class Parser {

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
            return new PrintCommand();
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
            throw new DukeException("     \u2639 OOPS!!! I'm sorry, " +
                   "but I don't know what that means :-(");
        }
    }
}