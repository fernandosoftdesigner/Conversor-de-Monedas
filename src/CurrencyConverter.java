import java.util.Scanner;

public class CurrencyConverter {
    private CurrencyConverterService converterService;
    private Scanner scanner;

    public CurrencyConverter(CurrencyConverterService converterService) {
        this.converterService = converterService;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        boolean exit = false;

        while (!exit) {
            System.out.println("Bienvenido al conversor de monedas");
            System.out.println("Seleccione una opción:");
            System.out.println("1. USD a EUR");
            System.out.println("2. USD a GBP");
            System.out.println("3. USD a JPY");
            System.out.println("4. EUR a USD");
            System.out.println("5. GBP a USD");
            System.out.println("6. JPY a USD");
            System.out.println("7. Salir");

            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    convert("USD", "EUR");
                    break;
                case 2:
                    convert("USD", "GBP");
                    break;
                case 3:
                    convert("USD", "JPY");
                    break;
                case 4:
                    convert("EUR", "USD");
                    break;
                case 5:
                    convert("GBP", "USD");
                    break;
                case 6:
                    convert("JPY", "USD");
                    break;
                case 7:
                    exit = true;
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        }
    }

    private void convert(String from, String to) {
        try {
            System.out.println("Ingrese la cantidad en " + from + ": ");
            double amount = scanner.nextDouble();

            double convertedAmount = converterService.convertCurrency(from, to, amount);
            System.out.println(amount + " " + from + " es igual a " + convertedAmount + " " + to);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
