package P3;

import java.util.ArrayList;
import java.util.List;

public class Person {
	private String Pname;
	private List<Person> friendList = new ArrayList<Person>();
	
	//Person��Ĺ��췽��
	public Person(String name) {
		// TODO �Զ����ɵĹ��캯�����
		this.Pname = name;
	}
	
	//��ȡʵ��������
	public String getName() {
		return Pname;
	}
	
	//��ȡPerson�������б�
	public List<Person> getFriendList(){
		return this.friendList;
	}
	
	//ΪPerson�������
	public void addFriend(Person friend) {
		friendList.add(friend);
	}
}
