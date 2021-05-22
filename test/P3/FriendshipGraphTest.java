package P3;

import static org.junit.Assert.*;

import org.junit.Test;

public class FriendshipGraphTest {
	
	@Test
	public void addVertexTest() {
		FriendshipGraph FG = new FriendshipGraph();
		Person vardy = new Person("Vardy");
		Person ndidi = new Person("Ndidi");
		Person tielemans = new Person("Tielemans");
		Person maddison = new Person("Maddison");
		Person barnes = new Person("Barnes");
		Person soyuncu = new Person("soyuncu");
		
		assertEquals(0, FG.getGraph().size());
		
		FG.addVertex(vardy);
		assertEquals(1, FG.getGraph().size());
		
		FG.addVertex(ndidi);
		assertEquals(2, FG.getGraph().size());
		
		FG.addVertex(tielemans);
		assertEquals(3, FG.getGraph().size());
		
	}

	@Test
	public void getDistanceTest() {
		FriendshipGraph FG = new FriendshipGraph();
		Person vardy = new Person("Vardy");
		Person ndidi = new Person("Ndidi");
		Person tielemans = new Person("Tielemans");
		Person maddison = new Person("Maddison");
		Person barnes = new Person("Barnes");
		Person soyuncu = new Person("soyuncu");
		
		FG.addVertex(vardy);
		FG.addVertex(ndidi);
		FG.addVertex(tielemans);
		FG.addVertex(maddison);
		FG.addVertex(barnes);
		FG.addVertex(soyuncu);
		
		FG.addEdge(vardy, ndidi);
		FG.addEdge(ndidi, vardy);
		FG.addEdge(vardy, barnes);
		FG.addEdge(barnes, vardy);
		FG.addEdge(ndidi, tielemans);
		FG.addEdge(tielemans, ndidi);
		FG.addEdge(tielemans, maddison);
		FG.addEdge(maddison, tielemans);
		
		assertEquals(-1, FG.getDistance(vardy, soyuncu));
		assertEquals(0, FG.getDistance(vardy, vardy));
		assertEquals(1, FG.getDistance(vardy, ndidi));
		assertEquals(1, FG.getDistance(ndidi, vardy));
		assertEquals(2, FG.getDistance(vardy, tielemans));
		assertEquals(3, FG.getDistance(vardy, maddison));
	}

}
