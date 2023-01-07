//topic 62
package javaOOP;

public class Topic_01_Class_And_Object_Practice {
	public int studentID;
	private String studentName;
	private float knowlefgePoint;
	private float practicePoint;
	
	
	private int getStudentID() {
		return studentID;
	}

	private void setStudentID(int studentID) {
		this.studentID = studentID;
	}

	private String getStudentName() {
		return studentName;
	}

	private void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	private float getKnowlefgePoint() {
		return knowlefgePoint;
	}

	private void setKnowlefgePoint(float knowlefgePoint) {
		this.knowlefgePoint = knowlefgePoint;
	}

	private float getPracticePoint() {
		return practicePoint;
	}

	private void setPracticePoint(float practicePoint) {
		this.practicePoint = practicePoint;
	}

	private Float getAveragePoint() {
		return (this.knowlefgePoint + this.practicePoint*2)/3;
	}
	private void showStudentInfor() {
		System.out.println("####################################################");
		System.out.println("Student ID = " + getStudentID());
		System.out.println("Student name = " + getStudentName());
		System.out.println("Student knowlefge Point = " + getKnowlefgePoint());
		System.out.println("Student practice Point = " + getPracticePoint());
		System.out.println("Student Average Point = " + getAveragePoint());
		System.out.println("####################################################");
	}
	
	public static void main(String[] args) {
		Topic_01_Class_And_Object_Practice firstStudent = new Topic_01_Class_And_Object_Practice();
		//instance variable
		firstStudent.studentID = 312321;
		
		
		firstStudent.setStudentID(14411000);
		firstStudent.setStudentName("Rose");
		firstStudent.setKnowlefgePoint(7.0f);
		firstStudent.setPracticePoint(7.0f);
		firstStudent.showStudentInfor();
		
		Topic_01_Class_And_Object_Practice secondStudent = new Topic_01_Class_And_Object_Practice();
		secondStudent.setStudentID(14411000);
		secondStudent.setStudentName("Jenny");
		secondStudent.setKnowlefgePoint(7.0f);
		secondStudent.setPracticePoint(7.0f);
		secondStudent.showStudentInfor();
		
	}
	

}
