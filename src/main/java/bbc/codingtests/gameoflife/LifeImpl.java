package bbc.codingtests.gameoflife;

import bbc.codingtests.gameoflife.gamestate.GameState;
import bbc.codingtests.gameoflife.gamestate.GameStateImpl;

public class LifeImpl implements Life
{
 	private enum LeftRight{
		LEFT,
		RIGHT;
	}
	@Override
	public GameState evolve(GameState currentState) {

		StringBuilder newState=new StringBuilder();

			int noOfRows= currentState.getRows();
			int noOfCols=currentState.getCols();
			int startcol=0;//This should only ever be 0 or -1;

			//check extra top and bottom rows in case of a cell being created there
			for(int i =-1; i<noOfRows+1;i++)
			{
				//if extra col here
				if (startcol==0&&newStateAt(currentState,i,-1)){

					newState=addExtraCol(noOfCols,newState,LeftRight.LEFT);
					startcol--;
				}

				for (int j=startcol;j<noOfCols;j++)
				{
						newState=newState.append(newStateAt(currentState,i,j)?"*":".");
				}



				//Check extra col in case of a cell being created there
				if (newStateAt(currentState,i,noOfCols)){

					newState=addExtraCol(noOfCols,newState,LeftRight.RIGHT);
					noOfCols++;

				}

				newState=newState.append("\n");
			}
			//If nothing on bottom extra row

			if (newState.substring(newState.length()-noOfCols-2+startcol).matches("\\n\\.*\\n"))
			{
				newState=newState.delete(newState.length()-noOfCols-2+startcol,newState.length());
			}
			// If nothing new on top extra row
			if (newState.substring(0,noOfCols+1-startcol).matches("\\.*\\n"))
			{
				newState=newState.delete(0,noOfCols+1-startcol);

			}


			return (new GameStateImpl(newState.toString()));

	}

    /**
     * Adds an extra column to the next gamestates input string
     * @param currentNoOfCols
     * @param currentString made so far
     * @param leftRight Decides weather to add col on left or right hand side
     * @return the string with a new col
     */

	private StringBuilder addExtraCol(int currentNoOfCols, StringBuilder currentString, LeftRight leftRight)
	{
		int startPos;

		if (leftRight==LeftRight.LEFT)
		{
			startPos=0;
		}
		else
		{
			startPos=currentNoOfCols;
			currentString.append("*");
		}
		int orignalLength=currentString.length();
		for(int i=startPos;i<orignalLength;i=i+currentNoOfCols+2){
			currentString.insert(i,".");
		}
		return currentString;
	}

    /**
     *
     * @param currentState The current game state
     * @param x position
     * @param y position
     * @return weather the cell is going to be alive or dead in the new state
     */
	private boolean newStateAt(GameState currentState,int x,int y)
	{


		int numberOfAliveCells=0;
		boolean thisCellsState=false;
        //Check all cells around this cell
		for (int i=-1;i<2;i++){

			for (int j=-1;j<2;j++)
			{
				if(i==0&&j==0)
				{
                    // get this cells current state
					thisCellsState=currentState.isCellAliveAt(x,y);
					continue;
				}
				else if (currentState.isCellAliveAt(i+x,j+y))
				{
					numberOfAliveCells++;
				}
			}

		}

		return(numberOfAliveCells==3?true:numberOfAliveCells==2?thisCellsState:false);
	}

}
