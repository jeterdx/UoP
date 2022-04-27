package turing;

/**
 * Tape class is used for a emulated memory device for Turing machine.
 * This class contains several methods to manipulate the data on the tape and
 * also move pointer to which cell is selected.
 * This program is coded based on the concept of dual linked list. So each of
 * cell has two links, prev and next, to two cells, which enable go back and
 * forth easily.
 *
 * @author anonymous
 * @version 1.0
 *
 */
public class Tape {
	private Cell currentCell;

	public Tape() {
		Cell new_Cell = new Cell();
		new_Cell.content = ' ';
		new_Cell.prev = null;
		new_Cell.next = null;
		currentCell = new_Cell;

	}

	// Define each method needed for tape.
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
		if (currentCell.prev == null) {
			Cell new_Cell = new Cell();
			new_Cell.prev = null;
			new_Cell.next = currentCell;
			currentCell.prev = new_Cell;
			currentCell = new_Cell;
		} else {
			currentCell = currentCell.prev;
		}
	}

	public void moveRight() {
		if (currentCell.next == null) {
			Cell new_Cell = new Cell();
			new_Cell.next = null;
			new_Cell.prev = currentCell;
			currentCell.next = new_Cell;
			currentCell = new_Cell;
		} else {
			currentCell = currentCell.next;
		}
	}

	public String getTapeContents() {
		String result = "";
		Cell head = currentCell;
		while (head.prev != null) {
			head = head.prev;
		}
		while (head != null) {
			result += head.content;
			head = head.next;
		}
		System.out.println(result.trim());
		return result.trim();
	}
}
