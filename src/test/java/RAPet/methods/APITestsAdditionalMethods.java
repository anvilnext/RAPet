package RAPet.methods;

import io.cucumber.datatable.DataTable;
import models.api.User;

public class APITestsAdditionalMethods {

    public static User buildUser(DataTable table) {
        User newUser = User.builder()
                .id(table.row(1).get(0))
                .username(table.row(1).get(1))
                .firstName(table.row(1).get(2))
                .lastName(table.row(1).get(3))
                .email(table.row(1).get(4))
                .password(table.row(1).get(5))
                .phone(table.row(1).get(6))
                .userStatus(Integer.parseInt(table.row(1).get(7)))
                .build();
        return newUser;
    }
}
