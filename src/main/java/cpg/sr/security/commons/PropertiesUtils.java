package cpg.sr.security.commons;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtils {
	/* Create basic object */
	static ClassLoader objClassLoader = null;
	static Properties commonProperties = new Properties();
	private static final String FILE_NAME = "f.properties";

	public static String r(String key) {
		if (FILE_NAME != null && !FILE_NAME.trim().isEmpty() && key != null && !key.trim().isEmpty()) {
			objClassLoader = PropertiesUtils.class.getClassLoader();
			try (FileInputStream objFileInputStream = new FileInputStream(
					objClassLoader.getResource(FILE_NAME).getFile());) {
				/* Load file into properties file */
				commonProperties.load(objFileInputStream);
				/* Get the value of key */
				return String.valueOf(commonProperties.get(key));
			} catch (FileNotFoundException ex) {
				ex.printStackTrace();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return null;
	}
}
