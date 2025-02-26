package domein;

import java.security.SecureRandom;
import java.util.*;

public class MarketPlace {

    private final SecureRandom random;

    public MarketPlace() {
        this.random = new SecureRandom();
    }

    public void timeToBuySomething(List<Seller> sellers, List<Buyer> buyers, int surplus) {
        if (sellers == null || buyers == null || sellers.isEmpty() || buyers.isEmpty()) {
            throw new IllegalArgumentException("Seller and Buyer lists cannot be null or empty.");
        }

        Map<Buyer, Boolean> buyerBought = new HashMap<>();
        Map<Seller, Boolean> sellerSold = new HashMap<>();

        for (Buyer buyer : buyers) buyerBought.put(buyer, false);
        for (Seller seller : sellers) sellerSold.put(seller, false);

        List<Buyer> shuffledBuyers = new ArrayList<>(buyers);
        Collections.shuffle(shuffledBuyers, random);

        for (Buyer buyer : shuffledBuyers) {
            List<Seller> shuffledSellers = new ArrayList<>(sellers);
            Collections.shuffle(shuffledSellers, random);

            for (Seller seller : shuffledSellers) {
                if (processSale(buyer, seller, surplus)) {
                    buyerBought.put(buyer, true);
                    sellerSold.put(seller, true);
                    break;
                }
            }
        }

        adjustPrices(sellers, buyers, buyerBought, sellerSold);
    }

    private boolean processSale(Buyer buyer, Seller seller, int surplus) {
        if (buyer == null || seller == null) return false;

        int buyerSpending = buyer.getSpendingRange();
        int sellerPrice = seller.getPriceRange();

        if (buyerSpending >= sellerPrice - surplus && buyerSpending <= sellerPrice + surplus && seller.getProductCount() > 0) {
            int salePrice = (sellerPrice + buyerSpending) / 2;

            seller.setProductCount(seller.getProductCount() - 1);
            seller.setPriceRange((int) (seller.getPriceRange() * (1 - 0.1) + salePrice * 0.1));
            buyer.setSpendingRange((int) (buyer.getSpendingRange() * (1 - 0.1) + salePrice * 0.1));

            return true;
        }
        return false;
    }

    private void adjustPrices(List<Seller> sellers, List<Buyer> buyers, 
                              Map<Buyer, Boolean> buyerBought, Map<Seller, Boolean> sellerSold) {
        for (Buyer buyer : buyers) {
            if (!buyerBought.get(buyer)) {
                buyer.setSpendingRange((int) (buyer.getSpendingRange() * 0.9));
            }
        }
        for (Seller seller : sellers) {
            if (!sellerSold.get(seller)) {
                seller.setPriceRange((int) (seller.getPriceRange() * 0.9));
            }
        }
    }
}
