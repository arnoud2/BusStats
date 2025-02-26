package persistentie;

import java.util.ArrayList;
import java.util.List;
import domein.Buyer;

public class BuyerMapper {
    public List<Buyer> giveBuyers() {
        List<Buyer> buyers = new ArrayList<>();
        
        buyers.add(new Buyer(1, 10));
        buyers.add(new Buyer(2, 50));
        buyers.add(new Buyer(3, 100));


        return buyers;
    }
}
