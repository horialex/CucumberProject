package tools.utils;

import java.util.ArrayList;
import java.util.List;

import net.serenitybdd.core.Serenity;

public class SerenitySessionUtils {

	@SuppressWarnings("unchecked")
	public static <T> T getFromSession(String key) {
		return (T) Serenity.getCurrentSession().get(key);
	}

	public static void putOnSession(String key, Object object) {
		Serenity.getCurrentSession().put(key, object);
	}

	@SuppressWarnings("unchecked")
	public static void saveObjectInSerenityList(String key, Object obj) {
		if (!Serenity.getCurrentSession().containsKey(key)) {
			Serenity.getCurrentSession().put(key, new ArrayList<>());
		}
		((List<Object>) Serenity.getCurrentSession().get(key)).add(obj);
	}
	
}
