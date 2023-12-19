import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class TaskWithStrings {

    protected Map<String, Integer> countChars(String originalStr) {
        Map<String, Integer> result = new HashMap<>();
        for (int i = 0; i < originalStr.length(); i++){
            if (result.containsKey(originalStr.charAt(i) + "")){
                result.put(originalStr.charAt(i) + "", (result.get(originalStr.charAt(i) + "") + 1));
            }else {
                result.put(originalStr.charAt(i) + "", 1);
            }
        }
        return result;
    }

    @Test
    public void checkStr(){
        Map<String, Integer> expectedOne = new HashMap<>();
        expectedOne.put("a", 4);
        expectedOne.put("b", 4);
        expectedOne.put("s", 2);
        expectedOne.put("d", 1);
        expectedOne.put("f", 1);
        Assert.assertTrue(countChars("aabbbbssdfaa").equals(expectedOne));

        System.out.println(expectedOne);
    }
}
