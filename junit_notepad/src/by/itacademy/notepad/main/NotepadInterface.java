package by.itacademy.notepad.main;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import by.itacademy.notepad.bean.Note;
import by.itacademy.notepad.bean.Notepad;
import by.itacademy.notepad.io.FileProcessing;
import by.itacademy.notepad.logic.Logic;
import by.itacademy.notepad.logic.Search;
import by.itacademy.notepad.view.NotepadView;

public class NotepadInterface {

	public static void main(String[] args) throws Exception {
		
		Notepad notepad = new Notepad("Notepad");
		
		Logic logic = new Logic();
		NotepadView view = new NotepadView();
		Search search = new Search();
		FileProcessing file = new FileProcessing();

		menu(notepad, logic, view, search, file);

	}

	private static void menu(Notepad notepad, Logic logic, NotepadView view, Search search, FileProcessing file) throws IOException {

		Scanner scInt = new Scanner(System.in);
		Scanner scStr = new Scanner(System.in);

		logic.toConvertNotesInList(notepad);

		while (true) {
			System.out.print("Выберите пункт меню: \n" + "0. выйти\n" + "1. вывод всех записей\n"
					+ "2. добавить новую запись\n" + "3. найти запись\n>> ");
			int choice = scInt.nextInt();
			if (choice == 0) {
				break;
			}
			if (choice > 4) {
				System.out.println("Выбран несуществующий пункт меню. Повторите выбор: ");
				continue;
			}
			System.out.println("----------------------------------------------");

			switch (choice) {
			case 1:
				view.printNotepad();
				break;
			case 2:
				while (true) {
					System.out.print(
							"Хотите изменить тему записи (по умолчиню NEW)?\n" + "(1) - да\n" + "(2) - нет\n>> ");
					int choiceTwo = scInt.nextInt();
					if (choiceTwo != 1 && choiceTwo != 2) {
						System.out.println("Выбран несуществующий пункт меню. Повторите выбор: ");
						continue;
					}
					if (choiceTwo == 1) {
						System.out.print("Введите тему записи:\n>>");
						String topic = scStr.nextLine();
						System.out.print("Введите текст записи:\n>>");
						String text = scStr.nextLine();
						file.addNoteInFile(notepad, new Note(topic, text), logic);
						break;
					}
					if (choiceTwo == 2) {
						System.out.println("Введите текст записи:\n>>");
						String text = scStr.nextLine();
						file.addNoteInFile(notepad, new Note(text), logic);
						break;
					}
					break;
				}
				break;
			case 3:
				while (true) {
					System.out.print("Найти запись\n" + "(1) - по дате\n" + "(2) - по теме\n" + 
				"(3) - по тексту\n>> ");
					int choiceThree = scInt.nextInt();
					if (choiceThree > 3) {
						System.out.print("Выбран несуществующий пункт меню. Повторите выбор: ");
						continue;
					}
					if (choiceThree == 1) {
						System.out.print("Введите дату записи [YYYY-MM-DD]:\n>> ");
						String enteredDate = scStr.nextLine();
						List<Note> enteredDateNotesList = search.dateSearch(notepad, enteredDate);
						System.out.println("Записи " + enteredDate + " :");
						view.isEmpty(enteredDateNotesList);
						view.printNotesList(enteredDateNotesList);
						while (true) {
							System.out
									.print("(0) - Вернуться назад\n" + "(1) - Удалить найденную запись (записи)\n>> ");
							int choiceThreeOne = scInt.nextInt();
							if (choiceThreeOne > 1) {
								System.out.print("Выбран несуществующий пункт меню. Повторите выбор: ");
								continue;
							}
							switch (choiceThreeOne) {
							case 0:
								break;
							case 1:
								file.rewriteFile(enteredDateNotesList);
							}
							break;
						}
						break;
					}
					if (choiceThree == 2) {
						System.out.print("Введите тему записи:\n>> ");
						String enteredTopic = scStr.nextLine();
						List<Note> enteredTopicNotesList = search.topicSearch(notepad, enteredTopic);
						System.out.println("Записи с темой " + enteredTopic + " :");
						view.isEmpty(enteredTopicNotesList);
						view.printNotesList(enteredTopicNotesList);
						while (true) {
							System.out
									.print("(0) - Вернуться назад\n" + "(1) - Удалить найденную запись (записи)\n>> ");
							int choiceThreeOne = scInt.nextInt();
							if (choiceThreeOne > 1) {
								System.out.print("Выбран несуществующий пункт меню. Повторите выбор: ");
								continue;
							}
							switch (choiceThreeOne) {
							case 0:
								break;
							case 1:
								file.rewriteFile(enteredTopicNotesList);
							}
							break;
						}
						break;
					}
					if (choiceThree == 3) {
						System.out.print("Введите текст(слово) для поиска:\n>> ");
						String enteredText = scStr.nextLine();
						List<Note> enteredTextNotesList = search.textSearch(notepad, enteredText);
						System.out.println("Записи содержащие текст [" + enteredText + "] :");
						view.isEmpty(enteredTextNotesList);
						view.printNotesList(enteredTextNotesList);
						while (true) {
							System.out
									.print("(0) - Вернуться назад\n" + "(1) - Удалить найденную запись (записи)\n>> ");
							int choiceThreeOne = scInt.nextInt();
							if (choiceThreeOne > 1) {
								System.out.print("Выбран несуществующий пункт меню. Повторите выбор: ");
								continue;
							}
							switch (choiceThreeOne) {
							case 0:
								break;
							case 1:
								file.rewriteFile(enteredTextNotesList);
							}
							break;
						}
						break;
					}
					break;
				}
				break;
			}
		}
		scInt.close();
		scStr.close();
	}
}
