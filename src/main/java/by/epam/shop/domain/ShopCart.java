package by.epam.shop.domain;

import java.util.HashMap;
import java.util.Map;

/**
 * Class describing the goods basket
 *
 * @author Maksim Shilvian
 */
public class ShopCart {

    /**
     * Variable for storage of a product and its quantity
     */
    private Map<Product, Integer> products = new HashMap<>();

    public Map<Product, Integer> getProducts() {
        return products;
    }

    /**
     * Adds product in basket of products
     *
     * @param product entity
     * @param count of product
     */
    public void addProduct(Product product, int count) {
        if(products.containsKey(product)){
            products.put(product, products.get(product) + count);
        } else {
            products.put(product, count);
        }
    }

    /**
     * Deletes product from basket of products
     *
     * @param product
     */
    public void removeProduct(Product product){
        products.remove(product);
    }

    /**
     * Cleans basket of products
     */
    public void cleanCart(){
        products.clear();
    }

    /**
     * Calculates full cost of cart
     *
     * @return int
     */
    public int getTotalCost(){
        int totalCost = 0;
        for(Map.Entry<Product, Integer> entry : products.entrySet()){
            int quantity = (int) entry.getValue();
            Product product = (Product) entry.getKey();
            totalCost = totalCost + (product.getPrice()*quantity);
        }
        return totalCost;
    }

    public int getQuantityProducts(){
        int quantity = 0;
        for(Map.Entry<Product, Integer> entry : products.entrySet()){
            quantity = quantity + (int) entry.getValue();
        }
        return quantity;
    }
}
