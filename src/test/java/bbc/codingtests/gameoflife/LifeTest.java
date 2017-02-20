package bbc.codingtests.gameoflife;

import bbc.codingtests.gameoflife.gamestate.GameState;
import bbc.codingtests.gameoflife.gamestate.GameStateImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class LifeTest {

	//TODO make this test pass
	@Test
	public void testEmptyGrid() {
		String emptyStateInput = "...\n...\n...";

		Life testLife = new LifeImpl();
		GameState emptyState = new GameStateImpl(emptyStateInput);
		assertEquals("An empty grid should stay the same", emptyStateInput, testLife.evolve(emptyState).toString());
	}

	//TODO implement further tests for the other cases in the instructions
	@Test
	public void testUnderpopulation(){
		String underpopulatedInput="...\n.*.\n...";
		String emptyStateoutput = "...\n...\n...";
		Life testLife = new LifeImpl();
		GameState underpopulatedState=new GameStateImpl(underpopulatedInput);
		assertEquals("A Cell by itself should die",emptyStateoutput,testLife.evolve(underpopulatedState).toString());
	}
	@Test
	public void testUnderpopulation2(){
		String underpopulatedInput="...\n.**\n...";
		String emptyStateoutput = "...\n...\n...";
		Life testLife = new LifeImpl();
		GameState underpopulatedState=new GameStateImpl(underpopulatedInput);
		assertEquals("Two Cells by themselves should die",emptyStateoutput,testLife.evolve(underpopulatedState).toString());
	}
	@Test
	public void overcrowdedCell(){
		String overpopulatedInput=".*.\n***\n.*.";
		String expectedOutput = "***\n*.*\n***";
		Life testLife = new LifeImpl();
		GameState overpopulatedState=new GameStateImpl(overpopulatedInput);
		assertEquals("The middle cell should die as it has more than three neighbours",expectedOutput,testLife.evolve(overpopulatedState).toString());
	}
	@Test
	public void survival(){
		String surviveInput="..*\n.*.\n..*";
		String expectedOutput = "...\n.**\n...";
		Life testLife = new LifeImpl();
		GameState surviveState=new GameStateImpl(surviveInput);
		assertEquals("The middle cell should survive as it has two neighbours",expectedOutput,testLife.evolve(surviveState).toString());
	}
	@Test
	public void survival2(){

		String surviveInput="...\n.**\n.**";
		String expectedOutput = "...\n.**\n.**";
		Life testLife = new LifeImpl();
		GameState surviveState=new GameStateImpl(surviveInput);
		assertEquals("The all cells should survive as they have three neighbours",expectedOutput,testLife.evolve(surviveState).toString());
	}
	@Test
	public void creationofLifeExtraColRight(){
		String creationOfLifeStateInput="..*\n.**\n..*";
		String expectedOutput = ".**.\n.***\n.**.";
		Life testLife = new LifeImpl();
		GameState creationOfLifeState=new GameStateImpl(creationOfLifeStateInput);
		assertEquals("An Extra column to the right should be created",expectedOutput,testLife.evolve(creationOfLifeState).toString());
	}
	@Test
	public void creationofLifeExtraColLeft(){
		String creationOfLifeStateInput="*..\n**.\n*..";
		String expectedOutput = ".**.\n***.\n.**.";
		Life testLife = new LifeImpl();
		GameState creationOfLifeState=new GameStateImpl(creationOfLifeStateInput);
		assertEquals("An Extra column to the left should be created",expectedOutput,testLife.evolve(creationOfLifeState).toString());
	}
	@Test
	public void CreationOfLifeExtraTopRow(){

		String creationOfLifeStateInput="***\n...\n...";
		String expectedOutput = ".*.\n.*.\n.*.\n" +
				"...";
		Life testLife = new LifeImpl();
		GameState creationOfLifeState =new GameStateImpl(creationOfLifeStateInput);
		assertEquals("An extra top row should be created",expectedOutput,testLife.evolve(creationOfLifeState).toString());
	}
	@Test
	public void CreationOfLifeExtraBottomRow(){

		String creationOfLifeStateInput="...\n...\n***";
		String expectedOutput = "...\n.*.\n.*.\n" +
				".*.";
		Life testLife = new LifeImpl();
		GameState creationOfLifeState =new GameStateImpl(creationOfLifeStateInput);
		assertEquals("An Extra Bottom Row Should be created",expectedOutput,testLife.evolve(creationOfLifeState).toString());
	}
	@Test
	public void CreationOfLife(){

		String creationOfLifeStateInput="..*\n.*.\n..*";
		String expectedOutput = "...\n.**\n...";
		Life testLife = new LifeImpl();
		GameState creationOfLifeState =new GameStateImpl(creationOfLifeStateInput);
		assertEquals("The cell neighbours",expectedOutput,testLife.evolve(creationOfLifeState).toString());
	}



	@Test
	public void scenario6(){

		String creationOfLifeStateInput="...\n***\n...";
		String expectedOutput = ".*.\n.*.\n.*.";
		Life testLife = new LifeImpl();
		GameState creationOfLifeState=new GameStateImpl(creationOfLifeStateInput);
		assertEquals("This is the scenario 6 stated in the Game Of Life Exercise word Doc",expectedOutput,testLife.evolve(creationOfLifeState).toString());
	}
	@Test
	public void scenario6Turn2(){

		String creationOfLifeStateInput=".*.\n.*.\n.*.";
		String expectedOutput = "...\n***\n...";
		Life testLife = new LifeImpl();
		GameState creationOfLifeState=new GameStateImpl(creationOfLifeStateInput);
		assertEquals("This is the scenario 6 stated in the Game Of Life Exercise word Doc",expectedOutput,testLife.evolve(creationOfLifeState).toString());
	}

}
