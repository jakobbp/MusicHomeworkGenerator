package jbp.notes.model;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.util.List;

import jbp.notes.constants.SheetDimensions;

public abstract class AbstractBars implements SheetDimensions {
	protected static final int DEFAULT_ROW_SPACING = 160;
	protected static final int DEFAULT_NOTES_MARGIN = 100;
	protected static final int DEFAULT_BAR_LINE_THICKNESS = 1;
	protected static final int DEFAULT_BAR_BORDERS_THICKNESS = 2;
	
	public AbstractBars() {
		//EMPTY
	}
	
	public void draw(Graphics2D g, List<Note> notes, Dimension sheetDimensions) {
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, sheetDimensions.width, sheetDimensions.height);
		if(sheetDimensions.width-SheetDimensions.MARGIN_FULL > 0 && sheetDimensions.height-SheetDimensions.MARGIN_FULL > 0) {
			g.setColor(Color.BLACK);
			drawBars(g, sheetDimensions);
			drawNotes(g, notes, sheetDimensions);
		}
	}
	
	void drawBars(Graphics2D g, Dimension sheetDimensions) {
		int y = SheetDimensions.MARGIN_HALF;
		while(y < sheetDimensions.height-SheetDimensions.MARGIN_HALF) {
			drawBarsRow(g, sheetDimensions.width-SheetDimensions.MARGIN_FULL, SheetDimensions.MARGIN_HALF, y);
			y += getBarsRowSpacing();
		}
	}
	
	void drawNotes(Graphics2D g, List<Note> notes, Dimension sheetDimensions) {
		double noteWidth = (sheetDimensions.width-SheetDimensions.MARGIN_FULL-getNotesMargin())/16.;
		for(int i = 0; i < notes.size(); i++) {
			int x = (int)(SheetDimensions.MARGIN_HALF+getNotesMargin()+(i%16+0.5)*noteWidth);
			int yBars = SheetDimensions.MARGIN_HALF+getBarsRowSpacing()*(i/16);
			if(yBars < sheetDimensions.height-SheetDimensions.MARGIN_HALF) {
				drawNote(g, notes.get(i), x, yBars);
			}
		}
	}
	
	abstract void drawBarsRow(Graphics2D g, int width, int x, int y);
	
	abstract void drawNote(Graphics2D g, Note note, int x, int yBars);
	
	abstract int getBarsRowSpacing();
	
	abstract int getNotesMargin();
}