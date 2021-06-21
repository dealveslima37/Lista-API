package com.vfoprojects.apilista.dto;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

public class NewItemDTO {

    @NotEmpty(message = "O campo nome é uma informação obrigatória")
    @Length(min = 2, message = "O campo nome deve conter no minimo 2 caracteres")
    private String nome;

    private String quantidade;

    public NewItemDTO() {

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

}
