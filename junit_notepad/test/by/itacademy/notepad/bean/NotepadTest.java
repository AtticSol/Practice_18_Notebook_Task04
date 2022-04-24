package by.itacademy.notepad.bean;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class NotepadTest {
	private Notepad notepadTest;
	private List<Note> notesTest;

	@Before
	public void createNewNotepad() {
		notepadTest = new Notepad("Notepad Test");
		
		notesTest = new ArrayList<>();
		notesTest.add(new Note("NEW", "2022-04-23", "text"));
		notesTest.add(new Note("NEW", "2010-01-26", "textnew"));
	}

	@Test
	public void notepadTest001() {
		String expected = "Notepad Test";
		String actual = notepadTest.getNotepadName();

		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void setNotepadNameTest001() {
		String expected = "Notepad NameTest001";
		notepadTest.setNotepadName("Notepad NameTest001");
		String actual = notepadTest.getNotepadName();

		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void setNotesTest001() {
		List<Note> expectedList = new ArrayList<>();
		expectedList.add(new Note("NEW", "2022-04-23", "text"));
		expectedList.add(new Note("NEW", "2010-01-26", "textnew"));
		
		notepadTest.setNotes(notesTest);
		List<Note> actualList = notepadTest.getNote();
		
		Assert.assertEquals(expectedList, actualList);
	}
	
	@Test
	public void toStringTest001() {
		String expected = "[NEW |2022-04-23| text, NEW |2010-01-26| textnew]";
		
		notepadTest.setNotes(notesTest);
		String actual = notepadTest.toString();
		
		Assert.assertEquals(expected, actual);
	}
	
	@After
	public void deleteNoteObject() {
		notepadTest = null;
	}
	
	

}
