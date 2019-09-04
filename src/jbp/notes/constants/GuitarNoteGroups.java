package jbp.notes.constants;

import java.util.ArrayList;
import java.util.List;

import jbp.notes.model.Note;

public final class GuitarNoteGroups {
	public static final List<Note> STANDARD_FREE_STRING_NOTES;
	public static final List<Note> FIRST_POSITION_C_DUR_NOTES;
	static {
		STANDARD_FREE_STRING_NOTES = new ArrayList<Note>(6);
		STANDARD_FREE_STRING_NOTES.add(new Note("E", -5));
		STANDARD_FREE_STRING_NOTES.add(new Note("A", -2));
		STANDARD_FREE_STRING_NOTES.add(new Note("d", 1));
		STANDARD_FREE_STRING_NOTES.add(new Note("g", 4));
		STANDARD_FREE_STRING_NOTES.add(new Note("h", 6));
		STANDARD_FREE_STRING_NOTES.add(new Note("e2", 9));
		
		FIRST_POSITION_C_DUR_NOTES = new ArrayList<Note>(17);
		FIRST_POSITION_C_DUR_NOTES.add(new Note("E", -5));
		FIRST_POSITION_C_DUR_NOTES.add(new Note("F", -4));
		FIRST_POSITION_C_DUR_NOTES.add(new Note("G", -3));
		FIRST_POSITION_C_DUR_NOTES.add(new Note("A", -2));
		FIRST_POSITION_C_DUR_NOTES.add(new Note("H", -1));
		FIRST_POSITION_C_DUR_NOTES.add(new Note("c", 0));
		FIRST_POSITION_C_DUR_NOTES.add(new Note("d", 1));
		FIRST_POSITION_C_DUR_NOTES.add(new Note("e", 2));
		FIRST_POSITION_C_DUR_NOTES.add(new Note("f", 3));
		FIRST_POSITION_C_DUR_NOTES.add(new Note("g", 4));
		FIRST_POSITION_C_DUR_NOTES.add(new Note("a", 5));
		FIRST_POSITION_C_DUR_NOTES.add(new Note("h", 6));
		FIRST_POSITION_C_DUR_NOTES.add(new Note("c2", 7));
		FIRST_POSITION_C_DUR_NOTES.add(new Note("d2", 8));
		FIRST_POSITION_C_DUR_NOTES.add(new Note("e2", 9));
		FIRST_POSITION_C_DUR_NOTES.add(new Note("f2", 10));
		FIRST_POSITION_C_DUR_NOTES.add(new Note("g2", 11));
	}
}