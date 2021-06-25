import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Optional;

public interface ShoppingInterface {

    void AddProduct(PurchasedProduct product) throws IncorrentValueException;
    void getAllProducts();
    String getProductName(int index);
    int countAllProducts();
    int countWeight(ArrayList<PurchasedProduct> list);
    int sumPrices(ArrayList<PurchasedProduct> list);






}
