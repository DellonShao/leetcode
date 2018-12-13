package _151_ReverseWordsInAString;

class Solution {
    public String reverseWords(String s) {
        String[] split = s.split(" ");
        if(split.length == 0 || s.length() == 0) return "";
        StringBuilder sb = new StringBuilder();
        for(int i = split. length - 1; i >= 0; --i){
            if(!split[i].equals(" ") && !split[i].equals(""))
                sb.append(split[i]).append(" ");
        }

        if(sb.charAt(sb.length() - 1) == ' '){
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }
}

public class MainClass {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.reverseWords(" 1"));
    }

}
