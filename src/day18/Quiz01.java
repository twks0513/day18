package day18;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Quiz01 {

	public static void main(String[] args) throws Exception {
		File path = new File("D:/220509방은혁/file/abcd1234.txt");
		
		FileOutputStream os = new FileOutputStream(path);
	
		String name = "방은혁";
		String age = "29";
		String addr = "서울시 양천구";
		os.write(name.getBytes());
		os.write('\n');
		os.write(age.getBytes());
		os.write('\n');
		os.write(addr.getBytes());

	}

}
