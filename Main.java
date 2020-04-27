import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Ingrese la implementacion que desea utilizar: \n 1 -> Splay Tree \n 2 -> B-Tree");
        String mapType = input.nextLine();

        MapFactory<String, String> selectedMap = new MapFactory<>();
        Association<String, String> dictionaryMap = new Association<String, String>(selectedMap.getMap(mapType));

        dictionaryMap.addEntry("hey","hoewfwefwefwefla");
        System.out.println(dictionaryMap.getSpanishWord("1"));

        // Adds the needed values in the dictionary and binary tree according to the text document
        try {
            BufferedReader reader = new BufferedReader(new FileReader("Spanish.txt"));
            String line = "";

            // Generates the map (dictionary)
            while((line = reader.readLine()) != null) {

                String definition = "";
                String[] words = line.split(" ");
                for(int i = 1; i < words.length; i++) {
                    String currentWord = words[i];

                    for(int j = 0; j< words[i].length(); j++) {
                        char currentCharacter = words[i].charAt(j);

                        if(currentCharacter == '[') {
                            break;
                        }

                    }
                    String[] lastWord = words[i].split("\\[");

                }

                dictionaryMap.addEntry(words[0], definition);
                //System.out.println(line);

            }
        } catch (Exception E) {
            System.err.println("There was an error while generating the dictionary");
        }



        System.out.println("The translated document is: ");
        // Reads the document to be translated
        try {
            BufferedReader reader = new BufferedReader(new FileReader("text.txt"));
            String line = "";
            while((line = reader.readLine()) != null) {
                String lineInArray[] = line.split("");
                String translatedText = "";
                for (String word : lineInArray) {
                    System.out.println ("hola");
                    translatedText += dictionaryMap.getSpanishWord(word);

                }

            }




        } catch (Exception E) {
            System.err.println("There was an error while converting the file to a map");
        }

    }
}
