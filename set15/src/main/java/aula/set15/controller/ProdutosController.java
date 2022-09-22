/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aula.set15.controller;

import aula.set15.entity.Produto;
import aula.set15.repository.ProdutosRepository;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Vinícius Moura
 */
@Transactional
@Controller
@RequestMapping("produtos")
public class ProdutosController {
    @Autowired
    ProdutosRepository repository;
    
    @GetMapping("/list")
    public ModelAndView list(ModelMap model){
        model.addAttribute("produtos", repository.produtos());
        return new ModelAndView("produtos/products", model);
    }
    
    
}
