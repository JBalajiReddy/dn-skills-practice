public class ProductSearch {

  // Linear Search
  public static Product linearSearch(Product[] products, int targetId) {
    for (Product product : products) {
      if (product.productId == targetId) {
        return product;
      }
    }
    return null;
  }

  // Binary Search (Assumes products are sorted by productId)
  public static Product binarySearch(Product[] products, int targetId) {
    int left = 0, right = products.length - 1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (products[mid].productId == targetId)
        return products[mid];
      else if (products[mid].productId < targetId)
        left = mid + 1;
      else
        right = mid - 1;
    }
    return null;
  }
}
