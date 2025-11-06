package com.haui.swe.model;

import jakarta.persistence.*;

import java.util.ArrayList;
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

    // ----------- Mapping one-to-many: collection-to-product ------------
    @OneToMany(mappedBy = "collection", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Product> products = new ArrayList<>();;
}
