package jbp.notes.constants;

import java.util.ArrayList;
import java.util.List;

import jbp.notes.model.Note;

public final class BassNoteCollections {
	public static final List<Note> STANDARD_FREE_STRING_NOTES;
	public static final List<Note> FIRST_POSITION_C_DUR_NOTES;
	public static final List<Note> THIRD_POSITION_C_DUR_NOTES;
	public static final List<Note> FIFTH_POSITION_C_DUR_NOTES;
	public static final List<Note> SEVENTH_POSITION_C_DUR_NOTES;
	public static final List<Note> NINTH_POSITION_C_DUR_NOTES;
	
	private static final Note E1 = new Note("E1", -5);
	private static final Note F1 = new Note("F1", -4);
	private static final Note G1 = new Note("G1", -3);
	private static final Note A1 = new Note("A1", -2);
	private static final Note H1 = new Note("H1", -1);
	private static final Note C2 = new Note("C2", 0);
	private static final Note D2 = new Note("D2", 1);
	private static final Note E2 = new Note("E2", 2);
	private static final Note F2 = new Note("F2", 3);
	private static final Note G2 = new Note("G2", 4);
	private static final Note A2 = new Note("A2", 5);
	private static final Note H2 = new Note("H2", 6);
	private static final Note C3 = new Note("C3", 7);
	private static final Note D3 = new Note("D3", 8);
	private static final Note E3 = new Note("E3", 9);
	private static final Note F3 = new Note("F3", 10);
	private static final Note G3 = new Note("G3", 11);
	
	static {
		STANDARD_FREE_STRING_NOTES = new ArrayList<Note>(4);
		STANDARD_FREE_STRING_NOTES.add(E1);
		STANDARD_FREE_STRING_NOTES.add(A1);
		STANDARD_FREE_STRING_NOTES.add(D2);
		STANDARD_FREE_STRING_NOTES.add(G2);
		
		FIRST_POSITION_C_DUR_NOTES = new ArrayList<Note>(12);
		FIRST_POSITION_C_DUR_NOTES.add(E1);
		FIRST_POSITION_C_DUR_NOTES.add(F1);
		FIRST_POSITION_C_DUR_NOTES.add(G1);
		FIRST_POSITION_C_DUR_NOTES.add(A1);
		FIRST_POSITION_C_DUR_NOTES.add(H1);
		FIRST_POSITION_C_DUR_NOTES.add(C2);
		FIRST_POSITION_C_DUR_NOTES.add(D2);
		FIRST_POSITION_C_DUR_NOTES.add(E2);
		FIRST_POSITION_C_DUR_NOTES.add(F2);
		FIRST_POSITION_C_DUR_NOTES.add(G2);
		FIRST_POSITION_C_DUR_NOTES.add(A2);
		FIRST_POSITION_C_DUR_NOTES.add(H2);
		
		THIRD_POSITION_C_DUR_NOTES = new ArrayList<Note>(11);
		THIRD_POSITION_C_DUR_NOTES.add(G1);
		THIRD_POSITION_C_DUR_NOTES.add(A1);
		THIRD_POSITION_C_DUR_NOTES.add(H1);
		THIRD_POSITION_C_DUR_NOTES.add(C2);
		THIRD_POSITION_C_DUR_NOTES.add(D2);
		THIRD_POSITION_C_DUR_NOTES.add(E2);
		THIRD_POSITION_C_DUR_NOTES.add(F2);
		THIRD_POSITION_C_DUR_NOTES.add(G2);
		THIRD_POSITION_C_DUR_NOTES.add(A2);
		THIRD_POSITION_C_DUR_NOTES.add(H2);
		THIRD_POSITION_C_DUR_NOTES.add(C3);
		
		FIFTH_POSITION_C_DUR_NOTES = new ArrayList<Note>(11);
		FIFTH_POSITION_C_DUR_NOTES.add(A1);
		FIFTH_POSITION_C_DUR_NOTES.add(H1);
		FIFTH_POSITION_C_DUR_NOTES.add(C2);
		FIFTH_POSITION_C_DUR_NOTES.add(D2);
		FIFTH_POSITION_C_DUR_NOTES.add(E2);
		FIFTH_POSITION_C_DUR_NOTES.add(F2);
		FIFTH_POSITION_C_DUR_NOTES.add(G2);
		FIFTH_POSITION_C_DUR_NOTES.add(A2);
		FIFTH_POSITION_C_DUR_NOTES.add(H2);
		FIFTH_POSITION_C_DUR_NOTES.add(C3);
		FIFTH_POSITION_C_DUR_NOTES.add(D3);
		
		SEVENTH_POSITION_C_DUR_NOTES = new ArrayList<Note>(12);
		SEVENTH_POSITION_C_DUR_NOTES.add(H1);
		SEVENTH_POSITION_C_DUR_NOTES.add(C2);
		SEVENTH_POSITION_C_DUR_NOTES.add(D2);
		SEVENTH_POSITION_C_DUR_NOTES.add(E2);
		SEVENTH_POSITION_C_DUR_NOTES.add(F2);
		SEVENTH_POSITION_C_DUR_NOTES.add(G2);
		SEVENTH_POSITION_C_DUR_NOTES.add(A2);
		SEVENTH_POSITION_C_DUR_NOTES.add(H2);
		SEVENTH_POSITION_C_DUR_NOTES.add(C3);
		SEVENTH_POSITION_C_DUR_NOTES.add(D3);
		SEVENTH_POSITION_C_DUR_NOTES.add(E3);
		SEVENTH_POSITION_C_DUR_NOTES.add(F3);
		
		NINTH_POSITION_C_DUR_NOTES = new ArrayList<Note>(10);
		NINTH_POSITION_C_DUR_NOTES.add(D2);
		NINTH_POSITION_C_DUR_NOTES.add(E2);
		NINTH_POSITION_C_DUR_NOTES.add(G2);
		NINTH_POSITION_C_DUR_NOTES.add(A2);
		NINTH_POSITION_C_DUR_NOTES.add(H2);
		NINTH_POSITION_C_DUR_NOTES.add(C3);
		NINTH_POSITION_C_DUR_NOTES.add(D3);
		NINTH_POSITION_C_DUR_NOTES.add(E3);
		NINTH_POSITION_C_DUR_NOTES.add(F3);
		NINTH_POSITION_C_DUR_NOTES.add(G3);
	}
}