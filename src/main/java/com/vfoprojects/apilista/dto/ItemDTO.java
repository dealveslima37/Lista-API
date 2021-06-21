package com.vfoprojects.apilista.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.vfoprojects.apilista.model.Item;

public class ItemDTO {

    private Long id;
    private String nome;
    private String quantidade;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate data;

    public ItemDTO(Item item) {
        id = item.getId();
        nome = item.getNome();
        quantidade = item.getQuantidade();
        data = LocalDate.now();
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getQuantidade() {
        return this.quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }

    public LocalDate getData() {
        return this.data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

}
