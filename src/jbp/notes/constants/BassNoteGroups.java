package jbp.notes.constants;

import java.util.ArrayList;
import java.util.List;

import jbp.notes.model.Note;

public final class BassNoteGroups {
	public static final List<Note> STANDARD_FREE_STRING_NOTES;
	public static final List<Note> FIRST_POSITION_C_DUR_NOTES;
	static {
		STANDARD_FREE_STRING_NOTES = new ArrayList<Note>(4);
		STANDARD_FREE_STRING_NOTES.add(new Note("E1", -5));
		STANDARD_FREE_STRING_NOTES.add(new Note("A1", -2));
		STANDARD_FREE_STRING_NOTES.add(new Note("D2", 1));
		STANDARD_FREE_STRING_NOTES.add(new Note("G2", 4));
		
		FIRST_POSITION_C_DUR_NOTES = new ArrayList<Note>(12);
		FIRST_POSITION_C_DUR_NOTES.add(new Note("E1", -5));
		FIRST_POSITION_C_DUR_NOTES.add(new Note("F1", -4));
		FIRST_POSITION_C_DUR_NOTES.add(new Note("G1", -3));
		FIRST_POSITION_C_DUR_NOTES.add(new Note("A1", -2));
		FIRST_POSITION_C_DUR_NOTES.add(new Note("H1", -1));
		FIRST_POSITION_C_DUR_NOTES.add(new Note("C2", 0));
		FIRST_POSITION_C_DUR_NOTES.add(new Note("D2", 1));
		FIRST_POSITION_C_DUR_NOTES.add(new Note("E2", 2));
		FIRST_POSITION_C_DUR_NOTES.add(new Note("F2", 3));
		FIRST_POSITION_C_DUR_NOTES.add(new Note("G2", 4));
		FIRST_POSITION_C_DUR_NOTES.add(new Note("A2", 5));
		FIRST_POSITION_C_DUR_NOTES.add(new Note("H2", 6));
	}
}