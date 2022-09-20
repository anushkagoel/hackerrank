import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Demo {

    final static List<String> ops = Arrays.asList("+", "-", "*", "/");

    public static void main(String args[]) {
        String exp = "+ 2 3";
        // 2*3 + 5
//        String expr1 ="*235 "
        System.out.println(calculate(exp));
    }

    public static int calculate(String exp) {
        String[] elements = exp.split(" ");
        Stack<Integer> stack = new Stack<>();
        int res =0;

        for(int i = elements.length-1; i>0; i++) {
            String curr = elements[i];
            if(ops.contains(curr)) {
                int right = stack.pop();
                int left = stack.pop();

                switch(curr) {
                    case "+" :
                        res =  right + left;
                        break;
                    default:
                }
                stack.push(res);
            }
            else{
                stack.push(Integer.valueOf(curr));
            }
        }
        return stack.pop();
    }

//    interface Operation {
//        int calculate(int a, int b);
//    }
}
