package by.training.task.controller;

/**
 * interface for working with the command
 */
public interface Command {
    /**
     * The method that implements the execution of a certain constant
     * @param request the variable containing the name of the command
     * @return answer is the task completed or not
     */
    String execute(String request);
}
