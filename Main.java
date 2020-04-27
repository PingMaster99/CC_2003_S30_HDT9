import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;
/**
 * <h1>Main</h1>
 * Main class used to translate a text document in Spanish (text.txt) using a generated dictionary through
 * a red black tree or B-Tree through a factory.
 * <p>
 *
 * @author Sebastian Gonzales (tabufellin) Pablo Ruiz (PingMaster99)
 * @version 1.0
 * @since 2020-04-27
 **/
public class Main {
    public static void main(String[] args) {
        // Used for input
        Scanner input = new Scanner(System.in);

        // Prints the menu layout
        System.out.println("" + "\n***************************************************** \n" +
                "Ingrese la implementacion que desea utilizar: \n 1 -> Red BLack Tree \n 2 -> B-Tree (2-3)" +
                "\n*****************************************************");
        System.out.print(">> ");

        // Asks fot the dictionary implementation
        String mapType = input.nextLine();

        // Generates a RBT or B-Tree through the factory
        MapFactory<String, String> selectedMap = new MapFactory<>();
        Association<String, String> dictionaryMap = new Association<String, String>(selectedMap.getMap(mapType));


        // Adds the needed values in the dictionary and binary tree according to the Spanish.txt text document
        try {
            BufferedReader reader = new BufferedReader(new FileReader("Spanish.txt"));
            String line = "";

            // Generates the map (dictionary)
            while((line = reader.readLine()) != null) {

                String[] words = line.split("\\s+|,|\\( |\\[|/");   // Splits line in whitespaces, commas, etc.

                // Adds the entry only if line has a definition
                if(words[0].charAt(0) != '#' && words.length > 1) {
                    dictionaryMap.addEntry(words[0], words[1] + " ");
                }
            }
        // If there is an error generating the dictionary
        } catch (Exception E) {
            System.err.println("There was an error while generating the dictionary");
        }

        // Prints the translation header
        System.out.println("\n***************************************************** \n" +
                "            El documento traducido es: " + "\n*****************************************************");

        // Reads the document to be translated
        try {
            BufferedReader reader = new BufferedReader(new FileReader("text.txt"));
            String line;

            while((line = reader.readLine()) != null) {
                // Splits the line in the Spanish text document
                String lineInArray[] = line.split("\\s+|,|\\.|!|\\[|/");
                String translatedText = "";

                // Translates each word in the line if its on the dictionary
                for (String word : lineInArray) {
                    translatedText += dictionaryMap.getSpanishWord(word.toLowerCase());
                }

                System.out.println(translatedText); // Prints the translated line
            }
        // If there's an error during execution
        } catch (Exception E) {
            System.err.println("There was an error while converting the file to a map");
        }
    }
}
