package com.github.rsoi.service;

import com.github.rsoi.domain.InvoiceMinus;
import com.github.rsoi.domain.InvoicePlus;
import com.github.rsoi.domain.Product;
import com.github.rsoi.domain.Warehouse;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        int v=0, num=0, year=0,month=0,day=0;
        String  name;
        LocalDate date = LocalDate.now();
        Warehouse warehouse = new Warehouse();
        // Add products to the warehouse
        Scanner in = new Scanner(System.in);
        do {
            System.out.println("1. Plus");
            System.out.println("2. Minus");
            System.out.println("3. Check");
            System.out.println("4. Exit");
            v = in.nextInt();
            switch (v){
                case 1: {
                    in.nextLine();
                    System.out.println("Введите название товара");
                    name = in.nextLine();
                    System.out.println("Введите количество");
                    num = in.nextInt();
                    if(num<=0){
                        break;
                    }
                    System.out.println("Введите год прибытия приходной");
                    year = in.nextInt();
                    if(year<2015 || year>date.getYear()){
                        System.out.println("god nepravilni");
                        break;
                    }
                    System.out.println("Введите месяц прибытия приходной");
                    month = in.nextInt();
                    if(month<=0 || month>12){
                        System.out.println("mesyach nepravilni");
                        break;
                    }
                    System.out.println("Введите день прибытия приходной");
                    day = in.nextInt();
                    if(day<=0 || day>31 ){
                        System.out.println("den nepravilni");
                        break;
                    }
                    if( LocalDate.of(year, month, day).isAfter(date)){
                        System.out.println("Nope");
                        break;
                    }
                    System.out.println(name+ " "+ num);
                    Product mainproduct = new Product(name, num);
                    InvoicePlus plus = new InvoicePlus(mainproduct,LocalDate.of(year, month, day) );
                    warehouse.addPluses(plus);
                    break;
                }
                case 2: {
                     int count=0, count_minus=0;
                    in.nextLine();
                    System.out.println("Введите название товара");
                    name = in.nextLine();
                    System.out.println("Введите количество");
                    num = in.nextInt();
                    if(num<=0){
                        break;
                    }

                    Product mainproduct = new Product(name, num);

                    System.out.println("Введите год прибытия расходной");
                    year = in.nextInt();
                    if(year<2015 || year>date.getYear()){
                        System.out.println("god nepravilni");
                        break;
                    }
                    System.out.println("Введите месяц прибытия расходной");
                    month = in.nextInt();
                    if(month<=0 || month>12){
                        System.out.println("mesyach nepravilni");
                        break;
                    }
                    System.out.println("Введите день прибытия расходной");
                    day = in.nextInt();
                    if(day<=0 || day>31 ){
                        System.out.println("den nepravilni");
                        break;
                    }
                    if( LocalDate.of(year, month, day).isAfter(date)){
                        System.out.println("Nope ahah");
                        break;
                    }

                    //////////////////////////////////////
                    List<InvoicePlus> pluses = warehouse.getPluses();
                    for(InvoicePlus plus : pluses){
                        if(plus.getDate().isBefore(LocalDate.of(year, month, day)) || plus.getDate().isEqual(LocalDate.of(year, month, day))){
                            List<Product> products = plus.getProducts();
                            for(Product product: products){
                                if(name.equals(product.getName())){
                                    count = count + product.getQuantity();
                                }
                            }
                        }
                    }
                    if(warehouse.getMinuses().isEmpty()){
                        if(count>=num){
                            InvoiceMinus invoiceMinus = new InvoiceMinus(mainproduct,LocalDate.of(year, month, day));
                            warehouse.addMinuses(invoiceMinus);
                        }else {
                            System.out.println("Minus>plus");
                            break;
                        }
                    }

                    else{

                        List<InvoiceMinus> minuses = warehouse.getMinuses();
                        for(InvoiceMinus minus : minuses){
                            if(minus.getDate().isBefore(LocalDate.of(year, month, day)) || minus.getDate().isEqual(LocalDate.of(year, month, day))){
                                List<Product> products = minus.getProducts();
                                for(Product product: products){
                                    if(name.equals(product.getName())){
                                        count = count - product.getQuantity();
                                    }
                                }
                            }
                        }

                        count_minus = count_minus + num;
                        if(count>=count_minus){
                            InvoiceMinus invoiceMinus = new InvoiceMinus(mainproduct,LocalDate.of(year, month, day));
                            warehouse.addMinuses(invoiceMinus);
                        }else {
                            System.out.println("Minus>plus");
                            break;
                        }

                    }


                    break;
                }
                case 3: {
                    int count=0, count_minus=0;
                    in.nextLine();
                    System.out.println("Введите название товара");
                    name = in.nextLine();

                    System.out.println("Введите год");
                    year = in.nextInt();
                    if(year<2015 || year>date.getYear()){
                        System.out.println("god nepravilni");
                        break;
                    }
                    System.out.println("Введите месяц");
                    month = in.nextInt();
                    if(month<=0 || month>12){
                        System.out.println(" mesyach nepravilni");
                        break;
                    }
                    System.out.println("Введите день");
                    day = in.nextInt();
                    if(day<=0 || day>31 ){
                        System.out.println("den nepravilni");
                        break;
                    }
                    if( LocalDate.of(year, month, day).isAfter(date)){
                        System.out.println("Exit");
                        break;
                    }
                    List<InvoicePlus> pluses = warehouse.getPluses();
                    for(InvoicePlus plus : pluses){
                        if(plus.getDate().isBefore(LocalDate.of(year, month, day)) || plus.getDate().isEqual(LocalDate.of(year, month, day))){
                            List<Product> products = plus.getProducts();
                            for(Product product: products){
                                if(name.equals(product.getName())){
                                    count = count + product.getQuantity();
                                }
                            }
                        }
                    }
                    if(warehouse.getMinuses().isEmpty()){
                        System.out.println("Minusa nyama");
                    }else{
                        System.out.println("minus");
                        List<InvoiceMinus> minuses = warehouse.getMinuses();
                        for(InvoiceMinus minus : minuses){
                            if(minus.getDate().isBefore(LocalDate.of(year, month, day)) || minus.getDate().isEqual(LocalDate.of(year, month, day))){
                                List<Product> products = minus.getProducts();
                                for(Product product: products){
                                    if(name.equals(product.getName())){
                                        count = count - product.getQuantity();
                                    }
                                }
                            }
                        }
                    }
                    System.out.println("resultat ");
                    int res = count - count_minus;
                    System.out.println(res);
                    break;
                }
                default:
                    break;

            }

        } while (v > 0 && v < 4);

    }
}
