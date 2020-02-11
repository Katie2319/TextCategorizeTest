import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.*;
import java.util.Map;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import static org.junit.jupiter.api.Assertions.*;

class TextCategorizeTest {

    private TextCategorize tc;

    private String st = "a dog runs fast and a cat runs slow";

    @BeforeEach
    public void init(){
        tc= new TextCategorize("a dog runs fast and a cat runs slow");
        tc.categorize();

    }

    @org.junit.jupiter.api.Test
    void TestCategorizeWords() {
        Map<String, List<String>>TCcategories = new HashMap<>();
        String[] lA = new String[]{"a","and","a"};
        String[] lR = new String[]{"runs", "runs"};
        TCcategories.put("a", Arrays.asList(lA));
        TCcategories.put("d", Collections.singletonList("dog"));
        TCcategories.put("r", Arrays.asList(lR));
        TCcategories.put("f", Collections.singletonList("fast"));
        TCcategories.put("c", Collections.singletonList("cat"));
        TCcategories.put("s", Collections.singletonList("slow"));
        assertEquals(TCcategories, tc.categories());
    }

    @org.junit.jupiter.api.Test
    void TestgetCategories() {
        ArrayList<String>[] keys = new ArrayList<String> ('a', 'r', 's', 'c', 'd', 'f');
        assertEquals(keys, tc.getCategories());
    }

    @org.junit.jupiter.api.Test
    void TestGetWordCount() {
        assertEquals(9, tc.getWordCount());
    }

    @org.junit.jupiter.api.Test
    void TestgetWordsFor() {
        String[] ans = {"dog"};
        assertEquals(ans, tc.getWordsFor("d"));
    }
}