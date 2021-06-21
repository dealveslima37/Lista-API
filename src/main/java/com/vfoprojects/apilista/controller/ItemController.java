package com.vfoprojects.apilista.controller;

import java.util.List;

import javax.validation.Valid;

import com.vfoprojects.apilista.dto.ItemDTO;
import com.vfoprojects.apilista.dto.NewItemDTO;
import com.vfoprojects.apilista.model.Item;
import com.vfoprojects.apilista.service.ItemService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/itens")
public class ItemController {
    
    @Autowired
    private ItemService service;

    @ApiOperation(value="Cadastrar item")
    @PostMapping
    public ResponseEntity<Item> create(@Valid @RequestBody NewItemDTO dto){
        Item item = service.insert(dto);
        return new ResponseEntity<Item>(item, HttpStatus.CREATED);
    }

    @ApiOperation(value="Visualizar todos os itens")
    @GetMapping
    public ResponseEntity<List<ItemDTO>> read(){
        List<ItemDTO> itens = service.findAll();
        return new ResponseEntity<List<ItemDTO>>(itens, HttpStatus.OK);
    }

    @ApiOperation(value="Buscar item por id")
    @GetMapping("/{id}")
    public ResponseEntity<Item> readById(@PathVariable Long id){
        Item item = service.findById(id);
        return new ResponseEntity<Item>(item, HttpStatus.OK);
    }

    @ApiOperation(value="Atualizar item por id")
    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody Item item) {
        service.update(id, item);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @ApiOperation(value="Deletar item por id")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @ApiOperation(value="Deletar todos os itens da lista")
    @DeleteMapping
    public ResponseEntity<Void> deleteAll(){
        service.deleteAll();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
