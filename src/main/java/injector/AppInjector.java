package injector;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class AppInjector {

	private static Injector injector = Guice.createInjector();

	public static Injector getInjector() {
		return injector;
	}

}
