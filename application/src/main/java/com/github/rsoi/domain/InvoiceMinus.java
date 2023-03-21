package com.github.rsoi.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class InvoiceMinus implements Invoice{
    private String type = "outgoing";
    private ArrayList<Product> products = new ArrayList<>();
    private LocalDate date;

    public InvoiceMinus(Product product, LocalDate date) {
        products.add(product);
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public List<Product> getProducts() {
        return products;
    }

    public LocalDate getDate() {
        return date;
    }
}
