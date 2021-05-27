package services;

import models.api.User;

public interface UserService extends BasicService {

    User getUser(String username);
    void postUser(User user);
    void putUser(String username, User user);
    void loginUser(String login, String password);

}
