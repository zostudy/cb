package com.asiainfo.rms.alm.demand.web;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.asiainfo.rms.alm.demand.dto.AlmReqtmpSimpleParamDTO;
import com.asiainfo.rms.alm.demand.dto.SimpleParamDTO;
import com.asiainfo.rms.alm.demand.dto.SimpleParamTypeDTO;
import com.asiainfo.rms.alm.demand.service.AlmReqtmpSimpleParamService;
import com.asiainfo.rms.core.api.Page;

@RestController
@Transactional
public class AlmReqtmpSimpleParamControllerImpl implements AlmReqtmpSimpleParamController {
    private final AlmReqtmpSimpleParamService almReqtmpSimpleParamService;

    public AlmReqtmpSimpleParamControllerImpl(AlmReqtmpSimpleParamService almReqtmpSimpleParamService) {
        this.almReqtmpSimpleParamService = almReqtmpSimpleParamService;
    }

    @Override
    public String saveAlmReqtmpSimpleParam(@RequestBody SimpleParamDTO simpleParamDTO) {
        return almReqtmpSimpleParamService.saveAlmReqtmpSimpleParam(simpleParamDTO);
    }

    @Override
    public String updateAlmReqtmpSimpleParam(@RequestBody SimpleParamDTO simpleParamDTO) {
        return almReqtmpSimpleParamService.updateAlmReqtmpSimpleParam(simpleParamDTO);
    }

    @Override
    public String deleteAlmReqtmpSimpleParam(@PathVariable("arsp_id")Integer arspId) {
        return almReqtmpSimpleParamService.deleteAlmReqtmpSimpleParam(arspId);
    }

    @Override
    public SimpleParamDTO selectAlmReqtmpSimpleParam(@PathVariable("arsp_id")Integer arspId) {
        return almReqtmpSimpleParamService.selectAlmReqtmpSimpleParam(arspId);
    }

    @Override
    public SimpleParamDTO selectSimpleParam(@PathVariable("art_id")Integer artId) {
        return almReqtmpSimpleParamService.selectSimpleParam(artId);
    }

    @Override
    public Page<AlmReqtmpSimpleParamDTO> selectAllAlmReqtmpSimpleParam(@RequestParam(value = "art_id")Integer artId,
    																	@RequestParam(value = "modify_type",required=false)Integer modifyType,
                                                                       @RequestParam(value = "page_no") Integer pageNo,
                                                                       @RequestParam(value = "page_size") Integer pageSize) {
        Page<AlmReqtmpSimpleParamDTO> page = new Page<>();
        int cnt = almReqtmpSimpleParamService.getAllAlmReqtmpSimpleParam(artId,modifyType);
        if (cnt == 0) {
            return page;
        }
        List<AlmReqtmpSimpleParamDTO> items = almReqtmpSimpleParamService.selectAllAlmReqtmpSimpleParam(artId,modifyType, pageNo, pageSize);
        if (CollectionUtils.isEmpty(items)) {
            return page;
        }
        page.setRowCount(cnt);
        page.generatePageCount(pageSize);
        page.setPageData(items);
        return page;
    }
    
    public SimpleParamTypeDTO getAllAlmReqtmpSimpleParamType(@PathVariable("art_id")Integer artId){
    	List<Integer> list =  almReqtmpSimpleParamService.getAllAlmReqtmpSimpleParamType(artId);
    	String types = "";
    	SimpleParamTypeDTO typesDTO = new SimpleParamTypeDTO();
    	if(list.isEmpty() || list.size()<=0){
    		typesDTO.setParamTypes(types);
    	}else{
	    	for(int i=0;i<list.size();i++){
	    		types+=list.get(i)+",";
	    	}
	    	if(!"".equals(types)){
	    		types=types.substring(0,types.length()-1);
	    	}
    		typesDTO.setParamTypes(types);
    	}
    	return typesDTO;
    }
}
