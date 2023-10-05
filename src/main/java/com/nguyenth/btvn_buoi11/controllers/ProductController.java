package com.nguyenth.btvn_buoi11.controllers;

import com.nguyenth.btvn_buoi11.entities.Category;
import com.nguyenth.btvn_buoi11.entities.Product;
import com.nguyenth.btvn_buoi11.services.CategoryService;
import com.nguyenth.btvn_buoi11.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/hien-thi-tat-ca")
    public String index(@RequestParam(value = "page",defaultValue = "1")int currentPage, Model model){
        Page<Product> page = productService.findAll(currentPage - 1, 5);
        model.addAttribute("list", page.getContent());
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("totalPages", page.getTotalPages());
        return "index";
    }

    @GetMapping("/view-add")
    public String viewAdd(Model model){
        List<Category> categories = categoryService.findAll();
        model.addAttribute("categories", categories);
        model.addAttribute("product", new Product());

        return "add";
    }

    @PostMapping("/add")
    public String add(@Valid @ModelAttribute("product")Product product, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            List<Category> categories = categoryService.findAll();
            model.addAttribute("categories", categories);
            return "add";
        }

        productService.create(product);
        return "redirect:/product/hien-thi-tat-ca";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id")Long id){
        productService.remove(id);
        return "redirect:/product/hien-thi-tat-ca";
    }

    @GetMapping("/detail")
    public String detail(@RequestParam("id")Long id, Model model){
        Optional<Product> productOptional = productService.findById(id);
        if (productOptional.isEmpty()){
            return "redirect:/product/hien-thi-tat-ca";
        }
        model.addAttribute("product", productOptional.get());

        return "detail";
    }

    @GetMapping("/view-update")
    public String viewUpdate(@RequestParam("id")Long id, Model model) {
        Optional<Product> productOptional = productService.findById(id);
        if (productOptional.isEmpty()){
            return "redirect:/product/hien-thi-tat-ca";
        }
        List<Category> categories = categoryService.findAll();
        model.addAttribute("product", productOptional.get());
        model.addAttribute("categories", categories);
        return "update";
    }

    @PostMapping("/update")
    public String update(@Valid @ModelAttribute("product")Product product, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            List<Category> categories = categoryService.findAll();
            model.addAttribute("categories", categories);
            return "update";
        }

        productService.update(product);
        return "redirect:/product/hien-thi-tat-ca";
    }
}
