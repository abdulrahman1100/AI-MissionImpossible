
public class node {
	
	IMF_member x;
	Point p;
	int dept=0;
	int cost;
	boolean goal;
	int c;
	String transition;
	
	
	node left;
	node right;
	node up;
	node down;
	node carry;
	node drop;
	
	

	public node(IMF_member x, Point p, int dept, int cost, boolean goal, int c, String transition) {
		super();
		this.x = x;
		this.p = p;
		this.cost = cost;
		this.goal = goal;
		this.c = c;
		this.transition = transition;
		this.left = null;
		this.right = null;
		this.up = null;
		this.down = null;
		this.carry = null;
		this.drop = null;
	}
	
	public node() {
		
	}
	
	public IMF_member getX() {
		return x;
	}
	public void setX(IMF_member x) {
		this.x = x;
	}

	public boolean isGoal() {
		return goal;
	}
	public void setGoal(boolean goal) {
		this.goal = goal;
	}
	public String getTransition() {
		return transition;
	}
	public void setTransition(String transition) {
		this.transition = transition;
	}
	
	public boolean is_null() {
		if(p==null)
			return true;
		return false;
	}
	
	

}
