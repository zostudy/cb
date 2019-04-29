package com.asiainfo.rms.system.web;

import com.asiainfo.rms.core.api.Page;
import com.asiainfo.rms.system.dto.SysAuthorDTO;
import com.asiainfo.rms.system.dto.SysStaffOrgDTO;
import com.asiainfo.rms.system.service.AuthorService;

import lombok.extern.log4j.Log4j;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Log4j
@RestController
@Transactional
public class AuthorControllerImpl implements AuthorController {
    private final AuthorService authorService;

    public AuthorControllerImpl(AuthorService authorService) {
        this.authorService = authorService;
    }

    @Override
    public String saveAuthor(@RequestBody SysAuthorDTO authorDTO) {
        return authorService.saveAuthor(authorDTO);
    }

    @Override
    public String updateAuthor(@PathVariable("author_id") Integer authorId, @RequestBody SysAuthorDTO authorDTO) {
        authorDTO.setAuthorId(authorId);
        return authorService.updateAuthor(authorDTO);
    }

    @Override
    public String deleteAuthorById(@PathVariable("author_id")Integer authorId) {
        return authorService.deleteAuthorById(authorId);
    }

    @Override
    public SysAuthorDTO selectByAuthorId(@PathVariable("author_id")Integer authorId) {
        return authorService.selectByAuthorId(authorId);
    }

    @Override
    public List<SysAuthorDTO> selectByStationId(@PathVariable("station_id")Integer stationId) {
        return authorService.selectByStationId(stationId);
    }

    @Override
    public Page<SysAuthorDTO> selectAuthorByStaffId(@RequestParam(value = "staff_id")Integer StaffId,
                                                     @RequestParam(value = "page_no") Integer pageNo,
                                                     @RequestParam(value = "page_size") Integer pageSize) {
        Page<SysAuthorDTO> page = new Page<>();
        int cnt = authorService.getAuthorByStaffIdCount(StaffId);
        if (cnt == 0) {
            return page;
        }
        List<SysAuthorDTO> items = authorService.selectAuthorByStaffId(StaffId, pageNo, pageSize);
        if (CollectionUtils.isEmpty(items)) {
            return page;
        }
        page.setRowCount(cnt);
        page.generatePageCount(pageSize);
        page.setPageData(items);
        return page;
    }
    
    @Override
    public Map<String, Object> batchAdd(@RequestBody List<SysAuthorDTO> authorDTOs){
    	
    	 Map<String,Object> res = new HashMap<String,Object>();
         try{
        	 for(SysAuthorDTO sysAuthorDTO : authorDTOs){
         		List<SysAuthorDTO> curSysAuthors = authorService.selectByStationIdAndStaffId(sysAuthorDTO.getStationId(), sysAuthorDTO.getStaffId());
         		if(curSysAuthors != null){
         			for(SysAuthorDTO curSysAuthor : curSysAuthors){
         				authorService.deleteAuthorById(curSysAuthor.getAuthorId());
         			}
         		}
         		authorService.saveAuthor(sysAuthorDTO);
         	 }
         	
             res.put("code", "1");
             res.put("msg","");
             return res;
         }catch(Exception ex){
             ex.printStackTrace();
             log.error(ex.getMessage());
             res.put("code", "0");
             res.put("msg", ex.getMessage());
             return res;
         }
    	
    	
    }
    
    @Override
    public Map<String, Object> batchDel(@RequestBody List<SysAuthorDTO> authorDTOs){
    	
    	
    	
    	Map<String,Object> res = new HashMap<String,Object>();
        try{
        	for(SysAuthorDTO sysAuthorDTO : authorDTOs){
        		List<SysAuthorDTO> curSysAuthors = authorService.selectByStationIdAndStaffId(sysAuthorDTO.getStationId(), sysAuthorDTO.getStaffId());
        		if(curSysAuthors != null){
        			for(SysAuthorDTO curSysAuthor : curSysAuthors){
        				authorService.deleteAuthorById(curSysAuthor.getAuthorId());
        			}
        		}
        	}
        	
            res.put("code", "1");
            res.put("msg","");
            return res;
        }catch(Exception ex){
            ex.printStackTrace();
            log.error(ex.getMessage());
            res.put("code", "0");
            res.put("msg", ex.getMessage());
            return res;
        }
    	
    	
    }
}
