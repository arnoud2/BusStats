package domein;

import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import persistentie.BuyerMapper;

public class BuyerRepository {
    
    private final BuyerMapper buyerMap;
    private List<Buyer> buyers;

    public BuyerRepository() {
        buyerMap = new BuyerMapper();
        buyers = new ArrayList<>(buyerMap.giveBuyers());
        buyers.sort(Comparator.comparingInt(Buyer::getBuyerId));
    }

    public  int addBuyer(int spendingRange) {
        int newId = findNextAvailableId();
        Buyer buyer = new Buyer(newId, spendingRange);
        buyers.add(buyer);
        buyers.sort(Comparator.comparingInt(Buyer::getBuyerId));
        return newId;
    }

    private int findNextAvailableId() {
        Set<Integer> existingIds = new HashSet<>();
        for (Buyer b : buyers) {
            existingIds.add(b.getBuyerId());
        }
        
        int id = 1;
        while (existingIds.contains(id)) {
            id++;
        }
        return id;
    }

    public boolean removeBuyer(int buyerId) {
        boolean exists = buyers.stream().anyMatch(b -> b.getBuyerId() == buyerId);
        
        if (exists)
            buyers.removeIf(b -> b.getBuyerId() == buyerId);
         return exists;
    }
    
    public int getAmountBuyers() {
        return buyers.size();
    }
    
    public List<Buyer> getBuyers() {
        return new ArrayList<>(buyers);
    }
}
