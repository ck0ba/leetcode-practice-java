package org.back0.leetcode.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        var resultList = new ArrayList<List<String>>();

        var keyToListMap = new HashMap<String, List<String>>();
        for (String str : strs) {
            var charCountArr = new char[26];

            for (int i = 0; i < str.length(); i++) {
                charCountArr[str.charAt(i) - 'a']++;
            }

            var mapKey = String.valueOf(charCountArr);
            var mapValueList = keyToListMap.getOrDefault(mapKey, new ArrayList<String>());
            mapValueList.add(str);
            keyToListMap.put(mapKey, mapValueList);
        }

        resultList.addAll(keyToListMap.values());

        return resultList;
    }
}
