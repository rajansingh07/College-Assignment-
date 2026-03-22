import java.util.Stack;

/**
 * Problem: Valid Parentheses
 * Given a string s containing only '(', ')', '{', '}', '[', ']',
 * determine if the input string is valid.
 *
 * A string is valid if:
 *   - Open brackets are closed by the same type of bracket.
 *   - Open brackets are closed in the correct order.
 *
 * Example:
 *   Input:  "()[]{}"  → Output: true
 *   Input:  "(]"      → Output: false
 *   Input:  "([)]"    → Output: false
 *
 * Approach: Stack — O(n) time, O(n) space
 */
public class ValidParentheses {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                char top = stack.pop();
                if (c == ')' && top != '(') return false;
                if (c == '}' && top != '{') return false;
                if (c == ']' && top != '[') return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        ValidParentheses solution = new ValidParentheses();

        System.out.println("Test 1: " + solution.isValid("()[]{}"));  // Expected: true
        System.out.println("Test 2: " + solution.isValid("(]"));      // Expected: false
        System.out.println("Test 3: " + solution.isValid("{[]}"));    // Expected: true
        System.out.println("Test 4: " + solution.isValid("([)]"));    // Expected: false
        System.out.println("Test 5: " + solution.isValid(""));        // Expected: true
    }
}
