package UserInterface;

import Library.Bomb;
import java.util.Random;
/**
 * This class provides a method to generate bombs on the board.
 * This class mainly uses recursion algorithm to put bombs on different squares.
 */
public class ProduceBombs extends Bomb
{
    /**
     * Create a ProduceBombs instance to generate bombs at the given board.
     * Using recursion algorithm to avoid generating more than one bomb on the same square.
     * board the GameBoard upon which user clicks on.
     * number the total number of bombs.
     */
    public ProduceBombs(GameBoard board, int number)
    {

        super(board);

        int count =0;

        do {
            reproduceBomb();
            count++;
        }while (count < number);
    }

    /**
     * This method produce bombs on random square. If the assigned square has already contained a bomb, then
     * reassign a square to receive this bomb by invoking itself.
     */
    public void reproduceBomb()
    {
        Random r = new Random();

        int xLocation = r.nextInt(boardWidth);
        int yLocation = r.nextInt(boardHeight);

        SmartSquare square = (SmartSquare) board.getSquareAt(xLocation, yLocation);

        if (!square.getBombExist())
        {
            // mark this square as it has a bomb and been traversed.
            square.setBombExist(true);
            square.setTraverse(true);
        } else {
            reproduceBomb();
        }
    }
}
