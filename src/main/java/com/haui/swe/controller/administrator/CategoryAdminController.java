package com.haui.swe.controller.administrator;

import com.haui.swe.controller.BaseController;
import com.haui.swe.model.Category;
import com.haui.swe.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/category/")
public class CategoryAdminController extends BaseController {

        @Autowired CategoryService cs;

        @GetMapping("list")
        public String list(Model model) {
            List<Category> categories = cs.findAllActive();
            model.addAttribute("categories", categories);
            return "administrator/category/category-list";
        }

        @PostMapping("add")
        public String add(Category category){
            cs.saveOrUpdate(category);
            return "redirect:/admin/category/list";
        }

        @PostMapping("edit")
        public String edit(@ModelAttribute Category category){
            // Lấy danh mục cũ từ DB để lưu ngày tạo
            Category oldCategory = cs.findById(category.getId());
            category.setCreateDate(oldCategory.getCreateDate());
            cs.saveOrUpdate(category);
            return "redirect:/admin/category/list";
        }

        @GetMapping("delete/{categoryId}")
        public String delete(@PathVariable("categoryId") int categoryId) {
            Category category = cs.findById(categoryId);
            category.setStatus(false);
            cs.saveOrUpdate(category);
            return "redirect:/admin/category/list";
        }
}
