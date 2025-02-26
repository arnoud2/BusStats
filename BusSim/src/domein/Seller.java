package domein;

public class Seller {
	
	private int productCount;
	private int priceRange;
	private int sellerId;
	
	public Seller(int sellerId, int productCount, int priceRange) {
		setSellerId(sellerId);
		setProductCount(productCount);
		setPriceRange(priceRange);
	}

	public int getSellerId() {
		return sellerId;
	}

	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}

	public void setProductCount(int productCount) {
		this.productCount = productCount;
	}
	
	public int getProductCount() {
		return productCount;
	}

	public int getPriceRange() {
		return priceRange;
	}

	public void setPriceRange(int priceRange) {
		this.priceRange = priceRange;
	}
}
