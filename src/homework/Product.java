package homework;

public class Product implements Comparable<Product>{
	private String name;
	private double price;
	//these are the constructors:
	public Product(String Name, double Price) {
		this.name=Name;
		this.price=Price;
	}
	public Product() {
		this.name="unknown";
		this.price=0.0;
	}
	//these are the getters and setters for the two properties:
	public String getName() {
		return this.name;
	}
	
	public void setName(String Name) {
		this.name=Name;
	}
	
	public double getPrice() {
		return this.price;
	}
	
	public void setPrice(double Price) {
		this.price=Price;
	}
	
	public int compareTo(Product anotherProduct){
		int result=new Double(this.price).compareTo(new Double(anotherProduct.getPrice()));
		return result;
	}
	@Override
	public String toString(){
		return this.getPrice() + " " + this.getName();
	}
}
