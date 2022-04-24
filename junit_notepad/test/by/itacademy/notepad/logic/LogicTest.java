package by.itacademy.notepad.logic;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import by.itacademy.notepad.bean.Note;
import by.itacademy.notepad.bean.Notepad;

public class LogicTest {
	private Notepad notepadTest;
	private List<Note> notesTest;
	private Logic logic;
	
	@Before
	public void creatNewNotepad() {
		notepadTest = new Notepad("LogicTest");

		notesTest = new ArrayList<>();
		notesTest.add(new Note("NEW", "2022-04-23", "text"));
		notesTest.add(new Note("NEW1", "2022-02-15", "text1"));

		notepadTest.setNotes(notesTest);
		logic = new Logic();
	}
	
	@Test
	public void toConvertNotesInListTest001() throws IOException {
		File sourceFile = new File("LogicTest.txt");
		logic.toConvertNotesInList(notepadTest, sourceFile);
		Assert.assertEquals(notepadTest.getNote().size(), 5);
	}
	
	@Test
	public void addNoteInListTest001() {
		logic.addNoteInList(notepadTest, new Note ("One", "2010-01-14", "OneText"));
		Assert.assertEquals(notepadTest.getNote().size(), 3);
	}
	
	@After
	public void deleteNotepadObject() {
		notepadTest = null;
		notesTest = null;
		logic = null;
	}

}
