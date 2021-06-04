package services;

import io.restassured.response.Response;
import models.api.DataItem;
import models.api.UserList;

import java.util.List;

public interface ReqresService {

    UserList getUserList(int page);
    List<DataItem> getUserDataFromListOfUsers(int page);
    Response getResponseUserList(int page);
    void loginUser(String login, String password);
}
