package util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Part;

public class Multipart {
	public static String upload(String path, Part part) throws IOException {
		String fileName = part.getSubmittedFileName().replaceAll("\\s", "_");
		try(InputStream is = part.getInputStream()){
			try(OutputStream os = new FileOutputStream(new File(path + fileName))){
				int len = 0;
				byte[] bytes = new byte[1024];
				while ( ( len = is.read(bytes, 0, 1024)) > 0) {
					os.write(bytes, 0, len);
				}
			}
		}
		return fileName;
	}
	public static List<String> upload(String path, Part[] parts) throws IOException {
		List<String> files = new ArrayList<String>(parts.length);
		for(Part part : parts) {
			String file = upload(path, part);
			files.add(file);
		}
		return files;
	}
}
