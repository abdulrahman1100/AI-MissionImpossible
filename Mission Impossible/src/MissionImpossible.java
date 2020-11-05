
import java.util.Arrays;
import java.util.Random;

public class MissionImpossible extends Procedure {

	static Object Grid[][];

	public MissionImpossible() {
		genGrid();
		printGrid();
	}

	static void genGrid() {

		// gen m randomly
//x->n y->m
		int m = (int) (Math.random() * (15 - 5 + 1) + 5);
		int n = (int) (Math.random() * (15 - 5 + 1) + 5);

		Grid = new Object[m][n];

		int ex = (int) (Math.random() * ((n - 1) - 0 + 1) + 0);
		int ey = (int) (Math.random() * ((m - 1) - 0 + 1) + 0);
		Point pointEthan = new Point(ex, ey);

		int sx = (int) (Math.random() * ((n - 1) - 0 + 1) + 0);
		int sy = (int) (Math.random() * ((m - 1) - 0 + 1) + 0);

		while (sx == ex && sy == ey) {
			sx = (int) (Math.random() * ((n - 1) - 0 + 1) + 0);
			sy = (int) (Math.random() * ((m - 1) - 0 + 1) + 0);

		}
		Point pointSubmarine = new Point(sx, sy);

		int k = (int) (Math.random() * (10 - 5 + 1) + 5);
		int c = (int) (Math.random() * (k - 1 + 1) + 1);

		IMF_member IMF_members[];
		IMF_members = new IMF_member[k];

		// gen members points & ethan

		IMF_member Ethan = new IMF_member(99, pointEthan, "E");
		IMF_member Submarine = new IMF_member(pointSubmarine, "S");
		Grid[ey][ex] = Ethan;
		Grid[sy][sx] = Submarine;
		// the loop to gen points for imfMembers and check if duplicated before
		// inserting into the arr

		for (int i = 0; i < k; i++) {

			int x = (int) (Math.random() * ((n - 1) - 0 + 1) + 0);
			int y = (int) (Math.random() * ((m - 1) - 0 + 1) + 0);
			Point p = new Point(x, y);
			int health = (int) (Math.random() * (99 - 1 + 1) + 1);
			for (int j = 0; j < k; j++) {
				if (IMF_members[j] != null && IMF_members[j].point != null) {

					if (IMF_members[j].point.check_equality(p) || IMF_members[j].point.check_equality(Ethan.point)
							|| pointSubmarine.check_equality(p)) {

						x = (int) (Math.random() * ((n - 1) - 0 + 1) + 0);
						y = (int) (Math.random() * ((m - 1) - 0 + 1) + 0);
						p = new Point(x, y);

						j = 0;
					}
				}

			}

			IMF_members[i] = new IMF_member(health, false, p, "F");
			Grid[y][x] = IMF_members[i];

		}

	}

	void printGrid() {

		for (int i = 0; i < Grid.length; i++) {
			for (int j = 0; j < Grid[i].length; j++) {

				if (Grid[i][j] != null) {
					IMF_member v = (IMF_member) Grid[i][j];
					if (v.health > 9) {
						System.out.print(v.name + "(" + v.health + ")" + "  ");
					} else {
						System.out.print(v.name + "(" + v.health + ")" + "   ");
					}

				} else {
					System.out.print("Empty  ");
				}

			}
			System.out.println();

		}

	}

	void solve(String grid, String strategy, boolean visualize) {

	}

	public static void main(String[] args) {
		MissionImpossible m = new MissionImpossible();
	}
}
