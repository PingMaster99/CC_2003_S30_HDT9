/**
 * <h1>Association</h1>
 * Methods used to define the dictionary
 * <p>
 *
 * @author Pablo Ruiz (PingMaster99)
 * @version 1.0
 * @since 2020-04-20
 **/
public class Association<K, V> {
    private String mapType = "1";


    public Association(MapInterface<K, V> dictionaryMap) {
        this.dictionaryMap = dictionaryMap;
    }

    MapInterface<K, V> dictionaryMap;

    /**
     * Adds a dictionary entry
     * @param english word in English
     * @param spanish word in Spanish
     */
    public void addEntry(K english, V spanish) {
        dictionaryMap.put(english, spanish);
    }

    /**
     * Checks if a word is in the dictionary
     * @param englishWord word in English
     * @return boolean if it contains the word
     */
    public boolean containsWord(K englishWord) {
        if(dictionaryMap.get(englishWord) != null){
            return true;
        } else {
            return false;
        }
    }

    /**
     * Gets the word in Spanish from an English word
     * @param englishWord word in english
     * @return the word in Spanish
     */
    public String getSpanishWord(K englishWord) {
        if(containsWord(englishWord)) {
            return dictionaryMap.get(englishWord);
        } else {
            return englishWord.toString();
        }
    }
}