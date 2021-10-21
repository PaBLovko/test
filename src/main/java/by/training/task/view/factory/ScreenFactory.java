package by.training.task.view.factory;

import by.training.task.view.Screen;
import by.training.task.view.impl.ConsoleScreen;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(staticName = "getInstance")
public final class ScreenFactory {
    @Getter
    private final Screen consoleScreen = new ConsoleScreen();
}

