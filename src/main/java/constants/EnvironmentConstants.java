package constants;

import tools.persistance.PropertyFileReader;

public class EnvironmentConstants {

	public static final String BASE_URL = PropertyFileReader.getEnvConstantsItem("BASE_URL");
	public static final String USER = PropertyFileReader.getEnvConstantsItem("USER");
	public static final String PASS = PropertyFileReader.getEnvConstantsItem("PASS");
	public static final String USER_NAME = PropertyFileReader.getEnvConstantsItem("USER_NAME");
}
