package silsub2.model.vo;

public class Product {
	private String pName;
	private int price;
	private String brand;
	
	public Product() {}
	
	public void setPName(String pName) {
		this.pName = pName;
	}
	public String getPName() {
		return pName;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getPrice() {
		return price;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getBrand() {
		return brand;
	}
	
	public String informaotion(String pName, int price, String brand) {
		String str = "";
//		setPName(pName);
//		setPrice(price);
//		setBrand(brand);
		
		str += getPName()+", ";
		str += getPrice()+", ";
		str += getBrand();
		
		return str;
	}
}
