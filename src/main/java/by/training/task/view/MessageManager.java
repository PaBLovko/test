package by.training.task.view;

import java.util.Locale;
import java.util.ResourceBundle;

public enum MessageManager {

    EN(ResourceBundle.getBundle("text.lang",  new Locale("en", "US"))),
    RU(ResourceBundle.getBundle("text.lang", new Locale("ru", "RU")));

    private ResourceBundle bundle;

    MessageManager(ResourceBundle bundle) {
        this.bundle = bundle;
    }

    public String getString(String key) {
        return bundle.getString(key);
    }
}
