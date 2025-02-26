package domein;

import java.util.List;

public class DomeinController {

	private final BuyerRepository buyerRepo;
	private final SellerRepository sellerRepo;
	
	
	public DomeinController() {
		buyerRepo = new BuyerRepository();
		sellerRepo = new SellerRepository();
	}

	public List<String> giveAllBuyers() {
		//TODO
		return null;	
	}
	
	public List<String> giveAllSellers() {
		//TODO
		return null;	
	}
	
	public void addBuyer() {
		//TODO
	}
	
	public void addSeller() {
		//TODO
	}
	
	public int getAmountBuyers(){
		return 0;
		//TODO
	}
	
	public int getAmountSellers() {
		return 0;
		//TODO
	}
}
