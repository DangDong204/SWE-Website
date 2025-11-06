package com.haui.swe.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tbl_category")
public class Category extends BaseModel{

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private Category parent;

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Category> children;

    @Column(name = "category_name", nullable = false, length = 300)
    private String categoryName;

    @Column(name = "category_desc", length = 500)
    private String categoryDesc;

    public Category() {
    }

    public Category(Integer id, Date createDate, Date updateDate, Boolean status,
                    Category parent, List<Category> children, String categoryName, String categoryDesc) {
        super(id, createDate, updateDate, status);
        this.parent = parent;
        this.children = children;
        this.categoryName = categoryName;
        this.categoryDesc = categoryDesc;
    }

    public Category getParent() {
        return parent;
    }

    public void setParent(Category parent) {
        this.parent = parent;
    }

    public List<Category> getChildren() {
        return children;
    }

    public void setChildren(List<Category> children) {
        this.children = children;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryDesc() {
        return categoryDesc;
    }

    public void setCategoryDesc(String categoryDesc) {
        this.categoryDesc = categoryDesc;
    }
}
