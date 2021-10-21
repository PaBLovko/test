package by.training.task.service.util;

import by.training.task.bean.User;

public class UserToString {
    public String convert(User user) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(user.getName());
        stringBuilder.append(" ");
        stringBuilder.append(user.getSurname());
        stringBuilder.append(" ");
        stringBuilder.append(user.getEmail());
        stringBuilder.append(" ");
        for (int i = 0; i <user.getRoles().size() ; i++) {
            stringBuilder.append(user.getRoles().get(i));
            stringBuilder.append(" ");
        }
        for (int i = 0; i <user.getPhoneNumbers().size() ; i++) {
            stringBuilder.append(user.getPhoneNumbers().get(i));
            stringBuilder.append(" ");
        }
        return stringBuilder.toString();
    }
}
