
public class node {

	IMF_member x;
	Point location;
	int dept = 0;
	int cost;
	boolean goal;
	int c;
	String transition;

	node left;
	node right;
	node up;
	node down;
//	node carry;
//	node drop;

	public node(IMF_member x, Point location, int dept, int cost, boolean goal, int c, String transition) {
		super();
		this.x = x;
		this.location = location;
		this.cost = cost;
		this.goal = goal;
		this.c = c;
		this.transition = transition;
		this.left = null;
		this.right = null;
		this.up = null;
		this.down = null;
//		this.carry = null;
//		this.drop = null;
		
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
		if (location == null)
			return true;
		return false;
	}
	String printNode() {
//		System.out.println(this.location+" : "+ this.x.name);
//		if(this.location!=null) {
//			if(this.x!=null) {
//				return (this.location.print()+" : "+this.x.name+" : "+this.transition);
//			}else {
//				return (this.location.print()+" : "+"noName"+" : "+this.transition);
//			}
//		}
		return this+"";
			
		
		
	}
	
	public static void main (String[]args) {
//		IMF_member m=new IMF_member(new Point(1,2), "E");
//		node n=new node (m, m.point,0,0, false,m.c, "null");
//		n.printNode();
	}

}
