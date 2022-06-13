package day18;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Ex04 {

	public static void main(String[] args) throws Exception {
		File path = new File("D:/220509방은혁/file/aaa.txt");
		FileOutputStream fos = new FileOutputStream(path);
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		
		
		
		for(int i ='1'; i<'9'; i++) {
			//Thread.sleep(2000);
			bos.write(i);
		}
		bos.flush();
		
		

	}

}
