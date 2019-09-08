package jbp.notes.model;

import java.awt.Font;
import java.awt.Graphics2D;
import java.util.HashMap;
import java.util.Map;

import jbp.notes.constants.MusicalFonts;
import jbp.notes.constants.MusicalSymbols;

public class NoteBars extends AbstractBars {
	protected static final class ClefSettings {
		private String clefSymbol;
		private int clefYPosition;
		private int cYPosition;
		private int lowerHelperLinesStartingCOffset;
		private int higherHelperLinesStartingCOffset;
		
		public ClefSettings(String clefSymbol, int clefYPosition, int cYPosition, int lowerHelperLinesStartingCOffset, int higherHelperLinesStartingCOffset) {
			this.clefSymbol = clefSymbol;
			this.clefYPosition = clefYPosition;
			this.cYPosition = cYPosition;
			this.lowerHelperLinesStartingCOffset = lowerHelperLinesStartingCOffset;
			this.higherHelperLinesStartingCOffset = higherHelperLinesStartingCOffset;
		}
		
		public ClefSettings(String clefSymbol, ClefSettings parentSettings) {
			this(	clefSymbol,
					parentSettings.clefYPosition,
					parentSettings.cYPosition,
					parentSettings.lowerHelperLinesStartingCOffset,
					parentSettings.higherHelperLinesStartingCOffset	);
		}
		
		public String getClefSymbol() {
			return clefSymbol;
		}
		
		public int getClefYPosition() {
			return clefYPosition;
		}
		
		public int getCYPosition() {
			return cYPosition;
		}
		
		public int getLowerHelperLinesStartingCOffset() {
			return lowerHelperLinesStartingCOffset;
		}
		
		public int getHigherHelperLinesStartingCOffset() {
			return higherHelperLinesStartingCOffset;
		}
	}
	
	protected static final int BAR_LINE_SPACING = 12;
	protected static final int BAR_ROW_SPACING = BAR_LINE_SPACING*4+DEFAULT_ROW_SPACING;
	
	public static final ClefSettings F_CLEF_SETTINGS = new ClefSettings(MusicalSymbols.F_CLEF, (int)(4.5*BAR_LINE_SPACING+0.5), 3*BAR_LINE_SPACING, -5, 7);
	public static final ClefSettings F_CLEF_OTTAVA_ALTA_SETTINGS = new ClefSettings(MusicalSymbols.F_CLEF_8A, F_CLEF_SETTINGS);
	public static final ClefSettings F_CLEF_OTTAVA_BASSA_SETTINGS = new ClefSettings(MusicalSymbols.F_CLEF_8B, F_CLEF_SETTINGS);
	
	public static final ClefSettings G_CLEF_SETTINGS = new ClefSettings(MusicalSymbols.G_CLEF, 4*BAR_LINE_SPACING, (int)(5.5*BAR_LINE_SPACING+0.5), 0, 12);
	public static final ClefSettings G_CLEF_OTTAVA_ALTA_SETTINGS = new ClefSettings(MusicalSymbols.G_CLEF_8A, G_CLEF_SETTINGS);
	public static final ClefSettings G_CLEF_OTTAVA_BASSA_SETTINGS = new ClefSettings(MusicalSymbols.G_CLEF_8B, G_CLEF_SETTINGS);
	
	public static final NoteBars F_CLEF_BARS = new NoteBars(F_CLEF_SETTINGS);
	public static final NoteBars F_CLEF_OTTAVA_ALTA_BARS = new NoteBars(F_CLEF_OTTAVA_ALTA_SETTINGS);
	public static final NoteBars F_CLEF_OTTAVA_BASSA_BARS = new NoteBars(F_CLEF_OTTAVA_BASSA_SETTINGS);
	
	public static final NoteBars G_CLEF_BARS = new NoteBars(G_CLEF_SETTINGS);
	public static final NoteBars G_CLEF_OTTAVA_ALTA_BARS = new NoteBars(G_CLEF_OTTAVA_ALTA_SETTINGS);
	public static final NoteBars G_CLEF_OTTAVA_BASSA_BARS = new NoteBars(G_CLEF_OTTAVA_BASSA_SETTINGS);
	
	protected static final Map<NoteDuration, String> NOTE_SYMBOLS;
	static {
		NOTE_SYMBOLS = new HashMap<NoteDuration, String>();
		NOTE_SYMBOLS.put(NoteDuration.FULL, MusicalSymbols.FULL_NOTE);
		NOTE_SYMBOLS.put(NoteDuration.HALF, MusicalSymbols.HALF_NOTE);
		NOTE_SYMBOLS.put(NoteDuration.QUARTER, MusicalSymbols.QUARTER_NOTE);
		NOTE_SYMBOLS.put(NoteDuration.EIGHTH, MusicalSymbols.EIGHTH_NOTE);
		NOTE_SYMBOLS.put(NoteDuration.SIXTEENTH, MusicalSymbols.SIXTEENTH_NOTE);
	}
	
	private ClefSettings clefSettings;
	
	public NoteBars(ClefSettings clefSettings) {
		super();
		this.clefSettings = clefSettings;
	}
	
	@Override
	protected void drawBarsRow(Graphics2D g, int width, int x, int y) {
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
		
		g.drawString(getClefSettings().getClefSymbol(), x+4, y+getClefSettings().getClefYPosition());
		g.setFont(oldfont);
	}
	
	@Override
	protected void drawNote(Graphics2D g, Note note, int x, int yBars) {
		Font oldfont = g.getFont();
		g.setFont(MusicalFonts.FONT64);
		String noteSymbol = NOTE_SYMBOLS.get(note.getDuration());
		int noteWidth = g.getFontMetrics().stringWidth(noteSymbol);
		if(note.getCOffset() <= getClefSettings().getLowerHelperLinesStartingCOffset()) {
			for(int i = (note.getCOffset()-getClefSettings().getLowerHelperLinesStartingCOffset())/2; i <= 0; i++) {
				g.fillRect(x-noteWidth/2-2, yBars+(5-i)*BAR_LINE_SPACING-1, noteWidth+4, DEFAULT_BAR_LINE_THICKNESS);
			}
		} else if(note.getCOffset() >= getClefSettings().getHigherHelperLinesStartingCOffset()) {
			for(int i = (note.getCOffset()-getClefSettings().getHigherHelperLinesStartingCOffset())/2; i >= 0; i--) {
				g.fillRect(x-noteWidth/2-2, yBars-i*BAR_LINE_SPACING-1, noteWidth+4, DEFAULT_BAR_LINE_THICKNESS);
			}
		}
		g.drawString(noteSymbol, x-noteWidth/2, yBars+getClefSettings().getCYPosition()-(int)(BAR_LINE_SPACING*0.5*note.getCOffset()+0.5));
		g.setFont(oldfont);
	}
	
	@Override
	protected int getBarsRowSpacing() {
		return BAR_ROW_SPACING;
	}
	
	@Override
	protected int getNotesMargin() {
		return DEFAULT_NOTES_MARGIN;
	}
	
	private ClefSettings getClefSettings() {
		return clefSettings;
	}
}