package by.itacademy.notepad.logic;

import java.util.ArrayList;
import java.util.List;

import by.itacademy.notepad.bean.Note;
import by.itacademy.notepad.bean.Notepad;

public class Search {

	public List<Note> dateSearch(Notepad notepad, String enteredDate) {
		List<Note> enteredDateNotesList = new ArrayList<>();
		for (int i = 0; i < notepad.getNote().size(); i++) {
			String dateInFile = notepad.getNote().get(i).getDate().substring(0, 10);
			if (enteredDate.trim().replaceFirst(" ", "").equals(dateInFile)) {
				enteredDateNotesList.add(notepad.getNote().get(i));
			}
		}
		return enteredDateNotesList;
	}

	public List<Note> topicSearch(Notepad notepad, String enteredTopic) {
		List<Note> enteredTopicNotesList = new ArrayList<>();
		for (int i = 0; i < notepad.getNote().size(); i++) {
			String topicInFile = notepad.getNote().get(i).getTopic().substring(0).toLowerCase().replace(" ", "");
			if (enteredTopic.trim().toLowerCase().replace(" ", "").equals(topicInFile)) {
				enteredTopicNotesList.add(notepad.getNote().get(i));
			}
		}
		return enteredTopicNotesList;
	}

	public List<Note> textSearch(Notepad notepad, String enteredText) {
		List<Note> enteredTextNotesList = new ArrayList<>();
		for (int i = 0; i < notepad.getNote().size(); i++) {
			String textInFile = notepad.getNote().get(i).getText().toLowerCase();
			if (textInFile.contains(enteredText.trim().toLowerCase())) {
				enteredTextNotesList.add(notepad.getNote().get(i));
			}
		}
		return enteredTextNotesList;
	}

}
