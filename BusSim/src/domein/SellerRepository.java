package domein;
import java.util.List;
import persistentie.BuyerMapper;
import persistentie.SellerMapper;

public class SellerRepository {
	
	private final SellerMapper sellerMap;
	private List<Seller> sellers;
	
	public SellerRepository() {
		sellerMap = new SellerMapper();
		sellers = sellerMap.giveSellers();
	}
	
	public void addSeller(Seller seller) {
		
	}
	
	public int getAmountSellers() {
		return 0;
	}
	
	public List<Seller> getSellers() {
		return sellers;
	}
}