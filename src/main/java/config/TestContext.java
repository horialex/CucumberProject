package config;

import static java.lang.ThreadLocal.withInitial;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.inject.Singleton;

@Singleton
public class TestContext {

	private final ThreadLocal<Map<String, Object>> testContexts = withInitial(HashMap::new);

	@SuppressWarnings("unchecked")
	public <T> T get(String name) {
		return (T) testContexts.get().get(name);
	}

	public <T> T set(String name, T object) {
		testContexts.get().put(name, object);
		return object;
	}

	public void reset() {
		testContexts.get().clear();
	}
	
	public void printContext() {
		for (Map.Entry<String, Object> entry : testContexts.get().entrySet()) {
		    System.out.println(entry.getKey()+" : " +entry.getValue());
		}
	}
	
	@SuppressWarnings("unchecked")
	public void saveObjectInContextList(String key, Object obj) {
		if (!testContexts.get().containsKey(key)) {
			testContexts.get().put(key, new ArrayList<>());
		}
		((List<Object>) testContexts.get().get(key)).add(obj);
	}
	
}
