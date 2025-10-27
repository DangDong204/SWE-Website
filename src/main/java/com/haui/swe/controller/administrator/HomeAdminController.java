package com.haui.swe.controller.administrator;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeAdminController {

    @GetMapping("/admin/home")
    public String home() {
        return "administrator/index";
    }
}
