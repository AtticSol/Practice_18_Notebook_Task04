package by.itacademy.notepad.logic;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import by.itacademy.notepad.bean.Note;
import by.itacademy.notepad.bean.Notepad;

public class SearchTest {
	private Search search;
	private Notepad notepadTest;
	private List<Note> notesTest;

	@Before
	public void creatNewNotepad() {
		notepadTest = new Notepad("SearchTest");

		notesTest = new ArrayList<>();
		notesTest.add(new Note("NEW", "2022-04-23", "text"));
		notesTest.add(new Note("NEW1", "2022-02-15", "text1"));
		notesTest.add(new Note("Topic", "2020-03-21", "topic"));
		notesTest.add(new Note("Topic1", "2020-02-02", "topic1"));
		notesTest.add(new Note("Kava", "2020-03-21", "to buy cat food"));

		notepadTest.setNotes(notesTest);
		search = new Search();
	}

	@Test
	public void dateSearchTest001() {
		List<Note> testList = new ArrayList<>();
		testList.add(new Note("NEW", "2022-04-23", "text"));

		List<Note> actualDateList = search.dateSearch(notepadTest, "2022-04-23");

		Assert.assertEquals(testList.toString(), actualDateList.toString());
	}

	@Test
	public void topicSearchTest001() {
		List<Note> testList = new ArrayList<>();
		testList.add(new Note("Topic", "2020-03-21", "topic"));
		
		List<Note> actualTopicList = search.topicSearch(notepadTest, "Topic");
		
		Assert.assertEquals(testList.toString(), actualTopicList.toString());
	}
	
	@Test
	public void textSearchTest001() {
		List<Note> testList = new ArrayList<>();
		testList.add(new Note("Kava", "2020-03-21", "to buy cat food"));
		
		List<Note> actualTextList = search.textSearch(notepadTest, "cat");
		
		Assert.assertEquals(testList.toString(), actualTextList.toString());
	}
	
	@After
	public void deleteNotepadObject() {
		notepadTest = null;
		notesTest = null;
		search = null;		
	}

}
