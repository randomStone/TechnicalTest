package bbc.codingtests.gameoflife.gamestate;

import java.util.*;

/**
 * This class is an implementation  of the gamestate interface
 */
public class GameStateImpl implements GameState {

    int rows;
    int cols;

    HashSet<Cell> cellHash=new HashSet<>();
    //TODO implement this method such that live cells are represented as a '*' and dead cells are represented by a '.' DONE
    //TODO use newline ('\n') to separate rows DONE

    /**
     *
     * @return A string representation of the gamestate where live cells='*' and dead cells='.'
     */
    @Override
    public String toString()
    {

        StringBuilder gameStateString=new StringBuilder("");
        for (int i = 0;i<rows;i++)
        {
            for (int j=0;j<cols;j++)
            {
                gameStateString=gameStateString.append(cellHash.contains(new Cell(i,j))?"*":".");
            }
            //To stop an extra row being put in
            if (i==rows-1)
                break;

            gameStateString=gameStateString.append("\n");
        }

        return gameStateString.toString();
    }

    //TODO implement this constructor to parse an input string and return a new GameStateImpl object representing what you got in the string
    //TODO as above, live cells are '*' and dead cells are '.' Rows are separated by newline ('\n') DONE

    /**
     * This parses an input  string and returns a new GameStateImpl based on the string
     * @param input a string where live cells are '*' and dead cells are '.' Rows are separated by newline ('\n')
     */
    public GameStateImpl(String input) {
        String[] stringRows= input.split("\n");
        rows=stringRows.length;
        //Question how to deal with rows being different size
        int longestRow=0;
        for (String s:stringRows)
        {
            if (s.length()>longestRow){
                longestRow=s.length();
            }
        }
        cols=longestRow;

        for (int i = 0;i<rows;i++)
        {
            for (int j=0;j<cols;j++)
            {
                if (j<stringRows[i].length())
                {
                    char currentChar =stringRows[i].charAt(j);
                    if (currentChar =='*'|| currentChar =='.')
                        //add live cells to hashset
                        cellHash.add(currentChar == '*' ? new Cell(i, j) : null);
                    else
                        throw new IllegalArgumentException();
                }
            }
        }


    }

    //TODO implement this method according to explanation in GameState.java Done
    public boolean isCellAliveAt(int row, int col) {
        return cellHash.contains(new Cell(row,col));
    }


    public int getRows() {
        return rows;
    }


    public int getCols() {
        return cols;
    }


    private class Cell
    {
        //this class represents the alive cells within the game state and has xy coordinates

        private int x;
        private int y;
        // private boolean alive;



        public Cell(int x, int y)
        {
            this.x = x;
            this.y = y;

        }
        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
        @Override
        public boolean equals(Object obj)
        {

            if (obj!=null&&Cell.class.isInstance(obj))
            {
                Cell c= (Cell) obj;
                if (this.x==c.getX()&&this.y==c.getY())
                    return true;
            }
            return false;
        }
        @Override
        public int hashCode(){
            return Objects.hash(x,y);
        }



    }

}
