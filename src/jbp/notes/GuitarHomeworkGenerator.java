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
import jbp.notes.constants.GuitarNoteGroups;
import jbp.notes.constants.SheetDimensions;
import jbp.notes.model.GuitarHomeworkBars;
import jbp.notes.model.Note;
import jbp.notes.util.NotesUtil;

@HomeworkGenerator("G")
public class GuitarHomeworkGenerator {
	@GeneratorMethod(typeId = "1", description = "Guitar homework sheets with TAB bars, where all notes correspond to empty guitar strings in standard tuning.")
	public static void generateType1GuitarHomework(int nPages) throws IOException {
		generateGuitarHomework(nPages, 64, 0, NotesUtil.generateDefaultHomeworkTypeSuffix());
	}
	
	@GeneratorMethod(typeId = "2", description = "Guitar homework sheets with TAB bars, where first quarter of notes correspond to empty guitar strings in standard tuning and the other notes are random.")
	public static void generateType2GuitarHomework(int nPages) throws IOException {
		generateGuitarHomework(nPages, 16, 48, NotesUtil.generateDefaultHomeworkTypeSuffix());
	}
	
	@GeneratorMethod(typeId = "3", description = "Guitar homework sheets with TAB bars, where all notes are random.")
	public static void generateType3GuitarHomework(int nPages) throws IOException {
		generateGuitarHomework(nPages, 0, 64, NotesUtil.generateDefaultHomeworkTypeSuffix());
	}
	
	private static void generateGuitarHomework(int nPages, int nStringNotes, int nAllNotes, String typeSuffix) throws IOException {
		BufferedImage iBuff = new BufferedImage(SheetDimensions.SHEET_A4.width, SheetDimensions.SHEET_A4.height, BufferedImage.TYPE_INT_ARGB);
		Graphics2D gBuff = iBuff.createGraphics();
		gBuff.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		GuitarHomeworkBars hwBars = new GuitarHomeworkBars();
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