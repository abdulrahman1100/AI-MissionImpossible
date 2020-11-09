
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.TreeSet;

public class MissionImpossible extends generic_search  {

	
	static IMF_member Grid[][];
	node [][]nodeList;
	Queue<node> queueList = new LinkedList<>();
	IMF_member Ethan;
	int mx, ny, k, c;
//	TreeSet<node> searchTree = new TreeSet<node>();
	search_Tree searchTree;
	StringBuilder sb=new StringBuilder("");
	
	
	
	public MissionImpossible() throws FileNotFoundException {
	    FileOutputStream fout=new FileOutputStream("tree.txt");  
		PrintStream os=new PrintStream("tree.txt");
		
		
		genGrid();
		node n=new node(Ethan,Ethan.point,0,0,false, c,"center");
		
		searchTree=new search_Tree(n,mx,ny);
		
		
		printGrid(sb,os);
//		System.out.println(Ethan.point.print());
		nodeList=createNodes(Grid);
		searchTree.addRecursive2(n, n.location, Grid, nodeList);
//		searchTree.add(Ethan.point, Grid,nodeList);
//		for(int i=0;i<nodeList.length;i++) {
//			for(int j=0;j<nodeList[i].length;j++) {
//				Point p=new Point(i,j);
//				searchTree.insert(n, p, Grid, nodeList);
//			}
//		}
		System.out.println("root : "+searchTree.root);
		System.out.println("right : "+searchTree.root.right);
		System.out.println("left: "+searchTree.root.left);
		System.out.println("up: "+searchTree.root.up);
		System.out.println("down: "+searchTree.root.down);
		System.out.println(n.location.print());
		System.out.println();
		
		node n2=searchTree.root.left;
		searchTree.addRecursive2(n2,n2.location, Grid, nodeList);
		System.out.println("root : "+searchTree.root);
		System.out.println("right : "+searchTree.root.right);
		System.out.println("left: "+searchTree.root.left);
		System.out.println("up: "+searchTree.root.up);
		System.out.println("down: "+searchTree.root.down);
		System.out.println(n2.location.print());
//		System.out.println("down: "+searchTree.root.right.down);
//		System.out.println
//		(" point : "+nodeList[searchTree.root.right.down.location.x][searchTree.root.right.down.location.y]);
//		System.out.println("down: "+searchTree.root.right.up);
//		System.out.println("down: "+searchTree.root.left.down);
//		System.out.println("down: "+searchTree.root.down.right);
		
//		buildSearchTree(Grid);
//		searchTree.traverseInOrder(searchTree.root);
//		searchTree.print();
//		BFS(queueList.remove());
	}
	
	node[][] createNodes (IMF_member Grid[][]) {
		node[][] n=new node[2*Grid.length][2*Grid[0].length];
		for (int i = 0; i < Grid.length; i++) {
			for (int j = 0; j < Grid[i].length; j++) {
				n[i][j]=new node(Grid[i][j],new Point(i,j),0,0,false,0,"not specified");
			}
		}
		return n;
	}

	void genGrid() {

		// gen m randomly
//x->n y->m
		ny = (int) (Math.random() * (15 - 5 + 1) + 5);
		mx = (int) (Math.random() * (15 - 5 + 1) + 5);

		Grid = new IMF_member[mx][ny];
		nodeList=new node[mx][ny];
		int ex = (int) (Math.random() * ((mx - 1) - 0 + 1) + 0);
		int ey = (int) (Math.random() * ((ny - 1) - 0 + 1) + 0);
		Point pointEthan = new Point(ex, ey);

		int sx = (int) (Math.random() * ((mx - 1) - 0 + 1) + 0);
		int sy = (int) (Math.random() * ((ny - 1) - 0 + 1) + 0);

		while (sx == ex && sy == ey) {
			sx = (int) (Math.random() * ((mx - 1) - 0 + 1) + 0);
			sy = (int) (Math.random() * ((ny - 1) - 0 + 1) + 0);

		}
		Point pointSubmarine = new Point(sx, sy);

		k = (int) (Math.random() * (10 - 5 + 1) + 5);
		c = (int) (Math.random() * (k - 1 + 1) + 1);

		IMF_member IMF_members[];
		IMF_members = new IMF_member[k];

		// gen members points & ethan

		Ethan = new IMF_member(99, pointEthan, "E", c);
		IMF_member Submarine = new IMF_member(pointSubmarine, "S");
		Grid[ex][ey] = Ethan;
		Grid[sx][sy] = Submarine;
		// the loop to gen points for imfMembers and check if duplicated before
		// inserting into the arr

		for (int i = 0; i < k; i++) {

			int x = (int) (Math.random() * ((mx - 1) - 0 + 1) + 0);
			int y = (int) (Math.random() * ((ny - 1) - 0 + 1) + 0);
			Point p = new Point(x, y);
			int health = (int) (Math.random() * (99 - 1 + 1) + 1);
			for (int j = 0; j < k; j++) {
				if (IMF_members[j] != null && IMF_members[j].point != null) {

					if (IMF_members[j].point.check_equality(p) || IMF_members[j].point.check_equality(Ethan.point)
							|| pointSubmarine.check_equality(p)) {

						x = (int) (Math.random() * ((mx - 1) - 0 + 1) + 0);
						y = (int) (Math.random() * ((ny - 1) - 0 + 1) + 0);
						p = new Point(x, y);

						j = 0;
					}
				}

			}

			IMF_members[i] = new IMF_member(health, false, p, "F");
			Grid[x][y] = IMF_members[i];

		}

	}

	void printGrid(StringBuilder sb,PrintStream os) {
		sb=new StringBuilder("");
		for (int i = 0; i < Grid.length; i++) {
			for (int j = 0; j < Grid[i].length; j++) {

				if (Grid[i][j] != null) {
					IMF_member v = (IMF_member) Grid[i][j];
					if (v.health > 9) {
						System.out.print(v.name + "(" + v.health + ")" + "  ");
						sb.append(v.name + "(" + v.health + ")" + "  ");
					} else {
						System.out.print(v.name + "(" + v.health + ")" + "   ");
						sb.append(v.name + "(" + v.health + ")" + "   ");
					}

				} else {
					System.out.print("Empty  ");
					sb.append("Empty  ");
				}

			}
			System.out.println();
			sb.append("\n");

		}
		os.print(sb.toString());

	}

//	void buildSearchTree(IMF_member grid[][]) {
//
//		for (int i=0;i<Grid.length;i++) {
//			for (int j=0;j<Grid[i].length;j++) {
//				Point p=new Point(i,j);
//				if(!Ethan.point.check_equality(p)) {
//					
//					IMF_member m=Grid[i][j];
//				if(m!=null) {
//						searchTree.add(new Point(i,j),m);
//					}else {
//						searchTree.add(new Point(i,j),null);
//					}
//					
//				}
//					
//				
//				
//
//			}
//		}
//
//	}


	String BFS(node initialNode) {
		String s = "";
		if (k == 0) {
			return s;
		}

		if (!(initialNode.location != null)) {

			if (initialNode.x.name != "E" && Ethan.c < c) {
				// no transition as we cariied a mem
//				node n=new node(null,true,c--,initialNode.transition,initialNode.p);
				// take care of the global c here
				Ethan.c = c--;

				Grid[initialNode.x.point.x][initialNode.x.point.y] = null;
//				s+=" "+initialNode.transition+" ,"+BFS(n);
				System.out.println(s);

			} else {
				// submarine
			}

		} else if (initialNode.location != null) {
			// need to move now
			// need to minus the helaths

//			node n=new node(null,true,c--,"right",transition("right",initialNode.p));
//			node n2=new node(null,true,c--,"left",transition("left",initialNode.p));
//			node n3=new node(null,true,c--,"up",transition("up",initialNode.p));
//			node n4=new node(null,true,c--,"down",transition("down",initialNode.p));

//			s+=" "+BFS(n);
//			s+=" "+BFS(n2);
//			s+=" "+BFS(n3);
//			s+=" "+BFS(n4);

		}

		return "";
	}

	void solve(String grid, String strategy, boolean visualize) {

		// parse grid and initialize attributes
//				node InitialState = new node(Ethan, 0, 0, null, false);
		queueList.add(null);
		if (strategy == "BFS") {
			BFS(queueList.remove());
		}
	}

	@Override
	Point transition(String t, Point p) {
		if (t.equals("right") && (p.x) + 1 < mx) {
			p.setPoint((p.x + 1), p.y);
		}
		if (t.equals("left") && (p.x) - 1 > 0) {
			p.setPoint((p.x - 1), p.y);
		}
		if (t.equals("up") && (p.y) - 1 > 0) {
			p.setPoint(p.x, (p.y - 1));
		}

		if (t.equals("down") && (p.y) + 1 < ny) {
			p.setPoint(p.x, (p.y + 1));
		}
		return p;

	}

	@Override
	void action(Point p) {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) throws FileNotFoundException {
		MissionImpossible m = new MissionImpossible();
	}

}
