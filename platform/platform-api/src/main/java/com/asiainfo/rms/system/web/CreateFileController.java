package com.asiainfo.rms.system.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;

@RequestMapping("/system")
public interface CreateFileController {

    @RequestMapping(value="/wordfile",method = RequestMethod.POST)
    void downloadWord(@RequestParam("jsonStr") String jsonStr, @RequestParam("templateFileName") String templateFileName,
                             @RequestParam("tofileName") String tofileName, HttpServletResponse response) throws Exception;


    @RequestMapping(value="/pdffile",method = RequestMethod.POST)
    void downloadPDF(@RequestParam("jsonStr") String jsonStr, @RequestParam("templateFileName") String templateFileName,
                            @RequestParam("tofileName") String tofileName, HttpServletResponse response) throws Exception;

    @RequestMapping(value="/excelfile",method = RequestMethod.POST)
    void downloadExcel(@RequestParam("jsonStr") String jsonStr, @RequestParam("templateFileName") String templateFileName,
                      @RequestParam("tofileName") String tofileName, HttpServletResponse response) throws Exception;



}