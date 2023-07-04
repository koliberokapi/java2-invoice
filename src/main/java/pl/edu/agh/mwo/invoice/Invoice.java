package pl.edu.agh.mwo.invoice;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;



import pl.edu.agh.mwo.invoice.product.Product;

public class Invoice {
    private Map<Product, Integer> products = new HashMap<>();


    public void addProduct(Product product) {
    addProduct(product,1);
    }



    public void addProduct(Product product, Integer quantity) {
        if (product == null ) {
            throw new IllegalArgumentException("Product cannot be null.");
        }

        if (quantity <= 0){
            throw new IllegalArgumentException("Product quantity cannot be null or negative.");
        }
        this.products.put(product, quantity);
    }


    public BigDecimal getSubtotal() {

        BigDecimal subtotal = BigDecimal.ZERO;

        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            Product product = entry.getKey();
            BigDecimal quantity = new BigDecimal(entry.getValue());
            BigDecimal price = product.getPrice();
            BigDecimal subAmount =  price.multiply(quantity);
            subtotal = subtotal.add(subAmount);
        }

        return subtotal;
    }

    public BigDecimal getTax() {

        BigDecimal tax = new BigDecimal(BigInteger.ZERO);
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            Product product = entry.getKey();
            BigDecimal quantity = new BigDecimal(entry.getValue());
            BigDecimal price = product.getPrice();
            BigDecimal taxPercent = product.getTaxPercent();
            BigDecimal taxAmount = price.multiply(quantity).multiply(taxPercent);
            tax = tax.add(taxAmount);
        }
        return tax;
    }

    public BigDecimal getTotal() {

        BigDecimal total = BigDecimal.ZERO;
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            Product product = entry.getKey();
            BigDecimal quantity = new BigDecimal(entry.getValue());
            BigDecimal priceWithTax = product.getPriceWithTax();
            BigDecimal amount = priceWithTax.multiply(quantity);
            total = amount.add(total);
        }

        return total;
    }

    public BigDecimal getNetTotal() {

        BigDecimal netTotal = BigDecimal.ZERO;
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            Product product = entry.getKey();
            BigDecimal quantity = new BigDecimal(entry.getValue());
            BigDecimal price = product.getPrice();
            BigDecimal netAmount = price.multiply(quantity);
            netTotal = netAmount.add(netTotal);
        }

        return netTotal;
    }
}
