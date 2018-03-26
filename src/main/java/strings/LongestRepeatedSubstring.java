package strings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by gbalasubramanian on 26/03/18.
 */
public class LongestRepeatedSubstring {
    public static void main(String[] args) {
        //System.out.println(getPrefixes("Hello"));

        System.out.println(getSufixes("Hello"));

        System.out.println(longestCommonPrefix("helloh","hellohhello"));

        System.out.println(longestRepeatedSubstring("hellohhello"));

    }

    static List<String> getPrefixes(String str1) {
        List<String> prefixes = new ArrayList<>();
        for (int i = 0; i < str1.length()+1; i++) {
            prefixes.add(str1.substring(0,i));
        }
        return prefixes;
    }

    static List<String> getSufixes(String str1) {
        List<String> prefixes = new ArrayList<>();
        for (int i = str1.length(); i >= 0; i--) {
            prefixes.add(str1.substring(i,str1.length()));
        }
        return prefixes;
    }

    static String longestCommonPrefix(String str1, String str2){
        int min = Math.min(str1.length(),str2.length());
        for (int i=0;i<min;i++){
            if (str1.charAt(i)!=str2.charAt(i)){
                return str1.substring(0,i);
            }
        }
        return str1.substring(0,min);
    }


    static String longestRepeatedSubstring(String str){
        int l = str.length();
        List<String> suffix = getSufixes(str);
        Collections.sort(suffix);
        System.out.println(suffix);
        String longestRepeated = "";
        for (int i=0;i<l-1;i++){
            String lrepeated = longestCommonPrefix(suffix.get(i),suffix.get(i+1));
            System.out.println(lrepeated);
            if (lrepeated.length() > longestRepeated.length()){
                longestRepeated = lrepeated;
            }
        }
        return longestRepeated;
    }

}
