package jbp.notes;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import jbp.notes.annotations.GeneratorMethod;
import jbp.notes.annotations.HomeworkGenerator;
import jbp.notes.constants.GuitarNoteCollections;
import jbp.notes.model.AbstractBars;
import jbp.notes.model.NoteAndTabCompositeBars;
import jbp.notes.util.NotesUtil;

@HomeworkGenerator("G")
public class GuitarHomeworkGenerator extends AbstractHomeworkGenerator {
	@GeneratorMethod(typeId = "FS", description = "Guitar homework sheets with TAB bars, where all notes correspond to empty guitar strings in standard tuning.")
	public void generateFreeStringsGuitarHomework(int nPages) throws IOException {
		List<NoteGroup> pageNoteGroups = Arrays.asList(new NoteGroup(GuitarNoteCollections.STANDARD_FREE_STRING_NOTES, 64));
		generateHomework(nPages, pageNoteGroups, NotesUtil.generateDefaultHomeworkTypeSuffix());
	}
	
	@GeneratorMethod(typeId = "FS1P", description = "Guitar homework sheets with TAB bars, where first quarter of notes correspond to empty guitar strings in standard tuning and the other notes are random C major notes in first position.")
	public void generateFreeStringsAndFirstPositionGuitarHomework(int nPages) throws IOException {
		List<NoteGroup> pageNoteGroups = Arrays.asList(	new NoteGroup(GuitarNoteCollections.STANDARD_FREE_STRING_NOTES, 16),
														new NoteGroup(GuitarNoteCollections.FIRST_POSITION_C_DUR_NOTES, 48));
		generateHomework(nPages, pageNoteGroups, NotesUtil.generateDefaultHomeworkTypeSuffix());
	}
	
	@GeneratorMethod(typeId = "1P", description = "Guitar homework sheets with TAB bars, where all notes are random C major notes in first position.")
	public void generateFirstPositionGuitarHomework(int nPages) throws IOException {
		List<NoteGroup> pageNoteGroups = Arrays.asList(new NoteGroup(GuitarNoteCollections.FIRST_POSITION_C_DUR_NOTES, 64));
		generateHomework(nPages, pageNoteGroups, NotesUtil.generateDefaultHomeworkTypeSuffix());
	}
	
	@GeneratorMethod(typeId = "3P", description = "Guitar homework sheets with TAB bars, where all notes are random C major notes in third position.")
	public void generateThirdPositionGuitarHomework(int nPages) throws IOException {
		List<NoteGroup> pageNoteGroups = Arrays.asList(new NoteGroup(GuitarNoteCollections.THIRD_POSITION_C_DUR_NOTES, 64));
		generateHomework(nPages, pageNoteGroups, NotesUtil.generateDefaultHomeworkTypeSuffix());
	}
	
	@GeneratorMethod(typeId = "5P", description = "Guitar homework sheets with TAB bars, where all notes are random C major notes in fifth position.")
	public void generateFifthPositionGuitarHomework(int nPages) throws IOException {
		List<NoteGroup> pageNoteGroups = Arrays.asList(new NoteGroup(GuitarNoteCollections.FIFTH_POSITION_C_DUR_NOTES, 64));
		generateHomework(nPages, pageNoteGroups, NotesUtil.generateDefaultHomeworkTypeSuffix());
	}
	
	@GeneratorMethod(typeId = "7P", description = "Guitar homework sheets with TAB bars, where all notes are random C major notes in seventh position.")
	public void generateSeventhPositionGuitarHomework(int nPages) throws IOException {
		List<NoteGroup> pageNoteGroups = Arrays.asList(new NoteGroup(GuitarNoteCollections.SEVENTH_POSITION_C_DUR_NOTES, 64));
		generateHomework(nPages, pageNoteGroups, NotesUtil.generateDefaultHomeworkTypeSuffix());
	}
	
	@GeneratorMethod(typeId = "9P", description = "Guitar homework sheets with TAB bars, where all notes are random C major notes in ninth position.")
	public void generateNinthPositionGuitarHomework(int nPages) throws IOException {
		List<NoteGroup> pageNoteGroups = Arrays.asList(new NoteGroup(GuitarNoteCollections.NINTH_POSITION_C_DUR_NOTES, 64));
		generateHomework(nPages, pageNoteGroups, NotesUtil.generateDefaultHomeworkTypeSuffix());
	}
	
	@Override
	protected AbstractBars getHomeworkBars() {
		return NoteAndTabCompositeBars.GUITAR_HOMEWORK_BARS;
	}
}