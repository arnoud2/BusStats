package domein;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import persistentie.SellerMapper;

public class SellerRepository {
    
    private final SellerMapper sellerMap;
    private List<Seller> sellers;

    public SellerRepository() {
        sellerMap = new SellerMapper();
        sellers = new ArrayList<>(sellerMap.giveSellers());
        sellers.sort((s1, s2) -> Integer.compare(s1.getSellerId(), s2.getSellerId()));
    }

    public int addSeller(int productCount, int priceRange) {
        int newId = findNextAvailableId();
        Seller seller = new Seller(newId, productCount, priceRange);
        sellers.add(seller);
        sellers.sort((s1, s2) -> Integer.compare(s1.getSellerId(), s2.getSellerId()));
        return newId;
    }

    private int findNextAvailableId() {
        Set<Integer> existingIds = new HashSet<>();
        for (Seller s : sellers) {
            existingIds.add(s.getSellerId());
        }

        int id = 1;
        while (existingIds.contains(id)) {
            id++;
        }
        return id;
    }

    public boolean removeSeller(int sellerId) {
        return sellers.removeIf(s -> s.getSellerId() == sellerId);
    }

    public List<Seller> getSellers() {
        return new ArrayList<>(sellers);
    }
    
    public int getAmountSellers() {
		return sellers.size();
	}
}
