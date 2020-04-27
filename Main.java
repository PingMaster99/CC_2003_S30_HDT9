import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Ingrese la implementacion que desea utilizar: \n 1 -> Splay Tree \n 2 -> B-Tree");
        String mapType = input.nextLine();

        MapFactory<String, String> selectedMap = new MapFactory<>();
        Association<String, String> dictionaryMap = new Association<>(selectedMap.getMap("mapType"));

        // Adds the needed values in the dictionary and binary tree according to the text document
        try {
            BufferedReader reader = new BufferedReader(new FileReader("dictionary.txt"));
            String line;

            // Generates the map (dictionary)
            while((line = reader.readLine()) != null) {
                // Formats the line so that it can be saved in the dictionary
                line = line.replace("(", "");
                line = line.replace(")", "");
                String[] splitLine = line.split(",");   // Splits it in two words
                splitLine[1] = splitLine[1].replace(" ", "");   // Removes additional space
                dictionaryMap.addEntry(splitLine[0], splitLine[1]); // Adds them to the dictionary
            }
        } catch (Exception E) {
            System.err.println("There was an error while converting the file to a map");
        }


        System.out.println("The translated document is: ");
        // Reads the document to be translated
        try {
            BufferedReader reader = new BufferedReader(new FileReader("text.txt"));
            String line;

            // Gets the words needed to translate
            while((line = reader.readLine()) != null) {
                String translatedLine = "";
                // Initializes an array in case the line is empty
                String[] wordsToTranslate = new String[0];
                // The array contains the words in the line
                if(line.length() > 0) {
                    wordsToTranslate = line.split(" ");
                }

                // Runs through every word in the array
                for(int i = 0; i < wordsToTranslate.length; i ++) {

                    // Last character in the current word
                    char lastCharacter = wordsToTranslate[i].charAt(wordsToTranslate[i].length() - 1);
                    // Assumes the word is lowercase and has no punctuation in the end
                    boolean punctuation = false;
                    boolean uppercase = false;

                    // If the word contains punctuation
                    if(lastCharacter == '.' || lastCharacter == ';' || lastCharacter == ':' || lastCharacter == ','
                            || lastCharacter == '!' || lastCharacter == '?') {
                        //Removes the punctuation mark and the punctuation flag is set to true
                        wordsToTranslate[i] = wordsToTranslate[i].replace("" + lastCharacter, "");
                        punctuation = true;
                    }

                    // Saves the original word to translate
                    String originalWord = wordsToTranslate[i];

                    // If it's capitalized, the corresponding flag is set
                    if (Character.isUpperCase(wordsToTranslate[i].charAt(0))){
                        uppercase = true;
                    }

                    // Converts the word to lowercase
                    wordsToTranslate[i] = wordsToTranslate[i].toLowerCase();

                    // If the word is in the dictionary, it is translated
                    if(dictionaryMap.containsWord(wordsToTranslate[i])) {
                        String translatedWord = dictionaryMap.getSpanishWord(wordsToTranslate[i]);
                        // If the original word was in uppercase, the translated one is too
                        if(uppercase) {
                            translatedWord = translatedWord.replace(translatedWord.charAt(0) + "",
                                    (translatedWord.charAt(0) + "").toUpperCase());
                        }
                        // Adds the word to the translated line
                        translatedLine = translatedLine + " " + translatedWord;
                        // If it's not in the dictionary, the word is surrounded by asterisks
                    } else {
                        translatedLine = translatedLine + " *" + originalWord + "*";
                    }

                    // If the word had a punctuation mark, it is once again added after the translation
                    if(punctuation) {
                        translatedLine += lastCharacter + "";
                    }

                }
                // Prints the translated line
                System.out.println(translatedLine);
            }
        } catch (Exception E) {
            System.err.println("There was an error while converting the file to a map");
        }

    }
}
