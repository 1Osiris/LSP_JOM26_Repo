package Q4;

import java.util.HashMap;

public class MapUtilities {
    public static int commonKeyValuePairs(
        HashMap<String, String> map1,
        HashMap<String, String> map2) {
        
        // Check if either map is null or empty
        if (map1 == null || map2 == null || map1.isEmpty() || map2.isEmpty()) {
            return 0;
        }
        
        int commonPairs = 0;
        
        // Iterate through entries in map1
        for (HashMap.Entry<String, String> entry : map1.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            
            // Check if map2 contains the same key-value pair
            if (value.equals(map2.get(key))) {
                commonPairs++;
            }
        }
        
        return commonPairs;
    }
}
