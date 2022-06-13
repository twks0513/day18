package day18;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Ex01 {

	public static void main(String[] args) throws Exception {
		File path = new File("D:/220509방은혁/file/aaa.txt");
		// stream : 연결통로
		FileOutputStream os = new FileOutputStream(path);
		os.write('A');
		os.write(97);
		
		String s = "hello";
		os.write(s.getBytes());
	}

}
