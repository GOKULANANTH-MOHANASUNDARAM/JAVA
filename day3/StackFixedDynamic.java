package day3;

import java.util.Scanner;

public class StackFixedDynamic {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size for fixed: ");
		int sizef = sc.nextInt();
		Fixed f = new Fixed(sizef);
		System.out.println("Enter the size for Dynamic: ");
		int sized = sc.nextInt();
		Dynamic d = new Dynamic(sized);
		System.out.println("Enter the no. to enter into the Fixed stack (" + sizef +"): ");

		for (int i = 0; i < sizef; i++) {
			System.out.print("ENTER: ");
			int n = sc.nextInt();
		    f.push(n);
		    System.out.println();
		}
		System.out.println("item in peek: " + f.peek());
		System.out.println();
		System.out.println("Elements in fixed stack:");
		for (int i = 0; i < sizef; i++) {
		    System.out.println("Item deleted" + f.pop());
		}

		System.out.println();
		System.out.println("Enter the no. to enter into the Dynbamic stack (" + sized +"): ");
		for (int i = 0; i < 10; i++) {
			System.out.print("ENTER: ");
			int n = sc.nextInt();
		    d.push(n);
		    System.out.println();
		}
		System.out.println("item in peek: " + d.peek());
		int length = d.count();
		System.out.println(length);
		System.out.println("Elements in dynamic stack:");
		for (int i = 0; i < length; i++) {
		    System.out.println("Item deleted "+d.pop());
		}
		sc.close();
	 }
}

interface Stack {
    void push(int data);
    int pop();
}

class Fixed implements Stack {
    int[] stack;
    int top = -1;
    int size;

    public Fixed(int size) {
        this.size = size;
        stack = new int[size];
    }

    public void push(int data) {
        if (top == size - 1) {
            System.out.println("Stack is full");
        } else {
            stack[++top] = data;
        }
    }
    
    public int peek() {
    	return stack[top];
    }
    public int pop() {
        if (top == -1) {
            System.out.println("Stack is empty");
            return -1;
        } else {
            return stack[top--];
        }
    }
}

class Dynamic implements Stack {
    int[] stack;
    int top;

    public Dynamic(int size) {
        stack = new int[size];
        top = -1;
    }

    public void push(int value) {
        if (top == stack.length - 1) {
            int[] newStack = new int[stack.length * 2];
            for (int i = 0; i <= top; i++) {
                newStack[i] = stack[i];
            }
            stack = newStack;
        }
        stack[++top] = value;
    }
    
    public int peek() {
    	return stack[top];
    }

    public int pop() {
        if (top < 0) {
            System.out.println("Stack underflow");
            return -1;
        }
        return stack[top--];
    }
    
    public int count() {
    	return top;
    }
}
