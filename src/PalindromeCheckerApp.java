public class PalindromeCheckerApp {

    // Function to check palindrome
    public static boolean isPalindrome(String input) {

        // Step 1: Normalize the string
        String normalized = input.replaceAll("\\s+", "").toLowerCase();

        // Step 2: Convert to character array
        char[] chars = normalized.toCharArray();

        int start = 0;
        int end = chars.length - 1;

        // Step 3: Compare characters
        while (start < end) {
            if (chars[start] != chars[end]) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }

    public static void main(String[] args) {

        String text = "Never Odd Or Even";

        if (isPalindrome(text)) {
            System.out.println("\"" + text + "\" is a Palindrome (ignoring spaces and case).");
        } else {
            System.out.println("\"" + text + "\" is NOT a Palindrome.");
        }
    }
}