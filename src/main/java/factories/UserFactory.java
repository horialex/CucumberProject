package factories;

import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;

import models.User;

public class UserFactory {

	public static User createUser() {
		int length = 10;
		boolean useLetters = true;
		boolean useNumbers = false;
		String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);
		Random rand = new Random();
		int n = rand.nextInt(50);
		n += 1;
		User user = new User();
		user.setName(generatedString);
		user.setAge(n);

		return user;
	}

}
