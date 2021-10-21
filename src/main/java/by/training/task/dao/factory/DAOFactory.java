package by.training.task.dao.factory;

import by.training.task.dao.TextDAO;
import by.training.task.dao.impl.FileTextDAO;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(staticName = "getInstance")
public final class DAOFactory {
    @Getter
    private final TextDAO fileTextDAO = new FileTextDAO();
}