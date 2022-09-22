/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aula.set15.repository;

import aula.set15.entity.Produto;
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
public class ProdutosRepository {
    @PersistenceContext
    private EntityManager em;
    
    public List<Produto> produtos(){
        Query query = em.createQuery("from Produto");
        return query.getResultList();
    }
    
    public Produto produto(Long id){
        return em.find(Produto.class, id);
    }
    
}
