package com.dandaevit.edu.jdbc.jsp_utils;

import lombok.experimental.UtilityClass;

@UtilityClass
public class JSPUtils {
	private final static String JSP_FORMAT = "/WEB-INF/pages/%s.jsp";

	public String getPath(String jsp){
		return JSP_FORMAT.formatted(jsp);
	}
}
