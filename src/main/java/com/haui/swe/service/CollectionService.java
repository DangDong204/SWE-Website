package com.haui.swe.service;

import com.haui.swe.model.Collection;
import com.haui.swe.repository.CollectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollectionService {

    @Autowired
    CollectionRepository collectionRepository;

    public List<Collection> findAll(){
        return collectionRepository.findAll();
    }

    public Collection findById(Integer id){
        return collectionRepository.findById(id).get();
    }

}
