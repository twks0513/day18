package day18;

import java.io.*;
import java.util.Scanner;

class Student implements Serializable{
	String name;
	String num;
	String addr;
	public String getAddr() {return addr;}
	public void setAddr(String addr) {this.addr = addr;}
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	public String getNum() {return num;}
	public void setNum(String num) {this.num = num;}
	
}

public class Quiz02 {

	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		String name,num=null,addr;		
		Student st = null;
		boolean bool = true;
		String path = new String("D:/220509방은혁/fileQuiz/");
		File f01 = new File(path+num+".txt");
		
		while(bool) {
			System.out.println("1.추가 2.수정 3.삭제 4.검색 5.종료");
			System.out.print(">>> ");
			int choice = scan.nextInt();
			switch(choice) {
			case 1: 
				System.out.println("=== 학생정보 등록 ===");
				System.out.println("학번을 입력하세요");
				System.out.print(">>> ");
				num = scan.next();
				if(f01.exists()) {
					System.out.println("존재하는 학생입니다");
					continue;
				}else {
					System.out.println("이름을 입력하세요");
					System.out.print(">>> ");
					name = scan.next();
					System.out.println("주소를 입력하세요");
					System.out.print(">>> ");
					addr = scan.next();
					
					st = new Student();
					st.setName(name);
					st.setNum(num);
					st.setAddr(addr);
					File path02 = new File(path+num+".txt");
					FileOutputStream fos = new FileOutputStream(path02);
					BufferedOutputStream bos = new BufferedOutputStream(fos);
					ObjectOutputStream oos = new ObjectOutputStream(bos);
					oos.writeObject(st);
					oos.close(); bos.close(); fos.close();
					System.out.println("저장 되었습니다");
					break;
				}					
				
			case 2: 
				System.out.println("=== 학생정보 수정 ===");
				System.out.println("학번을 입력하세요");
				System.out.print(">>>> ");
				num = scan.next();
				f01 = new File(path+num+".txt");
				if(!f01.exists()) {
					System.out.println("존재하지 않는 학번입니다");
					continue;
				}else {
					st = new Student();
					FileInputStream fis = new FileInputStream(f01);
					BufferedInputStream bis = new BufferedInputStream(fis);
					ObjectInputStream ois = new ObjectInputStream(bis);
					
					st = (Student)ois.readObject();
					System.out.println("학번 : "+st.getNum());
					System.out.println("이름 : "+st.getName());
					System.out.println("주소 : "+st.getAddr());
					System.out.println("이름 입력");
					System.out.print(">>> ");
					name = scan.next();
					System.out.println("주소 입력");
					System.out.print(">>> ");
					addr = scan.next();
					st.setName(name);
					st.setAddr(addr);
					File path02 = new File(path+num+".txt");
					FileOutputStream fos = new FileOutputStream(path02);
					BufferedOutputStream bos = new BufferedOutputStream(fos);
					ObjectOutputStream oos = new ObjectOutputStream(bos);
					oos.writeObject(st);
					
					ois.close(); bis.close(); fis.close();
					oos.close(); bos.close(); fos.close();
					System.out.println("수정 되었습니다");
					break;
				}				
			case 3: 
				System.out.println("=== 학생정보 삭제 ===");
				System.out.println("학번을 입력하세요");
				System.out.print(">>> ");
				num = scan.next();
				f01 = new File(path+num+".txt");
				if(!f01.exists()) {
					System.out.println("존재하지 않는 학번입니다");
					continue;
				}else {
					st = new Student();
					FileInputStream fis = new FileInputStream(f01);
					BufferedInputStream bis = new BufferedInputStream(fis);
					ObjectInputStream ois = new ObjectInputStream(bis);					
					st = (Student)ois.readObject();
					ois.close(); bis.close(); fis.close();
					if(f01.delete()) {
						System.out.println(st.getName()+"학생의 정보가 삭제되었습니다");						
					}else {
						System.out.println(st.getName()+"학생의 정보가 삭제되지 않았습니다");
					}
					break;
				}
			case 4: 
				System.out.println("=== 학생정보 검색 ===");
				System.out.println("학번을 입력하세요");
				System.out.print(">>> ");
				num = scan.next();
				f01 = new File(path+num+".txt");				
				if(!f01.exists()) {
					System.out.println("존재하지 않는 학번입니다");
					continue;
				}else {
					st = new Student();
					FileInputStream fis = new FileInputStream(f01);
					BufferedInputStream bis = new BufferedInputStream(fis);
					ObjectInputStream ois = new ObjectInputStream(bis);
					
					st = (Student)ois.readObject();
					System.out.println("==========");
					System.out.println("학번 : "+st.getNum());
					System.out.println("이름 : "+st.getName());
					System.out.println("주소 : "+st.getAddr());
					System.out.println("==========");
					ois.close(); bis.close(); fis.close();
				}
				break;
			case 5:
				System.out.println("프로그램을 종료합니다");
				bool = false;
			}
		}
	}

}
