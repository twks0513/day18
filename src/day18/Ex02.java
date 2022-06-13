package day18;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Scanner;

public class Ex02 {

	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		String id;
		String pw;
		while(true) {
			System.out.println("등록 아이디 입력");
			id = scan.next();
			File path = new File("D:/220509방은혁/file/"+id+".txt");
			if(path.exists()){ // 해당파일이 존재할때
				System.out.println("존재하는 아이디 입니다.");
			}else { // 해당파일이 존재하지 않을때
				System.out.println("비밀번호 입력");
				pw = scan.next();
				FileOutputStream fos = new FileOutputStream(path);			
				fos.write(id.getBytes());
				fos.write(pw.getBytes());
				System.out.println("등록 되었습니다.");
			}
		}
	}

}
