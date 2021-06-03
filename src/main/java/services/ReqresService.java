package services;

import models.api.DataItem;
import models.api.UserList;

import java.util.List;

public interface ReqresService {

    UserList getUserList(int page);
    List<DataItem> getUserDataFromListOfUsers(int page, int idOnPage);
    void loginUser(String login, String password);
}
