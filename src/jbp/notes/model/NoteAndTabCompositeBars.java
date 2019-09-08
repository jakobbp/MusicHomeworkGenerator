package jbp.notes.model;

import java.awt.Graphics2D;

import jbp.notes.constants.SheetDimensions;

public class NoteAndTabCompositeBars extends AbstractBars {
	
	public static NoteAndTabCompositeBars BASS_HOMEWORK_BARS = new NoteAndTabCompositeBars(NoteBars.F_CLEF_OTTAVA_BASSA_BARS, TabBars.FOUR_STRINGS_TAB_BARS);
	public static NoteAndTabCompositeBars GUITAR_HOMEWORK_BARS = new NoteAndTabCompositeBars(NoteBars.G_CLEF_OTTAVA_BASSA_BARS, TabBars.SIX_STRINGS_TAB_BARS);
	
	private NoteBars noteBars;
	private TabBars tabBars;
	
	public NoteAndTabCompositeBars(NoteBars noteBars, TabBars tabBars) {
		super();
		this.noteBars = noteBars;
		this.tabBars = tabBars;
	}

	@Override
	protected void drawBarsRow(Graphics2D g, int width, int x, int y) {
		getNoteBars().drawBarsRow(g, width, x, y+getNotesYOffset());
		getTabBars().drawBarsRow(g, width, x, y+getTabsYOffset());
		g.fillRect(x, y, DEFAULT_BAR_BORDERS_THICKNESS, getTabsYOffset());
	}

	@Override
	protected void drawNote(Graphics2D g, Note note, int x, int yBars) {
		getNoteBars().drawNote(g, note, x, yBars+getNotesYOffset());
	}

	@Override
	protected int getBarsRowSpacing() {
		return getNoteBars().getBarsRowSpacing()+getTabBars().getBarsRowSpacing();
	}

	@Override
	protected int getNotesMargin() {
		return getNoteBars().getNotesMargin();
	}
	
	private NoteBars getNoteBars() {
		return noteBars;
	}
	
	private TabBars getTabBars() {
		return tabBars;
	}
	
	private int getNotesYOffset() {
		return 0;
	}
	
	private int getTabsYOffset() {
		return SheetDimensions.MARGIN_FULL;
	}
}