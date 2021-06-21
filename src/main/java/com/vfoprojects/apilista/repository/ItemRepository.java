package com.vfoprojects.apilista.repository;

import com.vfoprojects.apilista.model.Item;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
    
    Item findByNomeContainingIgnoreCase(String nome);

}
