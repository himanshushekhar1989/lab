package lab;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.FileUtils;

public class FileUtil {

	public static String getFile(String payload) {
		String ocnPayload = null;
		try {
			File file = new File(FileUtil.class.getClassLoader().getResource(payload).getFile());
			ocnPayload = FileUtils.readFileToString(file, StandardCharsets.UTF_8);
		} catch (IOException e) {

		}
		return ocnPayload;
	}
}
