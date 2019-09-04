package jbp.notes.model;

import jbp.notes.constants.MusicalSymbols;

public class GCleftNoteBars extends AbstractNoteBars {
	private int CLEFT_Y_POSITION = 4*BAR_LINE_SPACING;
	private int C_Y_POSITION = (int)(5.5*BAR_LINE_SPACING+0.5);

	protected GCleftNoteBars() {
		super(MusicalSymbols.G_CLEFT);
	}

	@Override
	protected int getCleftYPosition() {
		return CLEFT_Y_POSITION;
	}

	@Override
	protected int getCYPosition() {
		return C_Y_POSITION;
	}

	@Override
	protected int getLowerHelperLinesStartingCOffset() {
		return 0;
	}

	@Override
	protected int getHigherHelperLinesStartingCOffset() {
		return 12;
	}
}