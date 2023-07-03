package pl.edu.agh.mwo.invoice;

import java.math.BigDecimal;
import java.util.Map;


import pl.edu.agh.mwo.invoice.product.Product;

public class Invoice {
    private Map<Product, Integer> products;

    public void addProduct(String product) {

    }

    public void addProduct(Product product, Integer quantity) {
        this.products.put(product, quantity);
        
        
    }

    public BigDecimal getSubtotal() {
        return null;
    }

    public BigDecimal getTax() {
        return null;
    }

    public BigDecimal getTotal() {
        return null;
    }

    public BigDecimal getNetTotal() {
        return null;
    }
}
