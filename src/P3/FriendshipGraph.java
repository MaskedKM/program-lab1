package P3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class FriendshipGraph {
	
	private List<Person> pList = new ArrayList<Person>();
	
	public List<Person> getGraph(){
		return pList;
	}
	
	public void addVertex(Person p) {
		for (int i = 0; i < pList.size(); i++) {
			if (p.getName().equals(pList.get(i).getName())) {
				System.out.println("名字重复！");
				return ;
			}
		}
		pList.add(p);
	}
	
	public void addEdge(Person p1, Person p2) {
		p1.addFriend(p2);
	}
	
	public int getDistance(Person p1, Person p2) {
		if (p1 == p2) {
			return 0;
		}
		
		Queue<Person> q = new LinkedList<Person>();
		Set<Person> visited = new HashSet<Person>();
		q.offer(p1);
		visited.add(p1);
		int step = 0;
		
		while(!q.isEmpty()) {
			int n = q.size();
			
			for (int i = 0; i < n; i++) {
				Person temp = q.poll();
				
				if(temp == p2) {
					return step;
				}
				
				for (Person x : temp.getFriendList()) {
					if(!visited.contains(x)) {
						q.offer(x);
						visited.add(x);
					}
				}
			}
			step++;
		}
		
		return -1;
		
	}

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		FriendshipGraph graph = new FriendshipGraph();
		Person rachel = new Person("Rachel");
		Person ross = new Person("Ross");
		Person ben = new Person("Ben");
		Person kramer = new Person("Kramer");
		graph.addVertex(rachel);
		graph.addVertex(ross);
		graph.addVertex(ben);
		graph.addVertex(kramer);
		graph.addEdge(rachel, ross);
		graph.addEdge(ross, rachel);
		graph.addEdge(ross, ben);
		graph.addEdge(ben, ross);
		System.out.println(graph.getDistance(rachel, ross)); 
		//should print 1
		System.out.println(graph.getDistance(rachel, ben)); 
		//should print 2
		System.out.println(graph.getDistance(rachel, rachel)); 
		//should print 0
		System.out.println(graph.getDistance(rachel, kramer)); 
		//should print -1
	}

}
