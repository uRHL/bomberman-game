package sprites;

import structures.*;
import blocks.*;

/**
 * Represents a Player. As this class extends Sprite, every Player will have an
 * unique ID number, x and y positions, a collection of images, belongs to a
 * fixed level, and some Bombs.
 * 
 * @author Ram�n Hern�ndez Le�n. Bachelor Degree in Computer Science. UC3M
 * @author Miguel Espinosa Mi�ano. Bachelor Degree in Computer Science. UC3M
 * @since December, 6, 2017
 * @version 1.1
 */
public class Player extends Sprite {
    /**
     * Bomb type array storing the bombs that the player has, starting with one
     * bomb. It can be interpreted as a bag, the player can only use the bombs that
     * carries in the bag. The number of bombs can be incremented with bonuses.
     */
    public Bomb[] bombs;
    /**
     * Variables used for changing the images of the player
     */
    private int up = 0, down = 0, left = 0, right = 0;

    boolean alive = true;

    int health = 100;

    /**
     * Constructor. Initializes the ID number ('super' constructor), the X-position
     * and Y-position (1 by default), the image and the array of bombs, initily with
     * one bomb.
     * 
     * @param l
     *            Level were the Player exists.
     * @param id
     *            Unique number identifying the player.
     */
    public Player(Level l, int id) {
        super(id);
        xPos = 1;
        yPos = 1;
        image = "bomberman111.png";
        ownLevel = l;
        bombs = new Bomb[] { new Bomb() };

    }

    /**
     * Override method to move the player depending on the last key pressed.
     */
    @Override
    public void move(String lastAction) {
        int copyX = xPos, copyY = yPos;
        if (alive) {
            if (lastAction.equals("right") && ownLevel.board[++copyX][copyY].isWalkable()) {
                if (right % 5 == 0) {
                    image = "bomberman131.png";
                } else if ((right + 1) % 5 == 0) {
                    image = "bomberman132.png";
                } else if ((right + 2) % 5 == 0) {
                    image = "bomberman133.png";
                } else if ((right + 3) % 5 == 0) {
                    image = "bomberman134.png";
                } else if ((right + 4) % 5 == 0) {
                    image = "bomberman135.png";
                }
                right++;
                xPos++;
            } else if (lastAction.equals("left") && ownLevel.board[--copyX][copyY].isWalkable()) {
                if (left % 5 == 0) {
                    image = "bomberman121.png";
                } else if ((left + 1) % 5 == 0) {
                    image = "bomberman122.png";
                } else if ((left + 2) % 5 == 0) {
                    image = "bomberman123.png";
                } else if ((left + 3) % 5 == 0) {
                    image = "bomberman124.png";
                } else if ((left + 4) % 5 == 0) {
                    image = "bomberman125.png";
                }
                left++;
                xPos--;
            } else if (lastAction.equals("up") && ownLevel.board[copyX][--copyY].isWalkable()) {
                if (up % 5 == 0) {
                    image = "bomberman101.png";
                } else if ((up + 1) % 5 == 0) {
                    image = "bomberman102.png";
                } else if ((up + 2) % 5 == 0) {
                    image = "bomberman103.png";
                } else if ((up + 3) % 5 == 0) {
                    image = "bomberman104.png";
                } else if ((up + 4) % 5 == 0) {
                    image = "bomberman105.png";
                }
                up++;
                yPos--;
            } else if (lastAction.equals("down") && ownLevel.board[copyX][++copyY].isWalkable()) {
                if (down % 5 == 0) {
                    image = "bomberman111.png";
                } else if ((down + 1) % 5 == 0) {
                    image = "bomberman112.png";
                } else if ((down + 2) % 5 == 0) {
                    image = "bomberman113.png";
                } else if ((down + 3) % 5 == 0) {
                    image = "bomberman114.png";
                } else if ((down + 4) % 5 == 0) {
                    image = "bomberman115.png";
                }
                down++;
                yPos++;
            }
        }
    }

    /**
     * Place a bomb in the position were the player is in the moment of the call. It
     * will check if the player has available bombs in the 'bag' (not planted
     * bombs), and, if it has one, it will plant it (initializing the bomb with the
     * full constructor now).
     * 
     * <p>
     * The attributes of the block were the bomb is placed will be changed: it will
     * be not available, nor walkable and the mined will be set to true.
     * </p>
     * 
     * @param timer
     *            Time when the bomb was placed.
     */
    public void putBomb(int timer) {
        if (ownLevel.board[xPos][yPos].isAvailable()) {
            for (int i = 0; i < bombs.length; i++) { // Searching if there is any available bomb
                if (!bombs[i].isPlaced()) { // The bomb has not been placed
                    bombs[i] = new Bomb(ownLevel, timer, xPos, yPos);
                    ownLevel.board[xPos][yPos].setAvailable(false);
                    ownLevel.board[xPos][yPos].setWalkable(false);
                    ownLevel.board[xPos][yPos].setMined(true);
                }
            }
        }
    }

    /**
     * Override method. It has NO implementation as the value of the last key
     * pressed is needed.
     */
    @Override
    public void move() {

    }

    public void killed() {
        alive = false;
        image = "bomberman141.png";
    }

}
