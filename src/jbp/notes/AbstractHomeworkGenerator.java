package jbp.notes;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import jbp.notes.constants.SheetDimensions;
import jbp.notes.model.AbstractBars;
import jbp.notes.model.Note;
import jbp.notes.util.NotesUtil;

public abstract class AbstractHomeworkGenerator {
	protected static final class NoteGroup {
		private List<Note> notesDomain;
		private int nNotes;
		
		public NoteGroup(List<Note> notesDomain, int nNotes) {
			this.notesDomain = notesDomain;
			this.nNotes = nNotes;
		}
		
		public List<Note> getNotesDomain() {
			return notesDomain;
		}
		
		public int getNumberOfNotes() {
			return nNotes;
		}
	}
	
	protected void generateHomework(int nPages, List<NoteGroup> pageNoteGroups, String homeworkTypeSuffix) throws IOException {
		BufferedImage iBuff = new BufferedImage(SheetDimensions.SHEET_A4.width, SheetDimensions.SHEET_A4.height, BufferedImage.TYPE_INT_ARGB);
		Graphics2D gBuff = iBuff.createGraphics();
		gBuff.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		AbstractBars hwBars = getHomeworkBars();
		
		for(int pageIndex = 1; pageIndex <= nPages; pageIndex++) {
			List<Note> notes = new ArrayList<Note>();
			
			for(NoteGroup noteGroup : pageNoteGroups) {
				notes.addAll(getRandomNotes(noteGroup));
			}
			
			hwBars.draw(gBuff, notes, SheetDimensions.SHEET_A4);
			ImageIO.write(iBuff, NotesUtil.DEFAULT_OUTPUT_FILE_TYPE, new File(String.format(NotesUtil.DEFAULT_OUTPUT_FILE_NAME_TEMPLATE, pageIndex, homeworkTypeSuffix)));
		}
	}
	
	protected abstract AbstractBars getHomeworkBars();
	
	protected static final List<Note> getRandomNotes(NoteGroup noteGroup) {
		List<Note> notes = new ArrayList<Note>(noteGroup.getNumberOfNotes());
		Note prevNote = null;
		for(int i = 0; i < noteGroup.getNumberOfNotes(); i++) {
			Note note = null;
			while(note == null) {
				int index = (int)(Math.random()*noteGroup.getNotesDomain().size());
				Note candidate = noteGroup.getNotesDomain().get(index);
				if(!candidate.equals(prevNote)) {
					note = candidate;
				}
			}
			notes.add(note);
			prevNote = note;
		}
		return notes;
	}
}