package jbp.notes;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import jbp.notes.annotations.GeneratorMethod;
import jbp.notes.annotations.HomeworkGenerator;
import jbp.notes.constants.BassNoteCollections;
import jbp.notes.model.AbstractBars;
import jbp.notes.model.NoteAndTabCompositeBars;
import jbp.notes.util.NotesUtil;

@HomeworkGenerator("B")
public class BassHomeworkGenerator extends AbstractHomeworkGenerator {
	@GeneratorMethod(typeId = "FS", description = "Bass homework sheets with TAB bars, where all notes correspond to empty bass strings in standard tuning.")
	public void generateFreeStringsBassHomework(int nPages) throws IOException {
		List<NoteGroup> pageNoteGroups = Arrays.asList(new NoteGroup(BassNoteCollections.STANDARD_FREE_STRING_NOTES, 64));
		generateHomework(nPages, pageNoteGroups, NotesUtil.generateDefaultHomeworkTypeSuffix());
	}
	
	@GeneratorMethod(typeId = "FS1P", description = "Bass homework sheets with TAB bars, where first quarter of notes correspond to empty bass strings in standard tuning and the other notes are random C major notes in first position.")
	public void generateFreeStringsAndFirstPositionBassHomework(int nPages) throws IOException {
		List<NoteGroup> pageNoteGroups = Arrays.asList(	new NoteGroup(BassNoteCollections.STANDARD_FREE_STRING_NOTES, 16),
														new NoteGroup(BassNoteCollections.FIRST_POSITION_C_DUR_NOTES, 48));
		generateHomework(nPages, pageNoteGroups, NotesUtil.generateDefaultHomeworkTypeSuffix());
	}
	
	@GeneratorMethod(typeId = "1P", description = "Bass homework sheets with TAB bars, where all notes are random C major notes in first position.")
	public void generateFirstPositionBassHomework(int nPages) throws IOException {
		List<NoteGroup> pageNoteGroups = Arrays.asList(new NoteGroup(BassNoteCollections.FIRST_POSITION_C_DUR_NOTES, 64));
		generateHomework(nPages, pageNoteGroups, NotesUtil.generateDefaultHomeworkTypeSuffix());
	}
	
	@GeneratorMethod(typeId = "3P", description = "Bass homework sheets with TAB bars, where all notes are random C major notes in third position.")
	public void generateThirdPositionBassHomework(int nPages) throws IOException {
		List<NoteGroup> pageNoteGroups = Arrays.asList(new NoteGroup(BassNoteCollections.THIRD_POSITION_C_DUR_NOTES, 64));
		generateHomework(nPages, pageNoteGroups, NotesUtil.generateDefaultHomeworkTypeSuffix());
	}
	
	@GeneratorMethod(typeId = "5P", description = "Bass homework sheets with TAB bars, where all notes are random C major notes in fifth position.")
	public void generateFifthPositionBassHomework(int nPages) throws IOException {
		List<NoteGroup> pageNoteGroups = Arrays.asList(new NoteGroup(BassNoteCollections.FIFTH_POSITION_C_DUR_NOTES, 64));
		generateHomework(nPages, pageNoteGroups, NotesUtil.generateDefaultHomeworkTypeSuffix());
	}
	
	@GeneratorMethod(typeId = "7P", description = "Bass homework sheets with TAB bars, where all notes are random C major notes in seventh position.")
	public void generateSeventhPositionBassHomework(int nPages) throws IOException {
		List<NoteGroup> pageNoteGroups = Arrays.asList(new NoteGroup(BassNoteCollections.SEVENTH_POSITION_C_DUR_NOTES, 64));
		generateHomework(nPages, pageNoteGroups, NotesUtil.generateDefaultHomeworkTypeSuffix());
	}
	
	@GeneratorMethod(typeId = "9P", description = "Bass homework sheets with TAB bars, where all notes are random C major notes in ninth position.")
	public void generateNinthPositionBassHomework(int nPages) throws IOException {
		List<NoteGroup> pageNoteGroups = Arrays.asList(new NoteGroup(BassNoteCollections.NINTH_POSITION_C_DUR_NOTES, 64));
		generateHomework(nPages, pageNoteGroups, NotesUtil.generateDefaultHomeworkTypeSuffix());
	}
	
	@Override
	protected AbstractBars getHomeworkBars() {
		return NoteAndTabCompositeBars.BASS_HOMEWORK_BARS;
	}
}