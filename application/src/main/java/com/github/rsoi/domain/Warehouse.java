package com.github.rsoi.domain;

import java.util.ArrayList;
import java.util.List;

public class Warehouse {
    private List<InvoicePlus> pluses = new ArrayList<>();

    private List<InvoiceMinus> invoiceMinuses = new ArrayList<>();

    public List<InvoicePlus> getPluses() {
        return pluses;
    }

    public List<InvoiceMinus> getMinuses() {
        return invoiceMinuses;
    }

    public void addPluses(InvoicePlus plus){
        pluses.add(plus);
    }
    public void addMinuses(InvoiceMinus invoiceMinus){
        invoiceMinuses.add(invoiceMinus);
    }
    public void printWarehouse(){
        for(int i =0; i<pluses.size();i++){
            for(int j =0; j<pluses.get(i).getProducts().size();j++) {
                System.out.println(pluses.get(i).getProducts().get(j).getQuantity());
            }
        }
    }

    public void printWarehouseM(){
        for(int i = 0; i< invoiceMinuses.size(); i++){
            for(int j = 0; j< invoiceMinuses.get(i).getProducts().size(); j++) {
                System.out.println(invoiceMinuses.get(i).getProducts().get(j).getQuantity());
            }
        }
    }


}
