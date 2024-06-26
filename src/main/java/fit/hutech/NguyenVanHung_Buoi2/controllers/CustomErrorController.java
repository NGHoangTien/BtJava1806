package fit.hutech.NguyenVanHung_Buoi2.controllers;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CustomErrorController implements ErrorController {

    @GetMapping("/error")
    public String handleError() {
        // Xử lý logic tùy chỉnh để xử lý lỗi
        return "error"; // Giả sử bạn có một template error.html
    }


    public String getErrorPath() {
        return "/error";
    }
}
