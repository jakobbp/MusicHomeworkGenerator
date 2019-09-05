package jbp.notes;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.Map.Entry;

import jbp.notes.constants.MusicalSymbols;
import jbp.notes.util.NotesUtil;

public class NotesGenerator implements MusicalSymbols {
	private static final String ARG_KEY_HELP = "--help";
	private static final String ARG_KEY_TYPE = "--type";
	private static final String ARG_KEY_PAGES = "--pages";
	
	public static void main(String[] args) throws Exception {
		boolean helpRequired = false;
		String homeworkType = null;
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
					homeworkType = keyValuePair[1];
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
		} else if(homeworkType == null || nPages < 1) {
			if(homeworkType == null) {
				System.err.println("Missing 'type' parameter");
			}
			if(nPages < 1) {
				System.err.println("Missing 'pages' parameter");
			}
			printUsageInfo();
		} else {
			generateHomework(homeworkType, nPages);
		}
	}
	
	private static void printUsageInfo() {
		System.out.println("Usage: java -cp \".;./bin\" jbp.notes.NotesGenerator --type=<HW_TYPE> --pages=<N_PAGES>");
		System.out.println("Available homework types are:");
		Map<String, String> availableHomeworkTypes = NotesUtil.getInstance().getAvailableHomeworkTypes();
		for(Entry<String, String> typeEntry : availableHomeworkTypes.entrySet()) {
			System.out.println("  "+typeEntry.getKey()+(typeEntry.getValue().isEmpty() ? "" : " - "+typeEntry.getValue()));
		}
	}
	
	private static void generateHomework(String homeworkType, int nPages) throws IOException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		System.out.println("Generating "+nPages+" pages of "+homeworkType+" type homework.");
		NotesUtil.getInstance().invokeGeneratorMethodByHomeworkType(homeworkType, nPages);
		System.out.println("Done.");
	}
}