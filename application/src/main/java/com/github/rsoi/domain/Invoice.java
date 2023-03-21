package com.github.rsoi.domain;

import java.time.LocalDate;
import java.util.List;

public interface Invoice {
    String getType();
    List<Product> getProducts();
    LocalDate getDate();
}
