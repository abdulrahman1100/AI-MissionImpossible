import java.util.TreeSet;

abstract public class generic_search {
	
	TreeSet<String> state_space;
	node initialState;
	String setOfOperators;

//	abstract void BFS(node initialNode);
//	abstract void pathCost();
//	abstract void goalTest();
	abstract Point transition(String t,Point p);
	abstract void action(Point p);
	

}
