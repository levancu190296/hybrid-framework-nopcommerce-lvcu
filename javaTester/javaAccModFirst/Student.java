package javaAccModFirst;

public class Student {
	private int age;
	// gán dữ liệu cho age thông qua hàm, tức là k truy trực tiếp tới biến age mà phải thông qua 1 hàm
	public void setAge(int enterAge) {
		if (enterAge > 0) {
			this.age = enterAge;
		}else {
			System.out.println("Age just typing is invalid");
		}
	}
	public int getAge() {
		return this.age;
	}
	
}
