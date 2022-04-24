package by.itacademy.notepad.io;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import by.itacademy.notepad.bean.Note;

public class FileProcessingTest {
	private FileProcessing fileTest;
	
	@Before
	public void creatNewFileProcessing() {
		fileTest = new FileProcessing();
	}
	
	@Test
	public void rewriteFileTest001() throws IOException {
		List<Note> testList = new ArrayList<>();
		testList.add(new Note("NEW", "2022-04-23", "text"));
		File outputFile = new File("Notepad2.txt");
		
		fileTest.rewriteFile(testList);

		Assert.assertFalse(outputFile.isFile());
	}
	
	@After
	public void deleteFileProcessingObject() {
		fileTest = null;
	}

}
