package com.asiainfo.rms.system.service;

import javax.servlet.http.HttpServletResponse;

public interface CreateFileService {
    void downloadWord(String jsonStr,String templateFileName,String tofileName,HttpServletResponse response) throws Exception;

    void downloadPDF(String jsonStr,String templateFileName,String tofileName, HttpServletResponse response) throws Exception;

    void downloadExcel(String jsonStr,String templateFileName,String tofileName,HttpServletResponse response) throws Exception;
}
