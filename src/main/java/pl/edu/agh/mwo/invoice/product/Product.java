package pl.edu.agh.mwo.invoice.product;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

public abstract class Product implements Map<Product, Integer> {
    private final String name;

    private final BigDecimal price;

    private final BigDecimal taxPercent;

    protected Product(String name, BigDecimal price, BigDecimal tax) {
        if (name == null || name.equals("")){
            throw new IllegalArgumentException("Product name cannot be null.");
        }

//        if (price==null || price.compareTo(BigDecimal.valueOf(0))<0)  {
        if (price==null || price.compareTo(BigDecimal.ZERO) == -1)  {
            throw new IllegalArgumentException("Product price cannot be null or negative.");
        }

        this.name = name;
        this.price = price;
        this.taxPercent = tax;
    }

    public String getName() {
        return this.name;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public BigDecimal getTaxPercent() {
        return this.taxPercent;
    }

    public BigDecimal getPriceWithTax() {
        return (this.price).add(this.price.multiply(this.taxPercent));
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean containsKey(Object key) {
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        return false;
    }

    @Override
    public Integer get(Object key) {
        return null;
    }

    @Override
    public Integer put(Product key, Integer value) {
        return null;
    }

    @Override
    public Integer remove(Object key) {
        return null;
    }

    @Override
    public void putAll(Map<? extends Product, ? extends Integer> m) {

    }

    @Override
    public void clear() {

    }

    @Override
    public Set<Product> keySet() {
        return null;
    }

    @Override
    public Collection<Integer> values() {
        return null;
    }

    @Override
    public Set<Entry<Product, Integer>> entrySet() {
        return null;
    }
}
