package jbp.notes.model;

import java.awt.Font;
import java.awt.Graphics2D;
import java.util.HashMap;
import java.util.Map;

import jbp.notes.constants.MusicalFonts;
import jbp.notes.constants.MusicalSymbols;

public abstract class AbstractNoteBars extends AbstractBars {
	protected static final int BAR_LINE_SPACING = 12;
	protected static final int BAR_ROW_SPACING = BAR_LINE_SPACING*4+DEFAULT_ROW_SPACING;
	
	protected static final Map<NoteDuration, String> NOTE_SYMBOLS;
	static {
		NOTE_SYMBOLS = new HashMap<NoteDuration, String>();
		NOTE_SYMBOLS.put(NoteDuration.FULL, MusicalSymbols.FULL_NOTE);
		NOTE_SYMBOLS.put(NoteDuration.HALF, MusicalSymbols.HALF_NOTE);
		NOTE_SYMBOLS.put(NoteDuration.QUARTER, MusicalSymbols.QUARTER_NOTE);
		NOTE_SYMBOLS.put(NoteDuration.EIGHTH, MusicalSymbols.EIGHTH_NOTE);
		NOTE_SYMBOLS.put(NoteDuration.SIXTEENTH, MusicalSymbols.SIXTEENTH_NOTE);
	}
	
	private String cleft;
	
	protected AbstractNoteBars(String cleft) {
		super();
		this.cleft = cleft;
	}
	
	@Override
	void drawBarsRow(Graphics2D g, int width, int x, int y) {
		Font oldfont = g.getFont();
		g.setFont(MusicalFonts.FONT72);
		for(int i = 0; i < 5; i++) {
			g.fillRect(x, y+i*BAR_LINE_SPACING, width, DEFAULT_BAR_LINE_THICKNESS);
		}
		g.fillRect(x, y, DEFAULT_BAR_BORDERS_THICKNESS, 4*BAR_LINE_SPACING);
		g.fillRect(x+width, y, DEFAULT_BAR_BORDERS_THICKNESS, 4*BAR_LINE_SPACING+DEFAULT_BAR_LINE_THICKNESS);
		
		double tactWidth = (width-getNotesMargin())/4.;
		for(int i = 0; i < 4; i++) {
			g.fillRect(x+getNotesMargin()+(int)(i*tactWidth+0.5), y, DEFAULT_BAR_LINE_THICKNESS, 4*BAR_LINE_SPACING);
		}
		
		g.drawString(getCleft(), x+4, y+getCleftYPosition());
		g.setFont(oldfont);
	}
	
	@Override
	void drawNote(Graphics2D g, Note note, int x, int yBars) {
		Font oldfont = g.getFont();
		g.setFont(MusicalFonts.FONT64);
		String noteSymbol = NOTE_SYMBOLS.get(note.getDuration());
		int noteWidth = g.getFontMetrics().stringWidth(noteSymbol);
		if(note.getCOffset() <= getLowerHelperLinesStartingCOffset()) {
			for(int i = note.getCOffset()/2; i <= getLowerHelperLinesStartingCOffset()/2; i++) {
				g.fillRect(x-noteWidth/2-2, yBars+(5-i)*BAR_LINE_SPACING-1, noteWidth+4, DEFAULT_BAR_LINE_THICKNESS);
			}
		} else if(note.getCOffset() >= getHigherHelperLinesStartingCOffset()) {
			for(int i = note.getCOffset()/2; i >= getHigherHelperLinesStartingCOffset()/2; i--) {
				g.fillRect(x-noteWidth/2-2, yBars+(5-i)*BAR_LINE_SPACING-1, noteWidth+4, DEFAULT_BAR_LINE_THICKNESS);
			}
		}
		g.drawString(noteSymbol, x-noteWidth/2, yBars+getCYPosition()-(int)(BAR_LINE_SPACING*0.5*note.getCOffset()+0.5));
		g.setFont(oldfont);
	}
	
	@Override
	int getBarsRowSpacing() {
		return BAR_ROW_SPACING;
	}
	
	@Override
	int getNotesMargin() {
		return DEFAULT_NOTES_MARGIN;
	}
	
	private String getCleft() {
		return cleft;
	}
	
	protected abstract int getCleftYPosition();
	
	protected abstract int getCYPosition();
	
	protected abstract int getLowerHelperLinesStartingCOffset();
	
	protected abstract int getHigherHelperLinesStartingCOffset();
}