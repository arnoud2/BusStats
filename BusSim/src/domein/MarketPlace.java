package domein;

import java.security.SecureRandom;
import java.util.*;

public class MarketPlace {
    
    private SecureRandom random;

    public MarketPlace() {
        this.random = new SecureRandom();
    }

    public void timeToBuySomething(List<Seller> sellers, List<Buyer> buyers, int surplus) {
        boolean[] buyerBought = new boolean[buyers.size()];
        boolean[] sellerSold = new boolean[sellers.size()];

        Map<Integer, Integer> initialProductCounts = new HashMap<>();
        for (Seller seller : sellers) {
            initialProductCounts.put(seller.getSellerId(), seller.getProductCount());
        }
        List<Buyer> shuffledBuyers = new ArrayList<>(buyers);
        Collections.shuffle(shuffledBuyers, random);

        for (int i = 0; i < shuffledBuyers.size(); i++) {
            Buyer buyer = shuffledBuyers.get(i);
            List<Seller> shuffledSellers = new ArrayList<>(sellers);
            Collections.shuffle(shuffledSellers, random);
            
            for (Seller seller : shuffledSellers) {
                if (sale$$$(buyer, seller, surplus)) {
                    buyerBought[buyers.indexOf(buyer)] = true;
                    sellerSold[sellers.indexOf(seller)] = true;
                    break;
                }
            }
        }

        noTransactions(sellers, buyers, buyerBought, sellerSold);
        for (Seller seller : sellers) {
            seller.setProductCount(initialProductCounts.get(seller.getSellerId()));
        }
    }

    private boolean sale$$$(Buyer buyer, Seller seller, int surplus) {
        if (buyer.getSpendingRange() >= seller.getPriceRange() - surplus &&
            buyer.getSpendingRange() <= seller.getPriceRange() + surplus &&
            seller.getProductCount() > 0) {

            int theSalePrice = (seller.getPriceRange() + buyer.getSpendingRange()) / 2;

            seller.setProductCount(seller.getProductCount() - 1);
            seller.setPriceRange(theSalePrice);
            buyer.setSpendingRange(theSalePrice);

            return true;
        }
        return false;
    }

    private void noTransactions(List<Seller> sellers, List<Buyer> buyers, 
                                boolean[] buyerBought, boolean[] sellerSold) {
        for (int i = 0; i < buyers.size(); i++) {
            if (!buyerBought[i]) {
                buyers.get(i).setSpendingRange((int) (buyers.get(i).getSpendingRange() * 0.9));
            }
        }
        for (int i = 0; i < sellers.size(); i++) {
            if (!sellerSold[i]) {
                sellers.get(i).setPriceRange((int) (sellers.get(i).getPriceRange() * 0.9));
            }
        }
    }
}
