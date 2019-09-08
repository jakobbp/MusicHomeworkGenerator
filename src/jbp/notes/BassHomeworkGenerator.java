package jbp.notes;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import jbp.notes.annotations.GeneratorMethod;
import jbp.notes.annotations.HomeworkGenerator;
import jbp.notes.constants.BassNoteGroups;
import jbp.notes.constants.SheetDimensions;
import jbp.notes.model.Note;
import jbp.notes.model.NoteAndTabCompositeBars;
import jbp.notes.util.NotesUtil;

@HomeworkGenerator("B")
public class BassHomeworkGenerator {
	@GeneratorMethod(typeId = "1", description = "Bass homework sheets with TAB bars, where all notes correspond to empty bass strings in standard tuning.")
	public static void generateType1GuitarHomework(int nPages) throws IOException {
		generateGuitarHomework(nPages, 64, 0, NotesUtil.generateDefaultHomeworkTypeSuffix());
	}
	
	@GeneratorMethod(typeId = "2", description = "Bass homework sheets with TAB bars, where first quarter of notes correspond to empty bass strings in standard tuning and the other notes are random.")
	public static void generateType2GuitarHomework(int nPages) throws IOException {
		generateGuitarHomework(nPages, 16, 48, NotesUtil.generateDefaultHomeworkTypeSuffix());
	}
	
	@GeneratorMethod(typeId = "3", description = "Bass homework sheets with TAB bars, where all notes are random.")
	public static void generateType3GuitarHomework(int nPages) throws IOException {
		generateGuitarHomework(nPages, 0, 64, NotesUtil.generateDefaultHomeworkTypeSuffix());
	}
	
	private static void generateGuitarHomework(int nPages, int nStringNotes, int nAllNotes, String homeworkTypeSuffix) throws IOException {
		BufferedImage iBuff = new BufferedImage(SheetDimensions.SHEET_A4.width, SheetDimensions.SHEET_A4.height, BufferedImage.TYPE_INT_ARGB);
		Graphics2D gBuff = iBuff.createGraphics();
		gBuff.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		NoteAndTabCompositeBars hwBars = NoteAndTabCompositeBars.BASS_HOMEWORK_BARS;
		
		for(int pageIndex = 1; pageIndex <= nPages; pageIndex++) {
			List<Note> notes = new ArrayList<Note>(nStringNotes+nAllNotes);
			
			Note prevNote = null;
			for(int i = 0; i < nStringNotes; i++) {
				Note note = null;
				while(note == null) {
					int index = (int)(Math.random()*BassNoteGroups.STANDARD_FREE_STRING_NOTES.size());
					Note candidate = BassNoteGroups.STANDARD_FREE_STRING_NOTES.get(index);
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
					int index = (int)(Math.random()*BassNoteGroups.FIRST_POSITION_C_DUR_NOTES.size());
					Note candidate = BassNoteGroups.FIRST_POSITION_C_DUR_NOTES.get(index);
					if(!candidate.equals(prevNote)) {
						note = candidate;
					}
				}
				notes.add(note);
				prevNote = note;
			}
			
			hwBars.draw(gBuff, notes, SheetDimensions.SHEET_A4);
			ImageIO.write(iBuff, NotesUtil.DEFAULT_OUTPUT_FILE_TYPE, new File(String.format(NotesUtil.DEFAULT_OUTPUT_FILE_NAME_TEMPLATE, pageIndex, homeworkTypeSuffix)));
		}
	}
}