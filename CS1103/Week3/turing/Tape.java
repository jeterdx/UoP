package turing;

import java.util.ArrayList;

public class Tape {
	public Tape(){
			//Prepare cells for tape.
			Cell cell = new Cell();
			ArrayList<Cell> tape = new ArrayList<Cell>() {
				{
					add(cell);
				}
			};
			//Start pointing the index 0 cell as a current cell and assign blank space to it.
			Cell currentCell = tape.get(0);
			currentCell.content = ' ';
	}
	//Define each method needed for tape.
	public Cell getCurrentCell() {
		return currentCell;
	}
	public char getContent() {
		return currentCell.content;
	}
	public void setContent(char ch) {
		currentCell.content = ch;
	}
	public void moveLeft() {
		if (currentCell == tape.get(0)){ //Check whether the current cell is the most left of the tape or not.
			tape.add(0, cell);			 //If so, add the new cell to the top of the tape and move left.
			currentCell = currentCell.prev;
		} else {
			currentCell = currentCell.prev;
		}
	}
	public void moveRight() {
		if (currentCell == tape.get(tape.size()-1)){ //Check whether the current cell is the most right of the tape or not.
			tape.add(cell);						   //If so, add the new cell to the last of the tape and move right.
			currentCell = currentCell.next;
		} else {
			currentCell = currentCell.next;
		}
	}
	public String getTapeContents() {
		String result = null;
		for (int i = 0; i < tape.size(); i++) {
			result += tape.get(i).content;
		}	
		result.trim();
		return result;
	}
}
