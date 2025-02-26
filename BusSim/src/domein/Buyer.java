package domein;

public class Buyer {
	
	private int buyerId;
	private int spendingRange;
	
	public Buyer(int buyerId, int spendingRange) {
		setBuyerId(buyerId);
		setSpendingRange(spendingRange);
	}

	public int getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(int buyerId) {
		this.buyerId = buyerId;
	}

	public int getSpendingRange() {
		return spendingRange;
	}

	public void setSpendingRange(int spendingRange) {
		this.spendingRange = spendingRange;
	}
}
