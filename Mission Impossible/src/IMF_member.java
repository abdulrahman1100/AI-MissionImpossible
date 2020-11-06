
public class IMF_member {

	int health;
	boolean rescued;
	Point point;
	String name;
	int c;

	public IMF_member(int health, boolean rescued, Point point,String name) {
		this.health=health;
		this.rescued=rescued;
		this.point=point;
		this.name=name;

	}

	public IMF_member(int health, Point point, String name,int c) {

		this.health=health;
		this.point=point;
		this.name=name;
		this.c=c;
	}
	public IMF_member( Point point, String name) {

		
		this.point=point;
		this.name=name;
	}

	public static void main(String[] args) {

	}
}
