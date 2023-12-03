
import com.koujo.*;
import java.io.*;
import java.net.*;
import java.util.*;
import com.google.gson.*;

public class Main {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the base currency code: ");
        String baseCurrency = scanner.next();

        System.out.print("Enter the target currency code: ");
        String targetCurrency = scanner.next();

        System.out.print("Enter the amount to convert: ");
        double amount = scanner.nextDouble();

        CurrencyConverterAPI.getExchangeRate(baseCurrency, targetCurrency, (float) amount) ;


    }
}
