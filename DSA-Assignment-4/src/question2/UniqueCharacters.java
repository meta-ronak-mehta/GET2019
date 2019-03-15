package question2;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import question1.MyLogFile;

public class UniqueCharacters {

    // map to store String as key and number of unique char as value
    private Map<String, Integer> cache;

    public UniqueCharacters() {
        this.cache = new HashMap<String, Integer>();
    }

    /**
     * Method to count the number of unique characters in a string
     * 
     * @param inputString
     * @return count of unique characters
     */
    public int countUniqueCharacters(String inputString) {
        Set<Character> uniqueChar = new HashSet<Character>();

        if (inputString == null || inputString.equals(" ")) {
            MyLogFile.writeToFile("input string is invalid at: " + new Date());
            throw new AssertionError("input string is invalid");
        } else {
            inputString = inputString.toLowerCase();
            if (cache.containsKey(inputString)) {
                System.out.println("cache Works!!!");
                return cache.get(inputString);
            } else {
                inputString = inputString.toLowerCase();
                for (int i = 0; i < inputString.length(); ++i) {
                    char charAtIndex = inputString.charAt(i);
                    if (charAtIndex == ' ') {
                        continue;
                    } else {
                        if (!uniqueChar.contains(charAtIndex)) {
                            uniqueChar.add(charAtIndex);
                        }
                    }
                }
            }
        }
        cache.put(inputString, uniqueChar.size());
        return uniqueChar.size();
    }

}
