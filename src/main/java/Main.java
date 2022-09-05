import java.io.File;
import java.util.Scanner;

class Main{
    public static void main(String[] args) throws Exception{
        File file = new File("C:\\Users\\dmi29\\Desktop\\JavaLessons\\Calculator\\input.txt");
        Scanner sc = new Scanner(file);
        String str = sc.nextLine();
        sc.close();
        double a = 0.0;
        double b = 0.0;
        char action = ' ';
        boolean hasError = false;
        String[] arr = str.split(" ");
        for (int i = 0; i < arr.length; i++) {
            if(!hasError) {
                if (i == 0) {
                    try {
                        a = Double.valueOf(arr[i]);
                    } catch (NumberFormatException e) {
                        System.out.println("Error! Not number");
                        hasError = true;
                    }
                }
                if (i == 1) {
                    if (arr[i].equals("/") || arr[i].equals("*") || arr[i].equals("+") || arr[i].equals("-")) {
                        action = arr[i].charAt(0);
                    } else {
                        hasError = true;
                        System.out.println("Operation Error!");
                    }
                }
                if (i == 2) {
                    try {
                        b = Double.valueOf(arr[i]);
                    } catch (NumberFormatException e) {
                        System.out.println("Error! Not number");
                        hasError = true;
                    }
                }
            }
        }

        if (!hasError) {
            switch (action) {
                case('+'):
                    System.out.println(a + b);
                    break;
                case('-'):
                    System.out.println(a - b);
                    break;
                case('/'):
                    if (b > 0.0) {
                        System.out.println(a / b);
                    } else {
                        System.out.println("Error! Division by zero");
                    }
                    break;
                case('*'):
                    System.out.println(a * b);
                    break;
            }
        }
    }
}