/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aula.set15.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Vinícius Moura
 */
@Entity
@Table(name="tb_itemvenda")
public class ItemVenda {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private double qtd;
    

    @OneToOne
    @JoinColumn(name = "id_produto")
    private Produto produto;
    
    
    @ManyToOne
    @JoinColumn(name="id_venda")
    private Venda venda;
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getQtd() {
        return qtd;
    }

    public void setQtd(double qtd) {
        this.qtd = qtd;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    
    public double total(){
        return produto.getValor() * this.qtd;
    }
    
    public void addQtd(){
        this.qtd++;
    }
    public void removeQtd(){
        if(this.qtd!=1)
            this.qtd--;
    }
    
}
