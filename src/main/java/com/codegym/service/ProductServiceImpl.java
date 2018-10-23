package com.codegym.service;

import com.codegym.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductServiceImpl implements ProductService{
    private static Map<Integer,Product> products;
    private static int id = 0;
    static {
        products = new HashMap<>();
        products.put(id,new Product(id++,"IphoneX","New iphone of Apple inc","Phone","2017"));
        products.put(id,new Product(id++,"SamsungGalaxy","New galaxy seri of Samsung inc","Phone","2015"));
        products.put(id,new Product(id++,"Surface book","New laptop of Microsoft inc","Laptop","2016"));
        products.put(id,new Product(id++,"XiaoMi note 5","A product of chinese","Phone","2018"));
        products.put(id,new Product(id++,"Macbook pro","A new mac of Apple","Laptop","2016"));
        products.put(id,new Product(id++,"Blackberry q10","Old product of BlackBerry","Phone","2010"));
    }
    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(id++,product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void update(int id, String name, String des, String type, String date) {
        findById(id).setName(name);
        findById(id).setDescription(des);
        findById(id).setType(type);
        findById(id).setDateProduction(date);
    }
    @Override
    public void remove(int id) {
        products.remove(id);
    }

    public int getId(){return id;};

}
