import java.util.Arrays;

public class SearchTest {
  public static void main(String[] args) {
    Product[] products = {
        new Product(101, "Laptop", "Electronics"),
        new Product(205, "Shoes", "Footwear"),
        new Product(150, "Phone", "Electronics"),
        new Product(120, "T-Shirt", "Apparel"),
        new Product(310, "Headphones", "Electronics"),
        new Product(415, "Jacket", "Apparel"),
        new Product(220, "Sneakers", "Footwear"),
        new Product(330, "Smartwatch", "Electronics"),
        new Product(450, "Backpack", "Accessories"),
        new Product(500, "Sunglasses", "Accessories"),
        new Product(600, "Coffee Maker", "Home Appliances"),
        new Product(700, "Blender", "Home Appliances")

    };

    System.out.println("---- Linear Search ----");
    Product found1 = ProductSearch.linearSearch(products, 150);
    System.out.println(found1 != null ? found1 : "Product not found");


    Arrays.sort(products, (a, b) -> a.productId - b.productId);

    System.out.println("\n---- Binary Search ----");
    Product found2 = ProductSearch.binarySearch(products, 150);
    System.out.println(found2 != null ? found2 : "Product not found");
  }
}
