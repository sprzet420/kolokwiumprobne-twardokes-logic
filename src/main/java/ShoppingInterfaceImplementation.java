import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;

public class ShoppingInterfaceImplementation implements ShoppingInterface {
    ArrayList<PurchasedProduct> products = new ArrayList<PurchasedProduct>();


    @Override
    public void AddProduct(PurchasedProduct product) throws IncorrentValueException{

        if (countWeight(products)+product.getWeight()>20){
                IncorrentValueException exception = new IncorrentValueException("Zbyt duża waga listy",countWeight(products)+product.getWeight());
                throw exception;
        }
        else if(product.getUnitPrice()<1||product.getUnitPrice()>1000){
            IncorrentValueException exception = new IncorrentValueException("Błędna cena",product.getUnitPrice());
            throw exception;
        }
        else if(product.getWeight()>20||product.getWeight()<1){
            IncorrentValueException exception = new IncorrentValueException("Błędna waga",product.getWeight());
            throw exception;
        }
        else{
            products.add(product);
        }
    }


    @Override
    public void getAllProducts(){
        for(int i=0;i<products.size();i++){
            System.out.println("Nazwa: "+products.get(i).getProductName()+", Cena jednostkowa: "+products.get(i).getUnitPrice()+", Waga: "+products.get(i).getWeight()+", Ilość: "+products.get(i).getQuantity());
        }

    }

    @Override
    public int countAllProducts(){
        int howmanyproducts=0;
        for(int i=0;i<products.size();i++){
            howmanyproducts = howmanyproducts + products.get(i).getQuantity();
        }
        return howmanyproducts;
    }

    @Override
    public int countWeight(ArrayList<PurchasedProduct> list){
        int weight=0;
        for(int i=0;i<products.size();i++) {
           weight = weight + products.get(i).getWeight() * products.get(i).getQuantity();
        }
        return weight;

    }

    @Override
    public int sumPrices(ArrayList<PurchasedProduct> list){
        int sum=0;
        for(int i=0;i<products.size();i++){
            sum = sum + products.get(i).getUnitPrice() * products.get(i).getQuantity();
        }
        return sum;
    }

    @Override
    public String getProductName(int index){

        return products.get(index).getProductName();
    }



}
