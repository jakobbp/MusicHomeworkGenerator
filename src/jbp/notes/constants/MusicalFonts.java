package jbp.notes.constants;

import java.awt.Font;
import java.io.File;

public final class MusicalFonts {
	public static Font BASE_FONT;
	public static Font FONT24B;
	public static Font FONT48;
	public static Font FONT64;
	public static Font FONT72;
	
	static {
		try {
		BASE_FONT = Font.createFont(Font.TRUETYPE_FONT, new File("FreeSerif.ttf"));
		} catch(Exception e) {
			e.printStackTrace();
		}
		FONT24B = BASE_FONT.deriveFont(Font.BOLD, 24f);
		FONT48 = BASE_FONT.deriveFont(48f);
		FONT64 = BASE_FONT.deriveFont(64f);
		FONT72 = BASE_FONT.deriveFont(72f);
	}
}