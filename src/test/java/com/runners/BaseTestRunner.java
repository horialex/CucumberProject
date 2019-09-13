package com.runners;

import org.junit.Before;

import injector.AppInjector;

public class BaseTestRunner {

	@Before
	public void setup() {
		AppInjector.getInjector().injectMembers(this);
	}

}
