package tools.utils;

import org.apache.commons.lang3.StringUtils;

public class StringHelpers {

	public static String cleanZeroLeadingStrings(String no) {
		return StringUtils.stripStart(no,"0");
	}
}
