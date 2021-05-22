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
	
	/**
     * 添加一个人.
     * 
     * @param p the Person context
     */
	public void addVertex(Person p) {
		for (int i = 0; i < pList.size(); i++) {
			if (p.getName().equals(pList.get(i).getName())) {
				System.out.println("名字重复！");
				System.exit(0);
			}
		}
		pList.add(p);
	}
	
	/**
     * 添加一条边.
     * 
     * @param p1 起始的人
     * @param p2 指向的人
     */
	public void addEdge(Person p1, Person p2) {
		p1.addFriend(p2);
	}
	
	/**
     * 获取两人间的距离.
     * 
     * @param p1 起始的人
     * @param p2 目标的人
     */
	public int getDistance(Person p1, Person p2) {
		
		//p1和p2重合的情况
		if (p1 == p2) {
			return 0;
		}
				
		Queue<Person> q = new LinkedList<Person>(); //通过队列存储
		Set<Person> visited = new HashSet<Person>(); //判断是否访问过
		q.offer(p1);
		visited.add(p1);
		int step = 0;
		
		//BFS算法
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
		
		//p1不能到达p2
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
		graph.addVertex(rachel);
		//graph.addVertex(ross);
		graph.addVertex(ben);
		graph.addVertex(kramer);
		//graph.addEdge(rachel, ross);
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
