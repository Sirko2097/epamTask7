package task2;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;

public class Translater {
    private HashMap<String, String> translate = new HashMap<String, String>();

    void addWord(String eng, String ukr) {
        try {
            translate.put(eng.toLowerCase(), ukr.toLowerCase());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            System.out.println(eng);
            System.out.println(ukr);
        }
    }

    String translate(String str) {
        Iterator<Map.Entry<String, String>> iterator = translate.entrySet().iterator();

        Map.Entry<String, String> result;

        while (iterator.hasNext()) {
            result = iterator.next();
            if (result.getKey().equals(str)) {
                return result.getValue();
            }
        }
        throw new NoSuchElementException();
    }

}
