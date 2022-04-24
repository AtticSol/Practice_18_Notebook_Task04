package by.itacademy.notepad.bean;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class Note {

	private String topic;
	private String date;
	private String text;

	{
		Date d = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm");
		date = format.format(d);
		topic = "NEW";
	}

	public Note() {
		text = "check";
	}

	public Note(String text) {
		this.text = text;
	}

	public Note(String topic, String text) {
		this.topic = topic;
		this.text = text;
	}

	public Note(String topic, String date, String text) {
		this.topic = topic;
		this.date = date;
		this.text = text;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String toString() {
		return topic + " |" + date + "| " + text;
	}

	@Override
	public int hashCode() {
		return Objects.hash(date, text, topic);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Note other = (Note) obj;
		return Objects.equals(date, other.date) && Objects.equals(text, other.text)
				&& Objects.equals(topic, other.topic);
	}

	
}
