import java.util.Scanner;


class CurrencyConverterLogic {
    
    private double usdToEgp = 50.0;    
    private double usdToEur = 0.85;    
    private double usdToGbp = 0.73;    
    private double usdToSar = 3.67;    
    
     
    public double convert(int choice, double usdAmount) {
        double result = 0;
        
        switch (choice) {
            case 1: // USD to EGP
                result = usdAmount * usdToEgp;
                break;
            case 2: // USD to EUR
                result = usdAmount * usdToEur;
                break;
            case 3: // USD to GBP
                result = usdAmount * usdToGbp;
                break;
            case 4: // USD to SAR
                result = usdAmount * usdToSar;
                break;
        }
        
        return result;
    }
    
     public String getCurrencyName(int choice) {
        String name = "";
        
        switch (choice) {
            case 1: name = "EGP"; break;
            case 2: name = "EUR"; break;
            case 3: name = "GBP"; break;
            case 4: name = "SAR"; break;
        }
        
        return name;
    }
    
     public double getExchangeRate(int choice) {
        double rate = 0;
        
        switch (choice) {
            case 1: rate = usdToEgp; break;
            case 2: rate = usdToEur; break;
            case 3: rate = usdToGbp; break;
            case 4: rate = usdToSar; break;
        }
        
        return rate;
    }
    
     public boolean isValidAmount(double amount) {
        return amount >= 0;
    }
    
     public boolean isValidChoice(int choice) {
        return choice >= 1 && choice <= 5;
    }
}


public class CurrencyConverter {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
         CurrencyConverterLogic logic = new CurrencyConverterLogic();
        
        System.out.println("========================================");
        System.out.println("      CURRENCY CONVERTER     ");
        System.out.println("========================================");
        
        while (true) {
            
            System.out.println("\n--- MAIN MENU ---");
            System.out.println("1. Convert from USD to EGP (Egyptian Pound)");
            System.out.println("2. Convert from USD to EUR (Euro)");
            System.out.println("3. Convert from USD to GBP (British Pound)");
            System.out.println("4. Convert from USD to SAR (Saudi Riyal)");
            System.out.println("5. Exit");
            System.out.print("Enter your choice (1-5): ");
            
            int choice = input.nextInt();
            
            
            if (choice == 5) {
                System.out.println("Thank you for using Currency Converter.");
                break;
            }
            
             if (!logic.isValidChoice(choice)) {
                System.out.println("Invalid choice! Please select a number between 1 and 5.");
                continue;
            }
            
            
            System.out.print("Enter amount in USD: ");
            double usdAmount = input.nextDouble();
            
             if (!logic.isValidAmount(usdAmount)) {
                System.out.println("Error: Amount cannot be negative!");
                continue;
            }
            
             double convertedAmount = logic.convert(choice, usdAmount);
            String currencyName = logic.getCurrencyName(choice);
            double rate = logic.getExchangeRate(choice);
            
            
            System.out.println("\n=== CONVERSION RESULT ===");
            System.out.println(usdAmount + " USD = " + convertedAmount + " " + currencyName);
            System.out.println("Exchange rate: 1 USD = " + rate + " " + currencyName);
        }
        
        input.close();
    }
}
