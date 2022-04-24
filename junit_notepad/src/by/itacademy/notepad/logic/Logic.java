package by.itacademy.notepad.logic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import by.itacademy.notepad.bean.Note;
import by.itacademy.notepad.bean.Notepad;

public class Logic {

	public void toConvertNotesInList(Notepad notepad) throws IOException {
		File sourceFile = new File("Notepad.txt");
		BufferedReader br = new BufferedReader(new FileReader(sourceFile));

		String line = null;

		while ((line = br.readLine()) != null) {
			for (int i = 0; i < line.length(); i++) {
				if (line.charAt(0) != 0 && line.charAt(i) == '|') {
					String topic = line.substring(0, i);
					for (int j = i + 1; j < line.length(); j++) {
						if (line.charAt(j) == '|') {
							String date = line.substring(i + 1, j);
							String text = line.substring(j + 1, line.length());
							notepad.getNote().add(new Note(topic, date, text));
							break;
						}
					}
					break;
				}
			}
		}
		br.close();
	}
	
	public void toConvertNotesInList(Notepad notepad, File sourceFile) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(sourceFile));

		String line = null;

		while ((line = br.readLine()) != null) {
			for (int i = 0; i < line.length(); i++) {
				if (line.charAt(0) != 0 && line.charAt(i) == '|') {
					String topic = line.substring(0, i);
					for (int j = i + 1; j < line.length(); j++) {
						if (line.charAt(j) == '|') {
							String date = line.substring(i + 1, j);
							String text = line.substring(j + 1, line.length());
							notepad.getNote().add(new Note(topic, date, text));
							break;
						}
					}
					break;
				}
			}
		}
		br.close();
	}

	public void addNoteInList(Notepad notepad, Note note) {
		notepad.getNote().add(note);
	}

}
