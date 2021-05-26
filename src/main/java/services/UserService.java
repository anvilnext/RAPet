package services;

import models.api.User;
import models.api.ApiResponse;

public interface UserService extends BasicService {

    User getUser(String username);
    ApiResponse postUser(User user);
    ApiResponse putUser(String username, User user);
    ApiResponse loginUser(String login, String password);

}
