package by.itacademy.notepad.view;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import by.itacademy.notepad.bean.Note;
import junit.framework.Assert;

public class NotepadViewTest {
	private List<Note> notesTest;
	private NotepadView viewTest;

	@Before
	public void creatNewNotepad() {
		viewTest = new NotepadView();
		notesTest = new ArrayList<>();
	}

	@Test
	public void printNotesListTest() {
		notesTest.add(new Note("NEW", "2022-04-23", "text"));
		
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		
		viewTest.printNotesList(notesTest);
		
		String expectedOutput = "NEW |2022-04-23| text";
		String actualOutPut = outContent.toString().trim();
		
		Assert.assertEquals(expectedOutput, actualOutPut);
	}
	
	@Test
	public void isEmptyTest() {
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		
		viewTest.isEmpty(notesTest);
		
		String expectedOutput = "таких записей нет.";
		String actualOutPut = outContent.toString().trim();
		
		Assert.assertEquals(expectedOutput, actualOutPut);
	}
	
	@After
	public void deleteNotepadViewObject() {
		notesTest = null;
		viewTest = null;
	}

}
