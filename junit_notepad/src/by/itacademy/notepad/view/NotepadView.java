package by.itacademy.notepad.view;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import by.itacademy.notepad.bean.Note;

public class NotepadView {

	public void printNotepad() throws IOException {
		File sourceFile = new File("Notepad.txt");
		BufferedReader br = new BufferedReader(new FileReader(sourceFile));
		String line = null;

		int i = 1;
		while ((line = br.readLine()) != null) {
			System.out.println(i + " : " + line);
			i++;
		}

		br.close();
	}

	public void printNotesList(List<Note> lists) {
		for (Note list : lists) {
			System.out.println(list);
		}
	}

	public void isEmpty(List<Note> list) {
		if (list.size() == 0) {
			System.out.println("таких записей нет.");
		}
	}

}
