package com.ngoccp1234.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String code;
    private String url;
    private int status;
    @JsonFormat(pattern = "dd-MM-yyy HH:mm")
    private String createdAt;
    @JsonFormat(pattern = "dd-MM-yyy HH:mm")
    private String updatedAt;

    @JsonIgnore
    @OneToMany(mappedBy = "category")
    private List<Product> products;

    public Category() {
    }

    public Category(int id, String name, String code, String url, int status, String createdAt, String updatedAt, List<Product> products) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.url = url;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.products = products;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
