package oops;

public class Product {
private int price;
public int getPrice() {
	return price;
}

public void setPrice(int price) {
	if(price>0) {
		this.price=price;
	}
	else {
		System.out.println("Invalid price");
	}
}
}
