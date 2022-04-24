package by.itacademy.notepad.bean;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class NoteTest {
	private Note noteTest;

	@Before
	public void createNewNote() {
		noteTest = new Note();
	}

	@Test
	public void noteTest001() {
		String expected = "check";
		String actual = noteTest.getText();

		Assert.assertEquals(expected, actual);

	}
	
	@Test
	public void noteTest002() {
		String expected = "test 02";
		noteTest = new Note("test 02");
		String actual = noteTest.getText();

		Assert.assertEquals(expected, actual);

	}
	
	@Test
	public void noteTest003() {
		String expected = "Topic 03 - test 03";
		noteTest = new Note("Topic 03", "test 03");
		String actual = noteTest.getTopic() + " - " + noteTest.getText();

		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void noteTest004() {
		String expected = "Topic 04 |2022-04-24 10:15| test 04";
		noteTest = new Note("Topic 04", "2022-04-24 10:15", "test 04");
		String actual = noteTest.toString();

		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void setTopicTest001() {
		String expected = "test 01";
		noteTest.setTopic("test 01");

		String actual = noteTest.getTopic();

		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void setDateTest001() {
		String expected = "2022-04-21 15:23";
		noteTest.setDate("2022-04-21 15:23");

		String actual = noteTest.getDate();

		Assert.assertEquals(expected, actual);
	}

	@Test
	public void setTextTest001() {
		String expected = "text02";
		noteTest.setText("text02");

		String actual = noteTest.getText();

		Assert.assertEquals(expected, actual);
	}
	
	@After
	public void deleteNoteObject() {
		noteTest = null;
	}

}
