package jbp.notes;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import jbp.notes.constants.GuitarNoteGroups;
import jbp.notes.constants.MusicalSymbols;
import jbp.notes.constants.SheetDimensions;
import jbp.notes.model.HomeworkBars;
import jbp.notes.model.Note;

public class NotesGenerator implements MusicalSymbols {
	private static final String ARG_KEY_HELP = "--help";
	private static final String ARG_KEY_TYPE = "--type";
	private static final String ARG_KEY_PAGES = "--pages";
	
	public static void main(String[] args) throws Exception {
		boolean helpRequired = false;
		String hwType = null;
		int nPages = 0;
		for(String arg : args) {
			if(ARG_KEY_HELP.equals(arg)) {
				helpRequired = true;
				break;
			} else if(arg.indexOf('=') != -1) {
				String[] keyValuePair = arg.split("=");
				if(keyValuePair.length != 2) {
					helpRequired = true;
					break;
				} else if(ARG_KEY_TYPE.equals(keyValuePair[0])) {
					hwType = keyValuePair[1];
				} else if(ARG_KEY_PAGES.equals(keyValuePair[0])) {
					try {
						nPages = Integer.parseInt(keyValuePair[1]);
					} catch(NumberFormatException e) {
						//EMPTY
					}
					if(nPages < 1) {
						System.err.println("Invalid number of pages: '"+keyValuePair[1]+"'");
						helpRequired = true;
						break;
					}
				} else {
					System.err.println("Unrecognized argument assignment: '"+keyValuePair[0]+"'");
					helpRequired = true;
					break;
				}
			} else {
				System.err.println("Unrecognized argument: '"+arg+"'");
				helpRequired = true;
				break;
			}
		}
		
		if(helpRequired) {
			printUsageInfo();
		} else if(hwType == null || nPages < 1) {
			if(hwType == null) {
				System.err.println("Missing 'type' parameter");
			}
			if(nPages < 1) {
				System.err.println("Missing 'pages' parameter");
			}
			printUsageInfo();
		} else {
			generateHomework(hwType, nPages);
		}
	}
	
	private static void printUsageInfo() {
		System.out.println("Usage: java -cp \".;./bin\" jbp.notes.NotesGenerator --type=<HW_TYPE> --pages=<N_PAGES>");
	}
	
	private static void generateHomework(String hwType, int nPages) throws IOException {
		switch(hwType) {
		case "G1":
			generateType1GuitarHomework(nPages);
			break;
		case "G2":
			generateType2GuitarHomework(nPages);
			break;
		case "G3":
			generateType3GuitarHomework(nPages);
			break;
		default:
			System.err.println("Unknown 'type' value: '"+hwType+"'");
			System.out.println("Allowed types are: G1, G2, G3");
		}
	}

	private static void generateType1GuitarHomework(int nPages) throws IOException {
		int nStringNotes = 64;
		int nAllNotes = 0;
		String typeSuffix = "G1";
		generateGuitarHomework(nPages, nStringNotes, nAllNotes, typeSuffix);
	}
	
	private static void generateType2GuitarHomework(int nPages) throws IOException {
		int nStringNotes = 16;
		int nAllNotes = 48;
		String typeSuffix = "G2";
		generateGuitarHomework(nPages, nStringNotes, nAllNotes, typeSuffix);
	}
	
	private static void generateType3GuitarHomework(int nPages) throws IOException {
		int nStringNotes = 0;
		int nAllNotes = 64;
		String typeSuffix = "G3";
		generateGuitarHomework(nPages, nStringNotes, nAllNotes, typeSuffix);
	}
	
	private static void generateGuitarHomework(int nPages, int nStringNotes, int nAllNotes, String typeSuffix) throws IOException {
		BufferedImage iBuff = new BufferedImage(SheetDimensions.SHEET_A4.width, SheetDimensions.SHEET_A4.height, BufferedImage.TYPE_INT_ARGB);
		Graphics2D gBuff = iBuff.createGraphics();
		gBuff.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		HomeworkBars hwBars = new HomeworkBars();
		String fileNameTemplate = "Naloga-%2$s-%1$02d.png";
		
		for(int pageIndex = 1; pageIndex <= nPages; pageIndex++) {
			List<Note> notes = new ArrayList<Note>(nStringNotes+nAllNotes);
			
			Note prevNote = null;
			for(int i = 0; i < nStringNotes; i++) {
				Note note = null;
				while(note == null) {
					int index = (int)(Math.random()*GuitarNoteGroups.STANDARD_FREE_STRING_NOTES.size());
					Note candidate = GuitarNoteGroups.STANDARD_FREE_STRING_NOTES.get(index);
					if(!candidate.equals(prevNote)) {
						note = candidate;
					}
				}
				notes.add(note);
				prevNote = note;
			}
			
			prevNote = null;
			for(int i = 0; i < nAllNotes; i++) {
				Note note = null;
				while(note == null) {
					int index = (int)(Math.random()*GuitarNoteGroups.FIRST_POSITION_C_DUR_NOTES.size());
					Note candidate = GuitarNoteGroups.FIRST_POSITION_C_DUR_NOTES.get(index);
					if(!candidate.equals(prevNote)) {
						note = candidate;
					}
				}
				notes.add(note);
				prevNote = note;
			}
			
			hwBars.draw(gBuff, notes, SheetDimensions.SHEET_A4);
			ImageIO.write(iBuff, "PNG", new File(String.format(fileNameTemplate, pageIndex, typeSuffix)));
		}
	}
}
