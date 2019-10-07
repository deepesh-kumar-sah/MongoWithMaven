package com.deepesh.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;

public class Helper { 
	public static String encodeURIComponent(String s) {
		String result = null;

		try {
			result = URLEncoder.encode(s, "UTF-8")
					.replaceAll("\\+", "%20")
					.replaceAll("\\%21", "!")
					.replaceAll("\\%27", "'")
					.replaceAll("\\%28", "(")
					.replaceAll("\\%29", ")")
					.replaceAll("\\%7E", "~");
		}
		catch (UnsupportedEncodingException e) {
			result = s;
		}

		return result;
	}
	
	
	public static boolean isStringExist(String str, String...strarr) {
		for(String s:strarr) {
			if (s.equalsIgnoreCase(str)) {
				return true;
			}
		}
		return false;
	}
}
