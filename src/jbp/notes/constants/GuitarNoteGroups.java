package jbp.notes.constants;

import java.util.ArrayList;
import java.util.List;

import jbp.notes.model.Note;

public final class GuitarNoteGroups {
	public static final List<Note> STANDARD_FREE_STRING_NOTES;
	public static final List<Note> FIRST_POSITION_C_DUR_NOTES;
	static {
		STANDARD_FREE_STRING_NOTES = new ArrayList<Note>(6);
		STANDARD_FREE_STRING_NOTES.add(new Note("E2", -5));
		STANDARD_FREE_STRING_NOTES.add(new Note("A2", -2));
		STANDARD_FREE_STRING_NOTES.add(new Note("D3", 1));
		STANDARD_FREE_STRING_NOTES.add(new Note("G3", 4));
		STANDARD_FREE_STRING_NOTES.add(new Note("H3", 6));
		STANDARD_FREE_STRING_NOTES.add(new Note("E4", 9));
		
		FIRST_POSITION_C_DUR_NOTES = new ArrayList<Note>(17);
		FIRST_POSITION_C_DUR_NOTES.add(new Note("E2", -5));
		FIRST_POSITION_C_DUR_NOTES.add(new Note("F2", -4));
		FIRST_POSITION_C_DUR_NOTES.add(new Note("G2", -3));
		FIRST_POSITION_C_DUR_NOTES.add(new Note("A2", -2));
		FIRST_POSITION_C_DUR_NOTES.add(new Note("H2", -1));
		FIRST_POSITION_C_DUR_NOTES.add(new Note("C3", 0));
		FIRST_POSITION_C_DUR_NOTES.add(new Note("D3", 1));
		FIRST_POSITION_C_DUR_NOTES.add(new Note("E3", 2));
		FIRST_POSITION_C_DUR_NOTES.add(new Note("F3", 3));
		FIRST_POSITION_C_DUR_NOTES.add(new Note("G3", 4));
		FIRST_POSITION_C_DUR_NOTES.add(new Note("A3", 5));
		FIRST_POSITION_C_DUR_NOTES.add(new Note("H3", 6));
		FIRST_POSITION_C_DUR_NOTES.add(new Note("C4", 7));
		FIRST_POSITION_C_DUR_NOTES.add(new Note("D4", 8));
		FIRST_POSITION_C_DUR_NOTES.add(new Note("E4", 9));
		FIRST_POSITION_C_DUR_NOTES.add(new Note("F4", 10));
		FIRST_POSITION_C_DUR_NOTES.add(new Note("G4", 11));
	}
}