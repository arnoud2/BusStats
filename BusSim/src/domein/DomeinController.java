package domein;

import java.util.List;

public class DomeinController {

    private final BuyerRepository buyerRepo;
    private final SellerRepository sellerRepo;

    public DomeinController() {
        buyerRepo = new BuyerRepository();
        sellerRepo = new SellerRepository();
    }

    public void showData() {
    	buyerToString();
        sellerToString();
    }

    public void addBuyer(int spendingRange) {
        int id = buyerRepo.addBuyer(spendingRange);
        System.out.printf("Created buyer with id: %d and spending range of %d succsefuly!%n", id, spendingRange);
    }

	public void addSeller() {
		//TODO
	}
   
	public void removeSeller() {
		//TODO
	}
	
    public void removeBuyer(int buyerId) {
        boolean exists = buyerRepo.removeBuyer(buyerId);
        if (exists)
        	System.out.println("Removed User with id: " + buyerId);
        else
        	System.out.printf("Buyer with id: %d does not exist%n", buyerId);
    }
    
    public void buyerToString() {    	
    	List<Buyer> buyer = buyerRepo.getBuyers();
    	System.out.println();
    	for (Buyer b : buyer) {
    		System.out.printf("-Buyer(%d) spendingRange: %d%n", b.getBuyerId(), b.getSpendingRange());
    		}
    	System.out.println();
    }
    
    public void sellerToString() {
    	List<Seller> seller = sellerRepo.getSellers();
    	for (Seller s : seller) {
    		System.out.printf("-Seller(%d) productCount: %d, priceRange: %d", s.getSellerId(), s.getProductCount(), s.getPriceRange());
    		}
    	System.out.println();
    }
}
