import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("" + "\n***************************************************** \n" +
                "Ingrese la implementacion que desea utilizar: \n 1 -> Red BLack Tree \n 2 -> B-Tree (2-3)" +
                "\n*****************************************************");
        System.out.print(">> ");
        String mapType = input.nextLine();

        MapFactory<String, String> selectedMap = new MapFactory<>();
        Association<String, String> dictionaryMap = new Association<String, String>(selectedMap.getMap(mapType));


        // Adds the needed values in the dictionary and binary tree according to the text document
        try {
            BufferedReader reader = new BufferedReader(new FileReader("Spanish.txt"));
            String line = "";

            // Generates the map (dictionary)
            while((line = reader.readLine()) != null) {
                String definition = "";
                String[] words = line.split("\\s+|,|\\( |\\[|/");

                if(words[0].charAt(0) != '#' && words.length > 1) {
                    dictionaryMap.addEntry(words[0], words[1] + " ");
                }
            }
        } catch (Exception E) {
            System.err.println("There was an error while generating the dictionary");
        }



        System.out.println("The translated document is: ");
        // Reads the document to be translated
        try {
            BufferedReader reader = new BufferedReader(new FileReader("text.txt"));
            String line;
            while((line = reader.readLine()) != null) {
                String lineInArray[] = line.split("\\s+|,|\\.|!|\\[|/");
                String translatedText = "";
                for (String word : lineInArray) {
                    translatedText += dictionaryMap.getSpanishWord(word.toLowerCase());
                }
                System.out.println(translatedText);
            }
        } catch (Exception E) {
            System.err.println("There was an error while converting the file to a map");
        }
    }
}
