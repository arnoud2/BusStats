package persistentie;

import java.util.ArrayList;
import java.util.List;

import domein.Buyer;

public class BuyerMapper {
	public List<Buyer> giveBuyers(){
		
		List<Buyer> buyers = new ArrayList<>();
		//buyerId, spendingRange
		buyers.add(new Buyer(1, 20));
		
		return buyers;
	}
}
