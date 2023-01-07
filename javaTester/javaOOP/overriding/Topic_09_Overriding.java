package javaOOP.overriding;
// lien quan den tinh chat da dinh, ke thua, tru tuong
// overriding: class con ghi đè 1 class cha, để thay đổi hành vi phù hợp
// cho class con, giống tên hàm, giống kiểu trả về

public class Topic_09_Overriding {
	
	public static void main(String[] args) {
		
		Student s = new Student();
		s.eat();
		s.sleep();
		
		Employee e = new Employee();
		e.eat();
		e.sleep();
		e.workingTime();
		
	}

}
