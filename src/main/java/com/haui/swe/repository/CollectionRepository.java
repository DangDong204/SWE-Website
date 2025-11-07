package com.haui.swe.repository;

import com.haui.swe.model.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface CollectionRepository extends JpaRepository<Collection,Integer> {
}
