package P3;

import java.util.ArrayList;
import java.util.List;

public class Person {
	private String Pname;
	private List<Person> friendList = new ArrayList<Person>();
	
	//Person类的构造方法
	public Person(String name) {
		// TODO 自动生成的构造函数存根
		this.Pname = name;
	}
	
	//获取实例的名字
	public String getName() {
		return Pname;
	}
	
	//获取Person的朋友列表
	public List<Person> getFriendList(){
		return this.friendList;
	}
	
	//为Person添加朋友
	public void addFriend(Person friend) {
		friendList.add(friend);
	}
}
