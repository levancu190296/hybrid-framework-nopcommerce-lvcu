// khi class con ke thua class cha ma class cha co ham contrutor 
//thi thang con cung phai co ham khoi tao va goi qua 1 contructor nao do cua class cha
//cach taoj setter function bang eclip: right mouse/ source/generate getter and setter
//ctrl + shift + F để tu dong chinh fotmat dep cho code
//convert data: kieudulieu.valueof().xxx

package javaOOP;

public class Topic_07_Getter_Setter {
	private String personName;
	private int personAge;

	public void showPersonInfo() {
		System.out.println(this.personName);
		System.out.println(this.personAge);
	}

	public void setPersonName(String personName) {
		if (personName == null || personName.isEmpty() || personName.isBlank()) {
			throw new IllegalArgumentException("Nhap sai, vui long nhap lai");
		} else {
			this.personName = personName;
		}
	}

	public String getPersonName() {
		return this.personName;
	}

	public void setPersonAge(int personAge) {
		if (!String.valueOf(personAge).startsWith("1")) {
			throw new IllegalArgumentException("phai bat dau tu so 0 thi moi chap nhan, nhap so khac di");
		} else {
			this.personAge = personAge;
		}
	}

	public int getPersonAge() {
		return this.personAge;
	}

}
