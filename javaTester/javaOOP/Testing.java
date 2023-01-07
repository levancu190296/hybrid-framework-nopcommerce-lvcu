package javaOOP;

public class Testing {

	public static void main(String[] args) {
		Topic_07_Getter_Setter topic = new Topic_07_Getter_Setter();
		// happy case
		topic.setPersonName("david lee");
		System.out.println(topic.getPersonName());

		// un_happy case
		topic.setPersonName(null);
		System.out.println(topic.getPersonName());

		// un_happy case age
		topic.setPersonAge(10);
		System.out.println(topic.getPersonAge());
	}

}
