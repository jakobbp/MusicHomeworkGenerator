package jbp.notes.model;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.font.FontRenderContext;

import jbp.notes.constants.MusicalFonts;

public class TabBars extends AbstractBars {
	public static final TabBars FOUR_STRINGS_TAB_BARS = new TabBars(4, 20);
	public static final TabBars SIX_STRINGS_TAB_BARS = new TabBars(6);
	
	protected static final int DEFAULT_BAR_LINE_SPACING = 16;
	
	private int nRows;
	private int barLineSpacing;
	
	public TabBars(int nRows) {
		this(nRows, DEFAULT_BAR_LINE_SPACING);
	}
	
	public TabBars(int nRows, int barLineSpacing) {
		super();
		this.nRows = nRows;
		this.barLineSpacing = barLineSpacing;
	}

	@Override
	protected void drawBarsRow(Graphics2D g, int width, int x, int y) {
		Font oldfont = g.getFont();
		g.setFont(getFont());
		for(int i = 0; i < getNumberOfRows(); i++) {
			g.fillRect(x, y+i*getBarLineSpacing(), width, DEFAULT_BAR_LINE_THICKNESS);
		}
		g.fillRect(x, y, 8, getTabBarsRowHeight());
		g.fillRect(x+width, y, DEFAULT_BAR_BORDERS_THICKNESS, getTabBarsRowHeight()+DEFAULT_BAR_LINE_THICKNESS);
		
		double tactWidth = (width-getNotesMargin())/4.;
		for(int i = 0; i < 4; i++) {
			g.fillRect(x+getNotesMargin()+(int)(i*tactWidth+0.5), y, DEFAULT_BAR_LINE_THICKNESS, getTabBarsRowHeight());
		}
		
		FontRenderContext fontContext = g.getFontRenderContext();
		float fontHeight = getFont().getLineMetrics("TAB", fontContext).getHeight()*2/3;
		
		g.drawString("T", x+16f, y+getTabBarsRowHeight()/2f-fontHeight*0.65f-1);
		g.drawString("A", x+16f, y+getTabBarsRowHeight()/2f+fontHeight/2-1);
		g.drawString("B", x+16f, y+getTabBarsRowHeight()/2f+fontHeight*1.65f-1);
		
		g.setFont(oldfont);
	}

	@Override
	protected void drawNote(Graphics2D g, Note note, int x, int yBars) {
		//TODO
	}
	
	@Override
	protected int getBarsRowSpacing() {
		return getTabBarsRowHeight()+DEFAULT_ROW_SPACING;
	}
	
	@Override
	protected int getNotesMargin() {
		return DEFAULT_NOTES_MARGIN;
	}
	
	protected int getNumberOfRows() {
		return nRows;
	}
	
	protected int getBarLineSpacing() {
		return barLineSpacing;
	}
	
	protected int getTabBarsRowHeight() {
		return (getNumberOfRows()-1)*getBarLineSpacing();
	}
	
	protected Font getFont() {
		return MusicalFonts.FONT24B;
	}
}