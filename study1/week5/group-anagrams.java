// https://leetcode.com/problems/group-anagrams/
// Time Complexity: O(nlogn), n: length of string which is the longest
// Space Complexity: O(m+n), m: strMap.size, n: anagramList.size
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, ArrayList<String>> strMap = new HashMap<String, ArrayList<String>>();    // key: sorted String, value: String list
        List<List<String>> anagramList = new ArrayList<List<String>>();

        for (String str : strs) {
            String key = sortString(str);
            if (strMap.containsKey(key)) {
                ArrayList<String> strList = strMap.get(key);
                strList.add(str);
                strMap.put(key, strList);
            } else {
                ArrayList<String> strList = new ArrayList<>();
                strList.add(str);
                strMap.put(key, strList);
            }
        }

        for (String key : strMap.keySet()) {
            anagramList.add(strMap.get(key));
        }

        return anagramList;
    }

    // sort string
    public String sortString(String str) {
        StringBuffer sorted = new StringBuffer();
        char[] charArr = str.toCharArray();
        Arrays.sort(charArr);

        for (char ch : charArr) {
            sorted.append(ch);
        }

        return sorted.toString();
    }
}