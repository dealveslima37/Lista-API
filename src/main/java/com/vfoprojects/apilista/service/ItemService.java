package com.vfoprojects.apilista.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.vfoprojects.apilista.dto.ItemDTO;
import com.vfoprojects.apilista.dto.NewItemDTO;
import com.vfoprojects.apilista.model.Item;
import com.vfoprojects.apilista.repository.ItemRepository;
import com.vfoprojects.apilista.service.exceptions.DataIntegrityViolationException;
import com.vfoprojects.apilista.service.exceptions.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ItemService {
    
    @Autowired
    private ItemRepository repository;

    public Item insert(NewItemDTO dto){
        if(repository.findByNomeContainingIgnoreCase(dto.getNome()) != null){
            throw new DataIntegrityViolationException("Já existe um produto cadastrado com esse nome");
        }
        
        Item item = new Item(dto.getNome(), dto.getQuantidade());
        return repository.save(item);
    }

    public List<ItemDTO> findAll(){
        List<Item> itens = repository.findAll();
        return itens.stream().map(x -> new ItemDTO(x)).collect(Collectors.toList());
    }

    public Item findById(Long id){
        Optional<Item> item = repository.findById(id);
        return item.orElseThrow(() -> new EntityNotFoundException("Não existe item cadastrado com esse id"));
    }

    public void update(Long id, Item item){
        findById(id);
        item.setId(id);
        repository.save(item);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

    public void deleteAll(){
        repository.deleteAll();
    }

}
