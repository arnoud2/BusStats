package persistentie;

import java.util.ArrayList;
import java.util.List;

import domein.Seller;

public class SellerMapper {
	public List<Seller> giveSellers(){
		
		List<Seller> sellers = new ArrayList<>();
		// sellerId, productCount, priceRange
		sellers.add(new Seller(1, 1, 20));
		
		return sellers;
	}
}
