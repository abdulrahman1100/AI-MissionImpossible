
public class Point {

	int x;
	int y;
	
	public Point(int x,int y) {
		this.x=x;
		this.y=y;
		// TODO Auto-generated constructor stub
	}

	public boolean check_equality(Point p){
		
		if((this.x==p.x)&&(this.y==p.y)) {
			return true;
		}
		return false;
		
	}
	
	 public String print() {
		String s="("+this.x+" , "+this.y+") ";
		return s;
	}
	public static void main(String[]args) {
		
	}

}
