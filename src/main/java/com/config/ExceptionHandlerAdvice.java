package com.config;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@ControllerAdvice//控制器建言
public class ExceptionHandlerAdvice {

    //404页面跳转
    @ExceptionHandler(value = Exception.class)
    public ModelAndView exception(Exception ex, WebRequest request) {
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("errorMessage", ex.getMessage());
        return modelAndView;
    }

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        webDataBinder.setDisallowedFields("he");
        //把日期格式绑定为Date类型
        DateFormat dateFormat1 = new SimpleDateFormat("MMM d, YYYY");
        CustomDateEditor createDate = new CustomDateEditor(dateFormat1, true);
        DateFormat dateFormat2 = new SimpleDateFormat("MMM d, YYYY");
        CustomDateEditor modifyDate = new CustomDateEditor(dateFormat2, true);
        webDataBinder.registerCustomEditor(Date.class, "createTime", createDate);
        webDataBinder.registerCustomEditor(Date.class, "modifyTime", modifyDate);
    }

    @ModelAttribute
    public void addAttributes(Model model) {
        model.addAttribute("msg", "额外的信息");
    }
}
