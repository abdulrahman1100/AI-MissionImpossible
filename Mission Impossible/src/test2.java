
public class test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Point p=new Point(11,5);
		transition("down",p);
		transition("right",p);
		System.out.println(p.print());
		
	}
	
	static Point transition(String t, Point p) {
		if (t.equals("right") && ((p.y) + 1 )< 10) {
			return p.setPoint((p.x), (p.y+1));
		}
		if (t.equals("left") && ((p.y) - 1) > 0) {
			return p.setPoint((p.x), (p.y-1));
		}
		if (t.equals("up") && ((p.x) - 1) > 0) {
			return p.setPoint((p.x-1), (p.y));
		}

		if (t.equals("down") && ((p.x) + 1) < 10) {
			return p.setPoint((p.x+1), (p.y));
		}
		return null;

	}

}
