package jbp.notes.model;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.font.FontRenderContext;

import jbp.notes.constants.MusicalFonts;

public class TabBars extends AbstractBars {
	protected static final int BAR_LINE_SPACING = 16;
	protected static final int BAR_ROW_SPACING = BAR_LINE_SPACING*5+DEFAULT_ROW_SPACING;
	
	public TabBars() {
		super();
	}

	@Override
	void drawBarsRow(Graphics2D g, int width, int x, int y) {
		Font oldfont = g.getFont();
		g.setFont(getFont());
		for(int i = 0; i < 6; i++) {
			g.fillRect(x, y+i*BAR_LINE_SPACING, width, DEFAULT_BAR_LINE_THICKNESS);
		}
		g.fillRect(x, y, 8, 5*BAR_LINE_SPACING);
		g.fillRect(x+width, y, DEFAULT_BAR_BORDERS_THICKNESS, 5*BAR_LINE_SPACING+DEFAULT_BAR_LINE_THICKNESS);
		
		double tactWidth = (width-getNotesMargin())/4.;
		for(int i = 0; i < 4; i++) {
			g.fillRect(x+getNotesMargin()+(int)(i*tactWidth+0.5), y, DEFAULT_BAR_LINE_THICKNESS, 5*BAR_LINE_SPACING);
		}
		
		FontRenderContext fontContext = g.getFontRenderContext();
		float fontHeight = getFont().getLineMetrics("TAB", fontContext).getHeight()*2/3;
		
		g.drawString("T", x+16f, y+1f*BAR_LINE_SPACING+fontHeight/2-1);
		g.drawString("A", x+16f, y+2.5f*BAR_LINE_SPACING+fontHeight/2-1);
		g.drawString("B", x+16f, y+4f*BAR_LINE_SPACING+fontHeight/2-1);
		
		g.setFont(oldfont);
	}

	@Override
	void drawNote(Graphics2D g, Note note, int x, int yBars) {
		// TODO Auto-generated method stub
	}
	
	@Override
	int getBarsRowSpacing() {
		return BAR_ROW_SPACING;
	}
	
	@Override
	int getNotesMargin() {
		return DEFAULT_NOTES_MARGIN;
	}
	
	protected Font getFont() {
		return MusicalFonts.FONT24B;
	}
}