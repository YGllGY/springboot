package com.ygl.controller;

import com.ygl.entity.Emp;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;


@Controller
@RequestMapping("/upload")
public class UploadController {

    @RequestMapping("/uploadImg")
    public String uploadImg(Emp emp,MultipartFile upload, HttpServletRequest request) throws IOException {
        String realPath = request.getSession().getServletContext().getRealPath("/img");
        String originalFilename = upload.getOriginalFilename();
        if(emp.getImage()!=null){
            if(originalFilename==""){
                request.setAttribute("emp",emp);
                return "forward:/emp/updateEmp";
            }
            request.getSession().setAttribute("image",originalFilename);
            request.setAttribute("emp",emp);
            upload.transferTo(new File(realPath+"/"+originalFilename));
            return "forward:/emp/updateEmp";
        }else {
            upload.transferTo(new File(realPath+"/"+originalFilename));
            request.getSession().setAttribute("image",originalFilename);
            request.setAttribute("emp",emp);
        }
        return "forward:/emp/addEmp";
    }
}
