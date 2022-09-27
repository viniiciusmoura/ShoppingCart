/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aula.set15.controller;

import aula.set15.entity.ItemVenda;
import aula.set15.entity.Venda;
import aula.set15.repository.ProdutosRepository;
import aula.set15.repository.VendasRepository;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Vinícius Moura
 */

@Scope("request")
@Transactional
@Controller
@RequestMapping("vendas")
public class VendasController {
    
    @Autowired
    ProdutosRepository repositoryProd;
    
    @Autowired
    VendasRepository repositoryVend;
    
    @Autowired
    Venda venda;
    
    
    @GetMapping("/carrinho")
    public String form(){
        return "/vendas/carrinho";
    }
    
    
    //método que recebe um item e adiciona ao carrinho (lista da venda)
    @PostMapping("/addcart")
    public String addcart(@RequestParam("idprod") Long id, @RequestParam("qtd") String qtd){
        if(getItem(id)==null){
            ItemVenda iv = new ItemVenda();
            iv.setProduto(repositoryProd.produto(id));
            iv.setQtd(Integer.parseInt(qtd));
            venda.getItens().add(iv);
        }
        return "redirect:/produtos/list";
    }
    
    @GetMapping("/finalizarcompra")
    public String finalizarcompra(final HttpServletRequest request){
        
        repositoryVend.addVenda(venda);
        for(var i: venda.getItens()){
            i.setVenda(venda);
            repositoryVend.addItem(i);
        }
        request.getSession().invalidate();
        return "redirect:/produtos/list";
    }
    
    //retorna um item
    public ItemVenda getItem(Long id){
        for(ItemVenda v : venda.getItens()){
            if(v.getProduto().equals(repositoryProd.produto(id))){
                return v;
            }
        }
        return null;
    }
    
    @GetMapping(value="/remove/{id}")
    public String removeCart(@PathVariable("id") String id){
        venda.getItens().remove(getItem(Long.parseLong(id)));
        return "redirect:/vendas/carrinho";
    }
    

    @GetMapping("/addqtd/{id}")
    public String addQtd(@PathVariable("id") String id){
        venda.getItens().get(venda.getItens().indexOf(getItem(Long.parseLong(id)))).addQtd();
        return "redirect:/vendas/carrinho";
    }
    @GetMapping("/removeqtd/{id}")
    public String removeQtd(@PathVariable("id") String id){
        venda.getItens().get(venda.getItens().indexOf(getItem(Long.parseLong(id)))).removeQtd();
        return "redirect:/vendas/carrinho";
    }
    
    @GetMapping("/vendasrealiazadas")
    public ModelAndView vendasrealizadas(ModelMap model){
        model.addAttribute("vendas",repositoryVend.vendas());
        return new ModelAndView("/vendas/list");
    }
    
    
    
}
