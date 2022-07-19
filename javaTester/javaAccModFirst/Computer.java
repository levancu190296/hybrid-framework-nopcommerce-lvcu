package javaAccModFirst;

public class Computer {
	//property
	private int ssdSize;
	String ramProductName;
	public float weight;
	protected String numberID;
	
	//method
	private void setsdSize(int ssd_size) {
		//dung this.ssdSize de phan biet la dang lay bien toan cuc, khi vo tinh biến toàn cục và cục bộ giống nhau
		//this.ssdSize = ssd_size; 
		ssdSize = ssd_size;
	}
	
	public  void setRamProductName(String ramID) {
		//dung this.ssdSize de phan biet la dang lay bien toan cuc, khi vo tinh biến toàn cục và cục bộ giống nhau
		//this.ssdSize = ssd_size; 
		numberID = ramID;
	}
	
	public static void main(String[] args) {
		Computer comp = new Computer();
		comp.ssdSize=500;
		comp.ramProductName="Kington";
		System.out.println(comp.ssdSize);
		//or
		comp.setsdSize(600);
		System.out.println(comp.ssdSize);
		
		
	}
}
