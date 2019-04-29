package com.asiainfo.rms.system.web;

import com.asiainfo.rms.system.service.CreateFileService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@Transactional
public class CreateFileControllerImpl implements CreateFileController {
    private final CreateFileService createFileService;

    public CreateFileControllerImpl(CreateFileService createFileService) {
        this.createFileService = createFileService;
    }

    @Override
    public void downloadWord(@RequestParam("jsonStr") String jsonStr, @RequestParam("templateFileName") String templateFileName,
                             @RequestParam("tofileName") String tofileName, HttpServletResponse response) throws Exception {
        createFileService.downloadWord(jsonStr, templateFileName, tofileName, response);
    }

    @Override
    public void downloadPDF(@RequestParam("jsonStr") String jsonStr, @RequestParam("templateFileName") String templateFileName,
                            @RequestParam("tofileName") String tofileName, HttpServletResponse response) throws Exception {
        createFileService.downloadPDF(jsonStr, templateFileName, tofileName, response);
    }

    @Override
    public void downloadExcel(@RequestParam("jsonStr") String jsonStr, @RequestParam("templateFileName") String templateFileName,
                              @RequestParam("tofileName") String tofileName, HttpServletResponse response) throws Exception {
        createFileService.downloadExcel(jsonStr, templateFileName, tofileName, response);
    }
}
