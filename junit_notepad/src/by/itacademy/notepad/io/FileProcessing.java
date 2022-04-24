package by.itacademy.notepad.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import by.itacademy.notepad.bean.Note;
import by.itacademy.notepad.bean.Notepad;
import by.itacademy.notepad.logic.Logic;

public class FileProcessing {

	public void addNoteInFile(Notepad notepad, Note note, Logic logic) throws IOException {
		File sourceFile = new File("Notepad.txt");
		BufferedWriter bw = new BufferedWriter(new FileWriter(sourceFile, true));

		String newNote = note.toString();
		bw.write("");
		bw.append(newNote);
		bw.append("\n\n");
		bw.flush();
		bw.close();

		logic.addNoteInList(notepad, note);
	}

	public void rewriteFile(List<Note> enteredNotesList) throws IOException {
		File sourceFile = new File("Notepad.txt");
		File outputFile = new File("Notepad2.txt");

		String line = null;

		BufferedReader br = new BufferedReader(new FileReader(sourceFile));
		BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile));

		boolean deleteLine = false;

		while ((line = br.readLine()) != null) {
			for (int i = 0; i < enteredNotesList.size(); i++) {
				String outputLine = String.valueOf(enteredNotesList.get(i)).replace("  ", " ");
				if (line.equals(outputLine) || line.equals("")) {
					deleteLine = true;
					break;
				} else {
					deleteLine = false;
				}
			}
			if (deleteLine == false) {
				bw.write(line);
				bw.newLine();
				bw.newLine();
			}
		}

		br.close();
		bw.close();

		sourceFile.delete();
		outputFile.renameTo(sourceFile);

	}
}
