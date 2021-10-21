package by.training.task.view;

/**
 * interface for working with the view
 */
public interface Screen {

    /**
     * display method on the screen
     * @param string data row
     */
    void show(String string);

    /**
     * screen reading method
     * @return data row
     */
    String read();

    /**
     * select languages
     * @param messageManager enum that contain type of languages
     */
    void setMessageManager(MessageManager messageManager);
}
