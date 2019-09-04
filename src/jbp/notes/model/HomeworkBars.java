package jbp.notes.model;

import java.awt.Graphics2D;

import jbp.notes.constants.SheetDimensions;

public class HomeworkBars extends AbstractBars {
	
	private GCleftNoteBars noteBars;
	private TabBars tabBars;
	
	public HomeworkBars() {
		super();
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
	
	private GCleftNoteBars getNoteBars() {
		if(noteBars == null) {
			noteBars = new GCleftNoteBars();
		}
		return noteBars;
	}
	
	private TabBars getTabBars() {
		if(tabBars == null) {
			tabBars = new TabBars();
		}
		return tabBars;
	}
	
	private int getNotesYOffset() {
		return 0;
	}
	
	private int getTabsYOffset() {
		return SheetDimensions.MARGIN_FULL;
	}
}