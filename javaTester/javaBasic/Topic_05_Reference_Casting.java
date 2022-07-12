package javaBasic;

public class Topic_05_Reference_Casting {
	public String studentName;
	public String getStudentName(String a) {
		return a;
	}
	
	public void setStudentName(String a) {
		this.studentName= a;
	}
	
	public void showResidentName() {
		System.out.println(studentName);
	}
	
	public static void main(String[] args) {
		Topic_05_Reference_Casting fisrtStudent = new Topic_05_Reference_Casting();
		Topic_05_Reference_Casting secondStudent = new Topic_05_Reference_Casting();
		
		fisrtStudent.setStudentName("le van first");
		secondStudent.setStudentName("nguyen van second");
		
		fisrtStudent.showResidentName();
		secondStudent.showResidentName();
		
		
		//ep kieu
		fisrtStudent = secondStudent;
		
		fisrtStudent.showResidentName();
		secondStudent.showResidentName();
		
		secondStudent.setStudentName("nguyen van change");
		fisrtStudent.showResidentName();
		secondStudent.showResidentName();
		
	}


}
