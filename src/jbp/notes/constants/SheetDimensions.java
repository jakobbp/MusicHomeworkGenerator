package jbp.notes.constants;

import java.awt.Dimension;

public interface SheetDimensions {
	public static final int SHEET_WIDTH_A4 = 1241;
	public static final int SHEET_HEIGHT_A4 = 1755;
	
	public static final Dimension SHEET_A4 = new Dimension(SHEET_WIDTH_A4, SHEET_HEIGHT_A4);

	public static final int MARGIN_FULL = 150;
	public static final int MARGIN_HALF = 75;
	public static final int MARGIN_QUARTER = 37;
}
