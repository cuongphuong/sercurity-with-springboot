package cpg.sr.security.commons;

public class StringUtils {
	
	public static String[] parseURL(String url) {
		return url.split("/");
	}
}
