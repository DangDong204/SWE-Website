package com.haui.swe.controller.administrator;

import com.haui.swe.controller.BaseController;
import com.haui.swe.dto.SweContant;
import com.haui.swe.model.Category;
import com.haui.swe.model.Collection;
import com.haui.swe.model.Product;
import com.haui.swe.service.CategoryService;
import com.haui.swe.service.CollectionService;
import com.haui.swe.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/admin/product/")
public class ProductAdminController extends BaseController implements SweContant {

    @Autowired ProductService ps;
    @Autowired CategoryService cs;
    @Autowired CollectionService cls;

    @GetMapping("list")
    public String list(Model model) {
        List<Product> products = ps.findAll();
        model.addAttribute("products", products);

        List<Category> categories = cs.findAll();
        model.addAttribute("categories", categories);

        List<Collection> collections = cls.findAll();
        model.addAttribute("collections", collections);

        return "/administrator/product/product-list";
    }

    @PostMapping("add")
    public String add(Product product,
                      @RequestParam(value = "categoryId", required = false) Integer categoryId,
                      @RequestParam(value = "collectionId", required = false) Integer collectionId,
                      @RequestParam(value = "avatarFile", required = false) MultipartFile avatarFile)
            throws IOException {
        if (categoryId != null) {
            product.setCategory(cs.findById(categoryId));
        } else {
            product.setCategory(null);
        }

        if (collectionId != null) {
            product.setCollection(cls.findById(collectionId));
        } else {
            product.setCollection(null);
        }

        // Xử lý avatar
        if (avatarFile != null && !avatarFile.isEmpty()) {
            String folder = FOLDER_UPLOAD + "Product/Avatar/";
            String fileName = avatarFile.getOriginalFilename();
            File dest = new File(folder + fileName);
            avatarFile.transferTo(dest);
            product.setProductAvatar("UploadFiles/Product/Avatar/" + fileName);
        } else {
            product.setProductAvatar(null);
        }

        ps.saveOrUpdate(product);

        return "redirect:/admin/product/list";
    }


    @PostMapping("edit")
    public String edit(Product product,
                       @RequestParam("categoryId") int categoryId,
                       @RequestParam("collectionId") int collectionId,
                       @RequestParam(value = "avatarFile", required = false) MultipartFile avatarFile)
            throws IOException {

        Category category = cs.findById(categoryId);
        product.setCategory(category);

        Collection collection = cls.findById(collectionId);
        product.setCollection(collection);


        // Lấy sản phẩm cũ từ DB để giữ ảnh cũ nếu không upload mới
        Product oldProduct = ps.findById(product.getId());
        product.setProductAvatar(oldProduct.getProductAvatar()); // giữ avatar cũ mặc định
        product.setCreateDate(oldProduct.getCreateDate());

        // ==== Xử lý avatar mới ====
        if (avatarFile != null && !avatarFile.isEmpty()) {
            String avatarFolder = FOLDER_UPLOAD + "Product/Avatar/";
            String fileName = avatarFile.getOriginalFilename();
            File dest = new File(avatarFolder + fileName);
            avatarFile.transferTo(dest);
            product.setProductAvatar("UploadFiles/Product/Avatar/" + fileName);
        }
        ps.saveOrUpdate(product);
        return "redirect:/admin/product/list";
    }

    // Xóa - chuyển từ active -> inactive
    @GetMapping("delete/{productId}")
    public String delete(@PathVariable("productId") int productId) {
        Product product = ps.findById(productId);
        product.setStatus(false);
        ps.saveOrUpdate(product);
        return "redirect:/admin/product/list";
    }

}
