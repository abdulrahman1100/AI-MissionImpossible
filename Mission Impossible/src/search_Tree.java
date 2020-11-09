import java.io.PrintStream;
import java.util.LinkedList;

public class search_Tree {

	node root;
	 int mx;
	 int ny;
	
	node dp[][];
	public search_Tree(node root,int mx, int ny) {

		
		this.root=root;
		this.mx = mx;
		this.ny = ny;
		
		dp=new node[2*mx][2*ny];
		
		
		System.out.println(mx+" "+ ny);
	}

	private node addRecursive(node current, Point location, IMF_member Grid[][],node nodeList[][]) {
		
//		"should take ethan location and then spread out "
//		if(Grid[location.x][location.y]==null) {
//			return null;
//		}
		
		String s = "";
//		if(location==null) {
//			return null;
//		}

		int x=location.x;
		int y=location.y;
		Point right =transition("right",new Point(x,y));
		Point left  =transition("left",new Point(x,y));
		Point up    =transition("up",new Point(x,y));
		Point down  =transition("down",new Point(x,y));


		if (current == null) { 
			System.out.println("one ");

			return null;
			
			

		}
		
		if (right!=null) {
			// right
			if(dp[right.x][right.y]==null) {
				System.out.println("right");
				s="right";
				node r=nodeList[right.x][right.y];
				dp[location.x][location.y]=r;
				current.transition=s;
				current.right = r;
				addRecursive(r,right,Grid,nodeList);
			}else {
				return null;
			}
			

		}

		if (left!=null) {
			// left
			if(dp[left.x][left.y]==null) {
				s="left";
				System.out.println("left");
				current.transition=s;
				node l=nodeList[left.x][left.y];
				dp[location.x][location.y]=l;
				current.left = addRecursive(l,left,Grid,nodeList);
			}else {
				return null;
			}
			

		}if (up!=null) {
			// up
			if(dp[up.x][up.y]==null) {
				s="up";
				System.out.println("up");
				current.transition=s;
				node u=nodeList[up.x][up.y];
				dp[location.x][location.y]=u;
				current.up = addRecursive(u,up,Grid,nodeList);
			}else {
				return null;
			}
			

		}if (down!=null) {
			// down
			if(dp[down.x][down.y]==null) {
				s="down";
				System.out.println("down");
				current.transition=s;
				node d=nodeList[down.x][down.y];
				dp[location.x][location.y]=d;
				current.down = addRecursive(d,down,Grid,nodeList);
			}else {
				return null;
			}
			

		}
		

		return current;

	}
//	public void insert(node n, Point location, IMF_member Grid[][],node nodeList[][]) {
//		int x=location.x;
//		int y=location.y;
//		Point right =transition("right",new Point(x,y));
//		Point left  =transition("left",new Point(x,y));
////		System.out.println(left.x+":"+left.y);
//		Point up    =transition("up",new Point(x,y));
//		Point down  =transition("down",new Point(x,y));
//		if(root==null) {
//			root=n;
//		}else {
//			node current=root;
//			node parent;
//			while(true) {
//				parent=current;
//				if(right!=null&&dp[right.x][right.y]==null){//go right 
//					current=current.right;
//					if(current==null) {
//						parent.right=n;
//						return;
//					}
//				}//go left 
//					
//					if(left!=null&&dp[left.x][left.y]==null){//go left 
//						current=current.left;
//						if(current==null) {
//							parent.left=n;
//							return;
//						}
//					}
//					if(up!=null&&dp[up.x][up.y]==null){//go up 
//						current=current.up;
//						if(current==null) {
//							parent.up=n;
//							return;
//						}
//					}
//					if(down!=null&&dp[down.x][down.y]==null){//go down 
//						current=current.down;
//						if(current==null) {
//							parent.down=n;
//							return;
//						}
//					}
//				
//				
//			}
//			
//		}
//	}
	public node addRecursive2(node current, Point location, IMF_member Grid[][],node nodeList[][]) {
		String s="";

		if(current==null) {
			return nodeList[location.x][location.y];
		}
		if(dp[location.x][location.y]==null) {
			
		
		int x=location.x;
		int y=location.y;
		Point right =transition("right",new Point(x,y));
		Point left  =transition("left",new Point(x,y));
//		System.out.println(left.x+":"+left.y);
		Point up    =transition("up",new Point(x,y));
		Point down  =transition("down",new Point(x,y));
//		if(current==null) {
//			return null;
//		}

		if(right!=null) {
			
//			if(dp[right.x][right.y]==null) {

				dp[right.x][right.y]=nodeList[right.x][right.y];
				current.right=nodeList[right.x][right.y];
				current.right.transition="right";
//				current.right=addRecursive2(current.right, right, Grid, nodeList);
//			}
			
		}
		if(left!=null) {
			
//			if(dp[left.x][left.y]==null) {
				dp[left.x][left.y]=nodeList[left.x][left.y];
				current.left=nodeList[left.x][left.y];
				current.left.transition="left";
//				current.left=addRecursive2(current.left, left, Grid, nodeList);
//			}
			
		}
		if(up!=null) {
//			if(dp[up.x][up.y]==null) {
				dp[up.x][up.y]=nodeList[up.x][up.y];
				current.up=nodeList[up.x][up.y];
				current.up.transition="up";
//				current.up=addRecursive2(current.up, up, Grid, nodeList);
//			}
			
		}
		if(down!=null) {
//			if(dp[down.x][down.y]==null) {
//			System.out.println("dp[down.x][down.y] :"+dp[down.x][down.y]);
//			System.out.println("nodeList[down.x][down.y] :"+nodeList[down.x][down.y]);
			current.down=dp[down.x][down.y]=nodeList[down.x][down.y];
//				nodeList[down.x][down.y];
				current.down.transition="down";
//				current.down=addRecursive2(current.down, down, Grid, nodeList);
				
//			}
			
		}
		}
//		addRecursive2(current.right, right, Grid, nodeList);
//		addRecursive2(current.left, left, Grid, nodeList);
//		addRecursive2(current.up, up, Grid, nodeList);
//		addRecursive2(current.down, down, Grid, nodeList);
		
		return current;
		
	}
	
	 Point transition(String t, Point p) {
		if (t.equals("right") && ((p.y++))<ny) {
			return p.setPoint((p.x), (p.y++));
			
		}
		if (t.equals("left") && ((p.y--)) > 0) {
			return p.setPoint((p.x), (p.y--));
		}
		if (t.equals("up") && ((p.x--)) > 0) {
			return p.setPoint((p.x--), (p.y));
		}

		if (t.equals("down") && ((p.x++)) < mx) {
			return p.setPoint((p.x++), (p.y));
		}
		return null;

	}

	public void add(Point location, IMF_member Grid[][],node nodeList[][]) {
		root = addRecursive2(root, location, Grid,nodeList);

	}

	public void traverseInOrder(node node) {
	    if (node != null) {
	        traverseInOrder(node.left);
	        System.out.print(" " + node+"\n");
	        traverseInOrder(node.right);
	        System.out.print(" " + node+"\n");
	        traverseInOrder(node.up);
	        System.out.print(" " + node+"\n");
	        traverseInOrder(node.down);
	    }
	}

	public void print() {

		traverseInOrder(root);
	}
	public static void main (String[]args) {
		
	}

}
