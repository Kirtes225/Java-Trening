package com.company.Wrappers;

import com.company.Product;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "products")
public class ProductListWrapper {

    private List<Product> products = new ArrayList<>();

    @XmlElement(name = "product")
    public List<Product> getProducts() {
        return products;
    }

    public void setPersons(List<Product> products) {
        this.products = products;
    }
}