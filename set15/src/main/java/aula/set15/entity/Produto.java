/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aula.set15.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Vinícius Moura
 */
@Entity
@Table(name="tb_produto")
public class Produto {
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Id
    private Long id;
    private String descricao;
    private double valor;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
