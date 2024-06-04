class Solution {
    public String mergeAlternately(String word1, String word2) {

        StringBuilder stringBuilder = new StringBuilder();

        int l1 = word1.length();
        int l2 = word2.length();

        for (int i = 0; i < word1.length() || i < word2.length() ; i++) {

            if(word1.length() > i && word1.charAt(i) != '\0' ){
                stringBuilder.append(word1.charAt(i));
            }
            if(word2.length() > i  && word2.charAt(i) != '\0' ){
                stringBuilder.append(word2.charAt(i));
            }
        }
        return stringBuilder.toString();
    }
}
// "abc"
// "pqr"
// "ab"
// "pqrs"
// "abcd"
// "pq"
class merge_strings_alternately {
    public static void main(String Args[]){

        Solution s = new Solution();

       // System.out.println(s.mergeAlternately("abc", "pqr"));
        System.out.println(s.mergeAlternately("ab", "pqrs"));
    }
}
