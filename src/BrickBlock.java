
public class BrickBlock extends Block {
	boolean destroyed = false;
	Bonus bonus;

	public BrickBlock() {
		image = "bricks.gif";
		walkable = false;
		available = false;
		if ((int)(Math.random()*2)==0) {
			bonus= new Bonus();
		}
	}
}
