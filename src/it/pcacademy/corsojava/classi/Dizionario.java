package it.pcacademy.corsojava.classi;

import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import it.pcacademy.corsojava.utilities.FileProblemException;
import it.pcacademy.corsojava.utilities.FileUtilities;


public class Dizionario {

	public static void main(String[] args) {
				// inizializzo la variabile dizionario di tipo Set con un Set vuoto
				Set<String> dictionary = Collections.emptySet();
				
				// inizializzo la variabile index di tipo Map contenente oggetti di tipo HashMap<String, Integer>
				Map<String, Integer> index = new HashMap<String, Integer>();
				
				// variabile usata per contare le occorrenze delle parole cercate
				int i = 0;
				
				// dichiaro il riferimento al file che legger�
				File input = new File("file/words.italian.txt");

				try {
					// leggo le righe dal file e le salvo in dictionary
					dictionary = FileUtilities.readLines(input);
				} catch (FileProblemException e) {
					System.err.println("Non � possibile leggere il file! ");
					System.exit(0);
				}
				
				Scanner scanner = new Scanner(System.in);
				
				// inzializzo la stringa initialCharacter
				String initialCharacter = new String(); 
				
				// aggiorno index in base alla lettera inserita da console
				while (!initialCharacter.equals("END") && scanner.hasNext()) {

					initialCharacter = scanner.nextLine();
					for (String name : dictionary) {
						if (name.startsWith(initialCharacter)) {
							//System.out.println(name);
							index.put(initialCharacter, ++i);
						}
					}
					i = 0;
				}
				scanner.close();
				System.out.println(index);	
				
	}

}
