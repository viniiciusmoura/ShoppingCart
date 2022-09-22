/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aula.set15.controller;

import aula.set15.entity.ItemVenda;
import aula.set15.entity.Produto;
import aula.set15.repository.ProdutosRepository;
import aula.set15.repository.VendasRepository;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Vinícius Moura
 */

@Transactional
@Controller
@RequestMapping("vendas")
public class VendasController {
    
    @Autowired
    ProdutosRepository repositoryProd;
    
    @Autowired
    VendasRepository repositoryVend;
    
    @Autowired
    private HttpSession session;
    
    @GetMapping("/carrinho")
    public String form(ItemVenda itemVenda){
        System.out.println("==>"+this.session.getAttribute("venda"));
        return "/carrinho/carrinho";
    }
    
    
    //método que recebe um item e adiciona ao carrinho (lista da venda)
    @PostMapping("/addcart")
    public String addcart(@RequestParam("idprod") Long id, @RequestParam("qtd") String qtd){
        ItemVenda iv = new ItemVenda();
        iv.setProduto(repositoryProd.produto(id));
        iv.setQtd(Integer.parseInt(qtd));
        repositoryVend.addProduct(iv);
        return "redirect:/produtos/list";
    }
    
}
