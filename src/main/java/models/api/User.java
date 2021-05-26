package models.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User{

	private String firstName;
	private String lastName;
	private String password;
	private int userStatus;
	private String phone;
	private String id;
	private String email;
	private String username;
}