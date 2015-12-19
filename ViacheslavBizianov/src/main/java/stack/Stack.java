package stack;


public class Stack {

    final private int ARRAY_SIZE = 20;
    private char[] array;
    private int nElem=-1;

    public Stack() {
        this.array = new char[ARRAY_SIZE];
    }

    public void push(char a){
        array[++nElem] = a;
    }

    public char pop(){
        return array[nElem--];
    }

    public void bracketChecker(String input){
        boolean error = false;
        for (int i=0; i<input.length(); i++){
            char ch = input.charAt(i);
            if (ch == '{' || ch == '(' || ch == '['){
                push(ch);
            }
            if (ch == '}' || ch == ')' || ch == ']'){
                char temp = pop();
                if ( (ch == '}' && temp != '{')||(ch == ')' && temp !='(')||(ch == ']' && temp!= '[')){
                    System.out.println("error");
                    error = true;
                    break;
                }
            }
        }
        if (!error) {
            System.out.println("code is clean");
        }
    }
}
