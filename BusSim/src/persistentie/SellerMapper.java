package persistentie;

import java.util.ArrayList;
import java.util.List;
import domein.Seller;

public class SellerMapper {
    public List<Seller> giveSellers() {
        List<Seller> sellers = new ArrayList<>();

        sellers.add(new Seller(1, 5, 10));
        sellers.add(new Seller(2, 2, 50));
        sellers.add(new Seller(3, 10, 25));
        sellers.add(new Seller(4, 1, 100));
        sellers.add(new Seller(5, 7, 40));

        return sellers;
    }
}
