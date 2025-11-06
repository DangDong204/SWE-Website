package com.haui.swe.controller.administrator;

import com.haui.swe.controller.BaseController;
import com.haui.swe.model.Product;
import com.haui.swe.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin/product")
public class ProductAdminController extends BaseController {

    @Autowired ProductService ps;

    @GetMapping("/list")
    public String list(Model model) {
        List<Product> products = ps.findAll();
        model.addAttribute("products", products);

        return "/administrator/product/product-list";
    }
}
