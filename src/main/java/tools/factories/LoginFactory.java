package tools.factories;

import constants.EnvironmentConstants;
import entities.Login;
import entities.User;

public class LoginFactory {

	public Login getLoginInstance() {
		Login login = new Login();
		User user = new User();
		user.setEmail(EnvironmentConstants.USER);
		user.setPassword(EnvironmentConstants.PASS);
		user.setName(EnvironmentConstants.USER_NAME);
		login.setUser(user);

		return login;
	}
}
