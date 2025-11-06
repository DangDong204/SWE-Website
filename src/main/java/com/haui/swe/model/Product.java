package com.haui.swe.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "tbl_product")
public class Product extends BaseModel{

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "collection_id")
    private Collection collection;

    @Column(name = "product_name", nullable = false, length = 300)
    private String productName;

    @Column(name = "product_avatar", length = 300)
    private String productAvatar;

    @Column(name = "price", precision = 15, scale = 2)
    private BigDecimal price;

    @Column(name = "sale_price", precision = 15, scale = 2)
    private BigDecimal salePrice;

    @Column(name = "product_desc", length = 500)
    private String productDesc;

    @Column(name = "ishot")
    private Boolean isHot = false;

    public Product() {
    }

    public Product(Integer id, Date createDate, Date updateDate, Boolean status,
                   Category category, Collection collection, String productName,
                   String productAvatar, BigDecimal price, BigDecimal salePrice, String productDesc, Boolean isHot) {
        super(id, createDate, updateDate, status);
        this.category = category;
        this.collection = collection;
        this.productName = productName;
        this.productAvatar = productAvatar;
        this.price = price;
        this.salePrice = salePrice;
        this.productDesc = productDesc;
        this.isHot = isHot;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Collection getCollection() {
        return collection;
    }

    public void setCollection(Collection collection) {
        this.collection = collection;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductAvatar() {
        return productAvatar;
    }

    public void setProductAvatar(String productAvatar) {
        this.productAvatar = productAvatar;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(BigDecimal salePrice) {
        this.salePrice = salePrice;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public Boolean getIsHot() {
        return isHot;
    }

    public void setIsHot(Boolean isHot) {
        this.isHot = isHot;
    }
}
