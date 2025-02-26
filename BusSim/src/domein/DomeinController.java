package domein;

import java.util.List;

public class DomeinController {

    private final BuyerRepository buyerRepo;
    private final SellerRepository sellerRepo;
    private final MarketPlace market;

    public DomeinController() {
        buyerRepo = new BuyerRepository();
        sellerRepo = new SellerRepository();
        market = new MarketPlace();
    }

    public void showData() {
        System.out.println("\n===== Market Data =====");
        buyerToString();
        sellerToString();
    }

    public void addBuyer(int spendingRange) {
        int id = buyerRepo.addBuyer(spendingRange);
        System.out.printf("✔ Created Buyer (ID: %d) | Spending Range: %d%n", id, spendingRange);
    }

    public void addSeller(int productCount, int priceRange) {
        int id = sellerRepo.addSeller(productCount, priceRange);
        System.out.printf("✔ Created Seller (ID: %d) | Product Count: %d | Price Range: %d%n", id, productCount, priceRange);
    }

    public void removeSeller(int sellerId) {
        if (sellerRepo.removeSeller(sellerId))
            System.out.printf("✔ Removed Seller (ID: %d)%n", sellerId);
        else
            System.out.printf("❌ Seller (ID: %d) does not exist%n", sellerId);
    }

    public void removeBuyer(int buyerId) {
        if (buyerRepo.removeBuyer(buyerId))
            System.out.printf("✔ Removed Buyer (ID: %d)%n", buyerId);
        else
            System.out.printf("❌ Buyer (ID: %d) does not exist%n", buyerId);
    }

    public void buyerToString() {       
        List<Buyer> buyers = buyerRepo.getBuyers();
        System.out.println("\n--- Buyers ---");
        if (buyers.isEmpty()) {
            System.out.println("No buyers available.");
        } else {
            buyers.forEach(b -> System.out.printf("Buyer (ID: %d) | Spending Range: %d%n", b.getBuyerId(), b.getSpendingRange()));
        }
    }

    public void sellerToString() {
        List<Seller> sellers = sellerRepo.getSellers();
        System.out.println("\n--- Sellers ---");
        if (sellers.isEmpty()) {
            System.out.println("No sellers available.");
        } else {
            sellers.forEach(s -> System.out.printf("Seller (ID: %d) | Product Count: %d | Price Range: %d%n", s.getSellerId(), s.getProductCount(), s.getPriceRange()));
        }
    }

    public void simulateMarket(int surplus) {
        System.out.println("\n --- Starting Market Simulation --- \n");
        List<Buyer> buyers = buyerRepo.getBuyers();
        List<Seller> sellers = sellerRepo.getSellers();

        market.timeToBuySomething(sellers, buyers, surplus);

        System.out.println("\n --- Market Simulation Completed --- ");
        showData();
    }
}
