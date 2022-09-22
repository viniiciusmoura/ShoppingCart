/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aula.set15.repository;

import aula.set15.entity.ItemVenda;
import aula.set15.entity.Produto;
import aula.set15.entity.Venda;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Vinícius Moura
 */

@Repository
public class VendasRepository {
    @PersistenceContext
    private EntityManager em;
    
    
    public List<Venda> vendas(){
        Query query = em.createQuery("from Venda");
        return query.getResultList();
    }
    
    public void addProduct(ItemVenda itemVenda){
        em.persist(itemVenda);
    }
    
    
}
