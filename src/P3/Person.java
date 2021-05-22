package P3;

import java.util.ArrayList;
import java.util.List;

public class Person {
	private String Pname;
	private List<Person> friendList = new ArrayList<Person>();
	
	public Person(String name) {
		// TODO �Զ����ɵĹ��캯�����
		this.Pname = name;
	}
	
	public String getName() {
		return Pname;
	}
	
	public List<Person> getFriendList(){
		return this.friendList;
	}
	
	public void addFriend(Person friend) {
		friendList.add(friend);
	}
}
