package com.github.stack;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Stack;

/**
 * Created by admin on 2019/二月/20.
 */
public class ValidParentheses {


    public boolean isValid(String s) {
        if (null == s || "".equals(s))
            return true;
        Map<String, String> map = new HashMap<>();
        map.put(")", "(");
        map.put("]", "[");
        map.put("}", "{");
        Stack stack = new Stack();
        for (String b : s.split("")) {
            if (!map.containsKey(b))
                stack.push(b);
            else if (stack.empty() || null != map.get(b) && !map.get(b).equals(stack.pop())) {
                return false;
            }
        }
        return stack.empty();
    }


    public boolean valid(String s) {
        if (null == s || "".equals(s))
            return true;
        Stack<String> stack = new Stack();
        for (String b : s.split("")) {
            if ("(".equals(b)) {
                stack.push(")");
            } else if ("[".equals(b)) {
                stack.push("]");
            } else if ("{".equals(b)) {
                stack.push("}");
            } else if (stack.empty() || !b.equals(stack.pop())) {
                return false;
            }
        }
        return stack.empty();
    }


    public static void main(String[] args) {
        String s = "(){}";
        ValidParentheses vp = new ValidParentheses();

        System.out.println(vp.valid(s));
    }

}
