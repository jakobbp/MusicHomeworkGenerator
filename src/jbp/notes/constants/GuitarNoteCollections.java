package jbp.notes.constants;

import java.util.ArrayList;
import java.util.List;

import jbp.notes.model.Note;

public final class GuitarNoteCollections {
	public static final List<Note> STANDARD_FREE_STRING_NOTES;
	public static final List<Note> FIRST_POSITION_C_DUR_NOTES;
	public static final List<Note> THIRD_POSITION_C_DUR_NOTES;
	public static final List<Note> FIFTH_POSITION_C_DUR_NOTES;
	public static final List<Note> SEVENTH_POSITION_C_DUR_NOTES;
	public static final List<Note> NINTH_POSITION_C_DUR_NOTES;
	
	private static final Note E2 = new Note("E2", -5);
	private static final Note F2 = new Note("F2", -4);
	private static final Note G2 = new Note("G2", -3);
	private static final Note A2 = new Note("A2", -2);
	private static final Note H2 = new Note("H2", -1);
	private static final Note C3 = new Note("C3", 0);
	private static final Note D3 = new Note("D3", 1);
	private static final Note E3 = new Note("E3", 2);
	private static final Note F3 = new Note("F3", 3);
	private static final Note G3 = new Note("G3", 4);
	private static final Note A3 = new Note("A3", 5);
	private static final Note H3 = new Note("H3", 6);
	private static final Note C4 = new Note("C4", 7);
	private static final Note D4 = new Note("D4", 8);
	private static final Note E4 = new Note("E4", 9);
	private static final Note F4 = new Note("F4", 10);
	private static final Note G4 = new Note("G4", 11);
	private static final Note A4 = new Note("A4", 12);
	private static final Note H4 = new Note("H4", 13);
	private static final Note C5 = new Note("C5", 14);
	private static final Note D5 = new Note("D5", 15);
	private static final Note E5 = new Note("E5", 16);
	
	static {
		STANDARD_FREE_STRING_NOTES = new ArrayList<Note>(6);
		STANDARD_FREE_STRING_NOTES.add(E2);
		STANDARD_FREE_STRING_NOTES.add(A2);
		STANDARD_FREE_STRING_NOTES.add(D3);
		STANDARD_FREE_STRING_NOTES.add(G3);
		STANDARD_FREE_STRING_NOTES.add(H3);
		STANDARD_FREE_STRING_NOTES.add(E4);
		
		FIRST_POSITION_C_DUR_NOTES = new ArrayList<Note>(17);
		FIRST_POSITION_C_DUR_NOTES.add(E2);
		FIRST_POSITION_C_DUR_NOTES.add(F2);
		FIRST_POSITION_C_DUR_NOTES.add(G2);
		FIRST_POSITION_C_DUR_NOTES.add(A2);
		FIRST_POSITION_C_DUR_NOTES.add(H2);
		FIRST_POSITION_C_DUR_NOTES.add(C3);
		FIRST_POSITION_C_DUR_NOTES.add(D3);
		FIRST_POSITION_C_DUR_NOTES.add(E3);
		FIRST_POSITION_C_DUR_NOTES.add(F3);
		FIRST_POSITION_C_DUR_NOTES.add(G3);
		FIRST_POSITION_C_DUR_NOTES.add(A3);
		FIRST_POSITION_C_DUR_NOTES.add(H3);
		FIRST_POSITION_C_DUR_NOTES.add(C4);
		FIRST_POSITION_C_DUR_NOTES.add(D4);
		FIRST_POSITION_C_DUR_NOTES.add(E4);
		FIRST_POSITION_C_DUR_NOTES.add(F4);
		FIRST_POSITION_C_DUR_NOTES.add(G4);
		
		THIRD_POSITION_C_DUR_NOTES = new ArrayList<Note>(16);
		THIRD_POSITION_C_DUR_NOTES.add(G2);
		THIRD_POSITION_C_DUR_NOTES.add(A2);
		THIRD_POSITION_C_DUR_NOTES.add(H2);
		THIRD_POSITION_C_DUR_NOTES.add(C3);
		THIRD_POSITION_C_DUR_NOTES.add(D3);
		THIRD_POSITION_C_DUR_NOTES.add(E3);
		THIRD_POSITION_C_DUR_NOTES.add(F3);
		THIRD_POSITION_C_DUR_NOTES.add(G3);
		THIRD_POSITION_C_DUR_NOTES.add(A3);
		THIRD_POSITION_C_DUR_NOTES.add(H3);
		THIRD_POSITION_C_DUR_NOTES.add(C4);
		THIRD_POSITION_C_DUR_NOTES.add(D4);
		THIRD_POSITION_C_DUR_NOTES.add(E4);
		THIRD_POSITION_C_DUR_NOTES.add(F4);
		THIRD_POSITION_C_DUR_NOTES.add(G4);
		THIRD_POSITION_C_DUR_NOTES.add(A4);
		
		FIFTH_POSITION_C_DUR_NOTES = new ArrayList<Note>(17);
		FIFTH_POSITION_C_DUR_NOTES.add(A2);
		FIFTH_POSITION_C_DUR_NOTES.add(H2);
		FIFTH_POSITION_C_DUR_NOTES.add(C3);
		FIFTH_POSITION_C_DUR_NOTES.add(D3);
		FIFTH_POSITION_C_DUR_NOTES.add(E3);
		FIFTH_POSITION_C_DUR_NOTES.add(F3);
		FIFTH_POSITION_C_DUR_NOTES.add(G3);
		FIFTH_POSITION_C_DUR_NOTES.add(A3);
		FIFTH_POSITION_C_DUR_NOTES.add(H3);
		FIFTH_POSITION_C_DUR_NOTES.add(C4);
		FIFTH_POSITION_C_DUR_NOTES.add(D4);
		FIFTH_POSITION_C_DUR_NOTES.add(E4);
		FIFTH_POSITION_C_DUR_NOTES.add(F4);
		FIFTH_POSITION_C_DUR_NOTES.add(G4);
		FIFTH_POSITION_C_DUR_NOTES.add(A4);
		FIFTH_POSITION_C_DUR_NOTES.add(H4);
		FIFTH_POSITION_C_DUR_NOTES.add(C5);
		
		SEVENTH_POSITION_C_DUR_NOTES = new ArrayList<Note>(17);
		SEVENTH_POSITION_C_DUR_NOTES.add(H2);
		SEVENTH_POSITION_C_DUR_NOTES.add(C3);
		SEVENTH_POSITION_C_DUR_NOTES.add(D3);
		SEVENTH_POSITION_C_DUR_NOTES.add(E3);
		SEVENTH_POSITION_C_DUR_NOTES.add(F3);
		SEVENTH_POSITION_C_DUR_NOTES.add(G3);
		SEVENTH_POSITION_C_DUR_NOTES.add(A3);
		SEVENTH_POSITION_C_DUR_NOTES.add(H3);
		SEVENTH_POSITION_C_DUR_NOTES.add(C4);
		SEVENTH_POSITION_C_DUR_NOTES.add(D4);
		SEVENTH_POSITION_C_DUR_NOTES.add(E4);
		SEVENTH_POSITION_C_DUR_NOTES.add(F4);
		SEVENTH_POSITION_C_DUR_NOTES.add(G4);
		SEVENTH_POSITION_C_DUR_NOTES.add(A4);
		SEVENTH_POSITION_C_DUR_NOTES.add(H4);
		SEVENTH_POSITION_C_DUR_NOTES.add(C5);
		SEVENTH_POSITION_C_DUR_NOTES.add(D5);
		
		NINTH_POSITION_C_DUR_NOTES = new ArrayList<Note>(14);
		NINTH_POSITION_C_DUR_NOTES.add(D3);
		NINTH_POSITION_C_DUR_NOTES.add(E3);
		NINTH_POSITION_C_DUR_NOTES.add(G3);
		NINTH_POSITION_C_DUR_NOTES.add(A3);
		NINTH_POSITION_C_DUR_NOTES.add(H3);
		NINTH_POSITION_C_DUR_NOTES.add(C4);
		NINTH_POSITION_C_DUR_NOTES.add(D4);
		NINTH_POSITION_C_DUR_NOTES.add(E4);
		NINTH_POSITION_C_DUR_NOTES.add(F4);
		NINTH_POSITION_C_DUR_NOTES.add(G4);
		NINTH_POSITION_C_DUR_NOTES.add(A4);
		NINTH_POSITION_C_DUR_NOTES.add(H4);
		NINTH_POSITION_C_DUR_NOTES.add(D5);
		NINTH_POSITION_C_DUR_NOTES.add(E5);
	}
}