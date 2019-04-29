package com.asiainfo.rms.system.web;


import com.asiainfo.rms.system.dto.SysFileAttachmentsDTO;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@RequestMapping("/sys/file")
public interface FileUpLoadController {

	@RequestMapping(value="/upload/attachments",method = RequestMethod.POST)
	String upLpadFileAttachments(@RequestParam("file") MultipartFile file);

	@RequestMapping(value="/upload/attachments/save",method = RequestMethod.POST)
	String saveFileAttachments(@RequestBody SysFileAttachmentsDTO sysFileAttachmentsDTO);

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    Map<String,Object> upLoadFile(@RequestParam("file") MultipartFile file ,
    				  @RequestParam(value = "obj_id", required = true) Long objId, 
    				  @RequestParam(value = "obj_type", required = true) Long objType,
    				  @RequestParam(value = "wo_id", required = false) Long woId, 
    				  @RequestParam(value = "att_type", required = true) String attType,
    				  @RequestParam(value = "submitter_tag", required = true) String submitterTag,
    				  @RequestParam(value = "submit_link", required = false) String submitLink);
//
//    @RequestMapping(value = "/download" , method = RequestMethod.GET)
//    void downLoadFile(HttpServletRequest request, HttpServletResponse response) throws IOException;
    
    @RequestMapping(value = "/selectAttachByCond", method = RequestMethod.GET)
    Map<String,Object> selectAttachByCond(@RequestParam(value = "obj_id", required = true) Long objId, 
    												@RequestParam(value = "obj_type", required = true) Long objType);
    @RequestMapping(value = "/checkAttachByCond", method = RequestMethod.GET)
    Map<String,Object> checkAttachByCond(@RequestParam(value = "obj_id", required = true) Long objId, 
    		 							  @RequestParam(value = "obj_type", required = true) Long objType, 
    		 							  @RequestParam(value = "wo_id", required = false) Long woId,
    		 							  @RequestParam(value = "submit_link", required = true) String submitLink, 
    		 							  @RequestParam(value = "coding_type", required = false) Long codingType, 
    		 							  @RequestParam(value = "sys_tag", required = false) String sysTag, 
    		 							  @RequestParam(value = "sub_sys_tag", required = false) String subSysTag);
    @RequestMapping(value = "/selectCheckRuleByCond", method = RequestMethod.GET)
    Map<String,Object> selectCheckRuleByCond(@RequestParam(value = "obj_type", required = true) Long objType, 
    										  @RequestParam(value = "submit_link", required = true) String submitLink, 
    										  @RequestParam(value = "coding_type", required = false) Long codingType, 
    										  @RequestParam(value = "sys_tag", required = false) String sysTag, 
    										  @RequestParam(value = "sub_sys_tag", required = false) String subSysTag);
    
    
    @RequestMapping(value = "/deleteAttach", method = RequestMethod.DELETE)
    Map<String,Object> deleteAttach(@RequestParam(value = "att_pack_id", required = true) Long attPackId);

}
