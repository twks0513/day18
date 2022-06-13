package day18;

import java.io.*;
import java.util.Scanner;

class AAA implements Serializable{
	String name;
	String addr;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	
}


public class Ex06 {

	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		String name,addr;
		
		System.out.println("1.저장");
		System.out.println("2.가져오기");
		int num = scan.nextInt();
		String path = new String("D:/220509방은혁/file/");
		
		AAA info = null;
		
		if(num == 1) {
			System.out.println("이름입력");
			name = scan.next();
			System.out.println("주소 입력");
			addr = scan.next();
			info = new AAA();
			
			info.setName(name);
			info.setAddr(addr);
			File path02 = new File(path+name+".txt");
			FileOutputStream fos = new FileOutputStream(path02);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			ObjectOutputStream oos = new ObjectOutputStream(bos);
			oos.writeObject(info);
			
			oos.close(); bos.close(); fos.close();
			System.out.println("저장 되었습니다");
		}else {
			File list = new File(path);
			String[] li = list.list();
			for(int i = 0;i<li.length;i++) {
				System.out.println(li[i]);
			}
			for(String a : li) {
				System.out.println(a);
			}
			System.out.println("확인할 이름 입력");
			name = scan.next();
			File p = new File(path+name+".txt");
			
			FileInputStream fis = new FileInputStream(p);
			BufferedInputStream bis = new BufferedInputStream(fis);
			ObjectInputStream ois = new ObjectInputStream(bis);
			
			info = (AAA)ois.readObject();
			
			System.out.println("이름 : "+info.getName());
			System.out.println("주소 : "+info.getAddr());
			
		}

	}

}
