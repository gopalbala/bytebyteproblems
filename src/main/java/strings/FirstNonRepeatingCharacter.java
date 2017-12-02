package strings;

/**
 * Created by gbalasubramanian on 18/11/17.
 */
public class FirstNonRepeatingCharacter {
    public static void main(String[] args) {
        firstNonRepeatingChar("salesforce");
    }

    static void firstNonRepeatingChar(String str) {
        char[] count = new char[256];
        for (int i = 0; i < str.length(); i++) {
            count[str.charAt(i)]++;
        }
        for (int i = 0; i < str.length(); i++) {
            if (count[str.charAt(i)] ==1){
                System.out.println(str.charAt(i));
                break;
            }
        }
    }
}
