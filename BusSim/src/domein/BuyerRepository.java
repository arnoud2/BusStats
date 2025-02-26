package domein;
import java.util.List;
import persistentie.BuyerMapper;

public class BuyerRepository {
	
	private final BuyerMapper buyerMap;
	private List<Buyer> buyers;
	
	public BuyerRepository() {
		buyerMap = new BuyerMapper();
		buyers = buyerMap.giveBuyers();
	}
	
	public void addBuyer(Buyer buyer) {
		
	}
	
	public int getAmountBuyers() {
		return 0;
	}
	
	public List<Buyer> getBuyers() {
		return buyers;
	}
}