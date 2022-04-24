package by.itacademy.notepad.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Notepad {
	private String notepadName;
	private List<Note> notes = new ArrayList<>();
	
	public Notepad(String notepadName) {
		this.notepadName = notepadName;
	}

	public String getNotepadName() {
		return notepadName;
	}

	public void setNotepadName(String notepadName) {
		this.notepadName = notepadName;
	}
	
	public List<Note> getNote() {
		return notes;
	}

	public void setNotes(List<Note> notes) {
		this.notes = notes;
	}

	public String toString() {
		return getNote().toString();
	}

	@Override
	public int hashCode() {
		return Objects.hash(notepadName, notes);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Notepad other = (Notepad) obj;
		return Objects.equals(notepadName, other.notepadName) && Objects.equals(notes, other.notes);
	}
	
	
	

}
