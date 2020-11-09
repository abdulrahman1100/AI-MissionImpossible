import java.io.PrintStream;
import java.util.LinkedList;

public class search_Tree {

	node root;
	static int mx;
	static int ny;
	
	static node dp[][];
	public search_Tree(node root,int mx, int ny) {

		this.root=root;
		this.mx = mx;
		this.ny = ny;
		dp=new node[mx][ny];
		System.out.println(mx+" "+ ny);
	}

	private node addRecursive(node current, Point location, IMF_member Grid[][]) {
		
//		"should take ethan location and then spread out "
//		if(Grid[location.x][location.y]==null) {
//			return null;
//		}
		
		String s = "";


		int x=location.x;
		int y=location.y;
		Point right =transition("right",new Point(x,y));
		Point left  =transition("left",new Point(x,y));
		Point up    =transition("up",new Point(x,y));
		Point down  =transition("down",new Point(x,y));


		if (current == null) { 
			System.out.println("one ");

//			System.out.println(Grid[location.x][location.y]);
			node n = new node(Grid[location.x][location.y], location, 0, 0, false, 0,s);
			dp[location.x][location.y]=n;
			return addRecursive(n,location,Grid);

		}
		
//		if(dp[location.x][location.y]!=null) {
//			return null;
//		}
//		
		if (right!=null) {
			// right
			System.out.println("right");
			s="right";
			current.transition=s;
			current.right = addRecursive(current.right,right,Grid);

		}

		if (left!=null) {
			// left
			s="left";
			System.out.println("left");
			current.transition=s;
			current.left = addRecursive(current.left,left,Grid);

		}if (up!=null) {
			// up
			s="up";
			System.out.println("up");
			current.transition=s;
			current.up = addRecursive(current.up,up,Grid);

		}if (down!=null) {
			// down
			s="down";
			System.out.println("down");
			current.transition=s;
			current.down = addRecursive(current.down,down,Grid);

		}
		

		return current;

	}
	
	Point transition(String t, Point p) {
		if (t.equals("right") && ((p.x) + 1 )< mx) {
			return p.setPoint((p.x + 1), p.y);
		}
		if (t.equals("left") && ((p.x) - 1) > 0) {
			return p.setPoint((p.x - 1), p.y);
		}
		if (t.equals("up") && ((p.y) - 1) > 0) {
			return p.setPoint(p.x, (p.y - 1));
		}

		if (t.equals("down") && ((p.y) + 1) < ny) {
			return p.setPoint(p.x, (p.y + 1));
		}
		return null;

	}

	public void add(Point location, IMF_member Grid[][]) {
		root = addRecursive(root, location, Grid);

	}

	void treeTraverse(StringBuilder sb, node n) {
		if (n != null) {
			sb.append(n.printNode());
			sb.append("\n");
			treeTraverse(sb, n.right);
			treeTraverse(sb, n.left);
			treeTraverse(sb, n.up);
			treeTraverse(sb, n.down);

		}

	}

	public void print(PrintStream os, node n) {
		StringBuilder sb = new StringBuilder();
		treeTraverse(sb, n);
		os.print(sb.toString());
	}

}
