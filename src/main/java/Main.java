import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        ArrayList<PurchasedProduct> products = new ArrayList<>();
        ShoppingInterfaceImplementation shoppingsystem = new ShoppingInterfaceImplementation();

        while(true){
            System.out.println("1 - Dodaj przedmiot do listy" + System.lineSeparator()+
                    "2 - Wyświetl listę produktów, " + System.lineSeparator()+
                    "3 - Wyświetl szczegóły konkretnego produktu, " + System.lineSeparator()+
                    "4 - Wyświetl raport" + System.lineSeparator()+
                    "5 - zapisz listę do pliku, " + System.lineSeparator()+
                    "6 - Zakończ");
            int menu = scanner.nextInt();

            if (menu==1){
                System.out.println("Podaj nazwę");
                String name = scanner.next();
                System.out.println("Podaj wagę");
                int weight = scanner.nextInt();
                System.out.println("Podaj cenę");
                int price = scanner.nextInt();
                System.out.println("Podaj ilość");
                int quantity = scanner.nextInt();
                try{
                    PurchasedProduct product = new PurchasedProduct(name,weight,price,quantity);
                    shoppingsystem.AddProduct(product);
                }
                catch(IncorrentValueException exception){
                    exception.printStackTrace();
                    System.out.println(exception.getMessage());
                }

            }
            else if (menu==2){
                shoppingsystem.getAllProducts();

            }
            else if (menu==3){
                System.out.println("Podaj miejsce na liście poszukiwanego przedmiotu");
                System.out.println(shoppingsystem.getProductName(scanner.nextInt()));
            }
            else if (menu==4){
                System.out.println("Łączna cena listy to: "+shoppingsystem.sumPrices(products));
                System.out.println("Łączna waga listy to: "+shoppingsystem.countWeight(products));
                System.out.println("Łączna liczba przedmiotów na liście to: "+shoppingsystem.countAllProducts());
            }
            else if (menu==5){
                System.out.println("Podaj nazwę pliku");
                String desiredname = scanner.next();
                FileWriterImplementation listfile = new FileWriterImplementation();
                listfile.exportData(products,desiredname);

            }
            else if (menu==6){
                System.exit(1);
            }

        }
    }
}
