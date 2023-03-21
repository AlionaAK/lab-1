package com.github.rsoi.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class InvoicePlus implements Invoice {
    private String type = "incoming";
    private ArrayList<Product> products = new ArrayList<>();
    private LocalDate date;

    public InvoicePlus(Product product, LocalDate date) {
        products.add(product);
        this.date = date;
    }

    public InvoicePlus() {
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

    public void printPlus(){
       //products.add(product);
        System.out.println(date);
        for(int i =0; i<products.size();i++){
            System.out.println(products.get(i).getName());
        }
    }



}
