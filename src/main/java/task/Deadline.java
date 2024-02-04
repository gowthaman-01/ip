package task;

import helpers.DateFormatter;

/**
 * Represents a deadline, which is a specialized form of task.Task.
 * This class adds a specific deadline to the task description.
 */
public class Deadline extends Task {
    private static final String DEADLINE_PREFIX = "[D]";
    private final String deadline;

    /**
     * Constructs a new task.Deadline with the given description and deadline.
     *
     * @param description The description of the deadline.
     * @param deadline The deadline date as a String.
     */
    public Deadline(String description, String deadline) {
        super(description);
        this.deadline = DateFormatter.formatDate(deadline.trim());
    }

    @Override
    public String convertTaskToFileString() {
        return String.format("D|%s|%s|%s", super.getIsDone() ? "1" : "0", this.description.trim(), this.deadline);
    }

    /**
     * Returns a string representation of the task.Deadline.
     * The string includes the task.Deadline identifier, followed by the task.Task's string representation,
     * and the specified deadline.
     */
    @Override
    public String toString() {
        return DEADLINE_PREFIX + super.toString() + " (by: " + this.deadline + ")";
    }
}