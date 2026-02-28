import java.util.Scanner;
 class Temperature_converter {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("please choose civersion type:");
        System.out.println("1. From Celsius to Fahrenheit");
        System.out.println("2. From Fahrenheit to Celsius");

        int choice = input.nextInt();
        input.nextLine();
        if (choice == 1){
            System.out.print("enter tempreture in celsius");
            double celsius = input.nextDouble();
            double fahrenheit = (celsius * 9/5) + 32;

            System.out.println("Temperture = " + fahrenheit +"F");
        }
        else if (choice == 2){
            System.out.print("enter tempreture in fahrenheit");
            double fahrenheit = input.nextDouble();
            double ceisius = (fahrenheit - 32) * 5/9;

            System.out.println("tempreture in celsuis = " + ceisius +"C");
        }
        else { System.out.println("invalid choice"); }
        input.close();
    }
}