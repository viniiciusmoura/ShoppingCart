/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aula.set15.entity;

import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * ${session.venda.lista}
 * @author Vinícius Moura
 */
@Entity
@Table(name="tb_venda")
@Scope("session")
@Component
public class Venda {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private Date data;
    
    @OneToMany(mappedBy="venda")
    private List<ItemVenda> itens;
    
    public double total(){
        //return itens.get(0).total();
        double soma=0;
        for(ItemVenda v: itens){
            soma+=v.total();
        }
        return soma;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public List<ItemVenda> getItens() {
        return itens;
    }

    public void setItens(List<ItemVenda> itens) {
        this.itens = itens;
    }
}
