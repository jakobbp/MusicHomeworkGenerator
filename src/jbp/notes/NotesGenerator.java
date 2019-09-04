package jbp.notes;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import jbp.notes.constants.GuitarNoteGroups;
import jbp.notes.constants.MusicalSymbols;
import jbp.notes.constants.SheetDimensions;
import jbp.notes.model.HomeworkBars;
import jbp.notes.model.Note;

@SuppressWarnings("unused")
public class NotesGenerator implements MusicalSymbols {
	
	public static void main(String[] args) throws Exception {
//		generateType1Homework(1);
		generateType2Homework(3);
//		generateType3Homework(1);
	}

	private static void generateType1Homework(int nPages) throws IOException {
		int nStringNotes = 64;
		int nAllNotes = 0;
		String typeSuffix = "T1";
		generateHomework(nPages, nStringNotes, nAllNotes, typeSuffix);
	}
	
	private static void generateType2Homework(int nPages) throws IOException {
		int nStringNotes = 16;
		int nAllNotes = 48;
		String typeSuffix = "T2";
		generateHomework(nPages, nStringNotes, nAllNotes, typeSuffix);
	}
	
	private static void generateType3Homework(int nPages) throws IOException {
		int nStringNotes = 0;
		int nAllNotes = 64;
		String typeSuffix = "T3";
		generateHomework(nPages, nStringNotes, nAllNotes, typeSuffix);
	}
	
	private static void generateHomework(int nPages, int nStringNotes, int nAllNotes, String typeSuffix) throws IOException {
		BufferedImage iBuff = new BufferedImage(SheetDimensions.SHEET_A4.width, SheetDimensions.SHEET_A4.height, BufferedImage.TYPE_INT_ARGB);
		Graphics2D gBuff = iBuff.createGraphics();
		gBuff.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		HomeworkBars hwBars = new HomeworkBars();
		String fileNameTemplate = "Naloga-%2$s-%1$02d.png";
		
		for(int pageIndex = 1; pageIndex <= nPages; pageIndex++) {
			List<Note> notes = new ArrayList<Note>(nStringNotes+nAllNotes);
			
			Note prevNote = null;
			for(int i = 0; i < nStringNotes; i++) {
				Note note = null;
				while(note == null) {
					int index = (int)(Math.random()*GuitarNoteGroups.STANDARD_FREE_STRING_NOTES.size());
					Note candidate = GuitarNoteGroups.STANDARD_FREE_STRING_NOTES.get(index);
					if(!candidate.equals(prevNote)) {
						note = candidate;
					}
				}
				notes.add(note);
				prevNote = note;
			}
			
			prevNote = null;
			for(int i = 0; i < nAllNotes; i++) {
				Note note = null;
				while(note == null) {
					int index = (int)(Math.random()*GuitarNoteGroups.FIRST_POSITION_C_DUR_NOTES.size());
					Note candidate = GuitarNoteGroups.FIRST_POSITION_C_DUR_NOTES.get(index);
					if(!candidate.equals(prevNote)) {
						note = candidate;
					}
				}
				notes.add(note);
				prevNote = note;
			}
			
			hwBars.draw(gBuff, notes, SheetDimensions.SHEET_A4);
			ImageIO.write(iBuff, "PNG", new File(String.format(fileNameTemplate, pageIndex, typeSuffix)));
		}
	}
}
