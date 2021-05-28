package services;

import models.api.DataItem;
import models.api.User;

import java.util.List;

public interface ReqresService {

    String getLastNameFromListOfUsers(int page, int idOnPage);
    List<DataItem> getUserDataFromListOfUsers(int page, int idOnPage);
    void loginUser(String login, String password);
}
