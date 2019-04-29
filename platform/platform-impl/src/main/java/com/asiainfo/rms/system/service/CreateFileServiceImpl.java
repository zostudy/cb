package com.asiainfo.rms.system.service;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.*;
import freemarker.template.Configuration;
import freemarker.template.Template;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

@Component
@Transactional
public class CreateFileServiceImpl implements CreateFileService {
    @Override
    public void downloadWord(String jsonStr, String templateFileName, String tofileName, HttpServletResponse response) throws Exception {
        Map<String,Object> paramMap = new HashMap<>();
        JSONObject json = JSONObject.fromObject(jsonStr);
//        Iterator it = json.keys();
//        while (it.hasNext()){
//            String key = it.next().toString();
//            paramMap.put(key,json.get(key));
//        }
        //json串遍历转map
        for(Object k : json.keySet()){
            Object v = json.get(k);
            if(v instanceof JSONArray){
                List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
                Iterator<JSONObject> it = ((JSONArray)v).iterator();
                while(it.hasNext()){
                    JSONObject json2 = it.next();
                    list.add(parseJSON2Map(json2.toString()));
                }
                paramMap.put(k.toString(), list);
            } else {
                paramMap.put(k.toString(), v);
            }
        }
        //Configuration用于读取ftl文件
        Configuration configuration = new Configuration();
        configuration.setDefaultEncoding("utf-8");
        configuration.setDirectoryForTemplateLoading(new File(System.getProperty("user.dir")));
        String dir = System.getProperty("user.dir")+"\\workflow\\workflow-impl\\src\\main\\java\\com\\asiainfo\\rms\\workflow\\web\\impl\\wordTemplate";
        configuration.setDirectoryForTemplateLoading(new File(dir));
        // 输出文档路径及名称
        String lastFileName=tofileName+Math.random()*10000+".docx";
        File outFile = new File(lastFileName);

        //以utf-8的编码读取ftl文件
        Template t =  configuration.getTemplate(templateFileName,"utf-8");
        Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile), "utf-8"),10240);
        t.process(paramMap, out);
        out.flush();
        out.close();

        String dataDirectory =System.getProperty("user.dir");
        Path file = Paths.get(dataDirectory, lastFileName);
        response.setContentType("application/x-gzip");
        try {
            response.addHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(tofileName+".doc", "UTF-8"));
            Files.copy(file, response.getOutputStream());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        outFile = new File(lastFileName);
        if (outFile.exists()) {
            outFile.delete();
        }
    }

    @Override
    public void downloadExcel(String jsonStr, String templateFileName, String tofileName, HttpServletResponse response) throws Exception {
        Map<String,Object> paramMap = new HashMap<>();
        JSONObject json = JSONObject.fromObject(jsonStr);
//        Iterator it = json.keys();
//        while (it.hasNext()){
//            String key = it.next().toString();
//            paramMap.put(key,json.get(key));
//        }
        //json串遍历转map
        for(Object k : json.keySet()){
            Object v = json.get(k);
            if(v instanceof JSONArray){
                List<Map<String, Object>> list = new ArrayList<>();
                Iterator<JSONObject> it = ((JSONArray)v).iterator();
                while(it.hasNext()){
                    JSONObject json2 = it.next();
                    list.add(parseJSON2Map(json2.toString()));
                }
                paramMap.put(k.toString(), list);
            } else {
                paramMap.put(k.toString(), v);
            }
        }

        Configuration configuration = new Configuration();
        configuration.setDefaultEncoding("utf-8");
        configuration.setDirectoryForTemplateLoading(new File(System.getProperty("user.dir")));
        String dir = System.getProperty("user.dir")+"\\workflow\\workflow-impl\\src\\main\\java\\com\\asiainfo\\rms\\workflow\\web\\impl\\excelTemplate";
        configuration.setDirectoryForTemplateLoading(new File(dir));
        // 输出文档路径及名称
        String lastFileName=tofileName+Math.random()*10000+".xlsx";
        File outFile = new File(lastFileName);

        //以utf-8的编码读取ftl文件
        Template t =  configuration.getTemplate(templateFileName,"utf-8");
        Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile), "UTF-8"),10240);
        t.process(paramMap, out);
        out.flush();
        out.close();

        String dataDirectory =System.getProperty("user.dir");
        Path file = Paths.get(dataDirectory, lastFileName);
//        response.setContentType("application/vnd.ms-excel");
        response.setContentType("application/x-msdownload");
        try {
            response.addHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(tofileName+".xlsx", "UTF-8"));
            Files.copy(file, response.getOutputStream());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        outFile = new File(lastFileName);
        if (outFile.exists()) {
            outFile.delete();
        }
    }

    @Override
    public void downloadPDF(String jsonStr, String templateFileName, String tofileName, HttpServletResponse response) throws Exception {
        // 模板路径
        String dir = System.getProperty("user.dir")+"\\workflow\\workflow-impl\\src\\main\\java\\com\\asiainfo\\rms\\workflow\\web\\impl\\pdfTemplate";

        String templatePath = dir+"\\"+templateFileName;
        // 生成的新文件路径
        String lastFileName=tofileName+Math.random()*10000+".pdf";
        PdfReader reader;
        FileOutputStream out;
        ByteArrayOutputStream bos;
        PdfStamper stamper;
        try {
            out = new FileOutputStream(lastFileName);// 输出流
            reader = new PdfReader(templatePath);// 读取pdf模板
            bos = new ByteArrayOutputStream();
            stamper = new PdfStamper(reader, bos);
            AcroFields form = stamper.getAcroFields();

            JSONObject json = JSONObject.fromObject(jsonStr);
            Iterator it = json.keys();
            while (it.hasNext()){
                String key = it.next().toString();
                form.setField(key, json.get(key).toString());
            }

            stamper.setFormFlattening(true);// 如果为false那么生成的PDF文件还能编辑，一定要设为true
            stamper.close();

            Document doc = new Document();
            PdfCopy copy = new PdfCopy(doc, out);
            doc.open();
            PdfImportedPage importPage = copy.getImportedPage(new PdfReader(bos.toByteArray()), 1);
            copy.addPage(importPage);
            doc.close();

        } catch (IOException e) {
            System.out.println(1);
        } catch (DocumentException e) {
            System.out.println(2);
        }

        String dataDirectory =System.getProperty("user.dir");
        Path file = Paths.get(dataDirectory, lastFileName);
        response.setContentType("application/x-gzip");
        try {
            response.addHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(tofileName+".pdf", "UTF-8"));
            Files.copy(file, response.getOutputStream());
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        File outFile = new File(lastFileName);
        if (outFile.exists()) {
            outFile.delete();
        }
    }



    public static Map<String, Object> parseJSON2Map(String jsonStr){
        Map<String, Object> map = new HashMap<String, Object>();
        JSONObject json = JSONObject.fromObject(jsonStr);
        for(Object k : json.keySet()){
            Object v = json.get(k);
            if(v instanceof JSONArray){
                List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
                Iterator<JSONObject> it = ((JSONArray)v).iterator();
                while(it.hasNext()){
                    JSONObject json2 = it.next();
                    list.add(parseJSON2Map(json2.toString()));
                }
                map.put(k.toString(), list);
            } else {
                map.put(k.toString(), v);
            }
        }
        return map;
    }
}
