import java.util.HashMap;

public class MapUtilitiesDriver {
    public static void main(String[] args) {
        // Create map1 and add name-value pairs to it
        HashMap<String, String> map1 = new HashMap<>();
        map1.put("A", "No");
        map1.put("B", "No");
        map1.put("X", "Yes");

        HashMap<String, String> map2 = new HashMap<>();
        map2.put("1", "No");
        map2.put("X", "Yes");
        map2.put("2", "No");


        System.out.println(MapUtilities.commonKeyValuePairs(map1, map2));

        HashMap<String, String> emptyMap = new HashMap<>();
        System.out.println(MapUtilities.commonKeyValuePairs(map1, emptyMap));
    }
}
