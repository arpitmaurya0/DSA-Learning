package stack;
import java.util.*;
public class Q2_reverse_the_string_using_stack {
    public static String revrseString(String str){
        // create a character type stack
        Stack<Character> s = new Stack<>();
        int idx = 0;
        while(idx < str.length()){
            //push one by ne character in stack
            s.push(str.charAt(idx));
            idx++;
        }
        //create a stringBuilder
        StringBuilder result = new StringBuilder();
        while(!s.isEmpty()){
            // pop one by one element from stack and append it in stringbuilder
            char curr = s.pop();
            result.append(curr);
        }
        //convert stringbuilder -> String
        return result.toString();
    }
    public static void main(String[] args) {
        String str = "Arpit";
        System.out.println(revrseString(str));
    }
}
