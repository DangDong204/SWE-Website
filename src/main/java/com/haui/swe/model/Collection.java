package com.haui.swe.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tbl_collection")
public class Collection extends BaseModel{

    @Column(name = "collection_name", nullable = false, length = 300)
    private String collectionName;

    @Column(name = "collection_avatar", length = 300)
    private String collectionAvatar;

    @Column(name = "collection_desc", length = 500)
    private String collectionDesc;

   /* // ----------- Mapping one-to-many: collection-to-product ------------
    @OneToMany(mappedBy = "collection", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Product> products = new ArrayList<>();;*/

    public Collection() {
    }

    public Collection(Integer id, Date createDate, Date updateDate, Boolean status,
                      String collectionName, String collectionAvatar, String collectionDesc) {
        super(id, createDate, updateDate, status);
        this.collectionName = collectionName;
        this.collectionAvatar = collectionAvatar;
        this.collectionDesc = collectionDesc;
    }

    public String getCollectionName() {
        return collectionName;
    }

    public void setCollectionName(String collectionName) {
        this.collectionName = collectionName;
    }

    public String getCollectionAvatar() {
        return collectionAvatar;
    }

    public void setCollectionAvatar(String collectionAvatar) {
        this.collectionAvatar = collectionAvatar;
    }

    public String getCollectionDesc() {
        return collectionDesc;
    }

    public void setCollectionDesc(String collectionDesc) {
        this.collectionDesc = collectionDesc;
    }


}
