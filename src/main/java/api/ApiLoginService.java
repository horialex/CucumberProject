package api;

import com.google.inject.Inject;

import config.TestContext;
import constants.ApiConstants;
import constants.ContextKeyConstants;
import entities.Login;
import entities.User;
import tools.factories.LoginFactory;
import tools.utils.InstanceUtils;

public class ApiLoginService {

	@Inject
	AbstractApi abstractApiSteps;
	@Inject
	LoginFactory loginFactory;
	@Inject
	TestContext context;

	public void loginAsAdmin() {
		Login loginRequest = loginFactory.getLoginInstance();
		User userResponse = abstractApiSteps.createResource(ApiConstants.LOGIN, loginRequest, User.class);
		loginRequest.setUser((User) InstanceUtils.mergeObjects(loginRequest.getUser(), userResponse));
		AbstractApi.extraHeaders.put("Authorization", "Basic " + userResponse.getAuthenticationToken());
		
		context.set(ContextKeyConstants.USER, loginRequest.getUser());
	}

}
