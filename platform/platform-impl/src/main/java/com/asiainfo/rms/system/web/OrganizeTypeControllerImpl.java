package com.asiainfo.rms.system.web;

import com.asiainfo.rms.core.api.Page;
import com.asiainfo.rms.system.dto.SysOrganizeTypeDTO;
import com.asiainfo.rms.system.service.OrganizeTypeService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Transactional
public class OrganizeTypeControllerImpl implements OrganizeTypeController {
    private final OrganizeTypeService organizeTypeService;

    public OrganizeTypeControllerImpl(OrganizeTypeService organizeTypeService) {
        this.organizeTypeService = organizeTypeService;
    }

    @Override
    public String saveOrganizeType(@RequestBody SysOrganizeTypeDTO organizeTypeDTO) {
        return organizeTypeService.saveOrganizeType(organizeTypeDTO);
    }

    @Override
    public String updateOrganizeType(@PathVariable("organize_type_id")Integer organizeTypeId, @RequestBody SysOrganizeTypeDTO organizeTypeDTO) {
        organizeTypeDTO.setOrganizeTypeId(organizeTypeId);
        return organizeTypeService.updateOrganizeType(organizeTypeDTO);
    }

    @Override
    public String deleteOrganizeTypeById(@PathVariable("organize_type_id")Integer organizeTypeId) {
        return organizeTypeService.deleteOrganizeTypeById(organizeTypeId);
    }

    @Override
    public Page<SysOrganizeTypeDTO> selectOrganizeType(@RequestParam(value = "keyword", required = false)String keyword,
                                                       @RequestParam(value = "page_no") Integer pageNo,
                                                       @RequestParam(value = "page_size") Integer pageSize) {
        Page<SysOrganizeTypeDTO> page = new Page<>();
        int cnt = organizeTypeService.getOrganizeTypeCount(keyword);
        if (cnt == 0) {
            return page;
        }
        List<SysOrganizeTypeDTO> items = organizeTypeService.selectOrganizeType(keyword,pageNo, pageSize);
        if (CollectionUtils.isEmpty(items)) {
            return page;
        }
        page.setRowCount(cnt);
        page.generatePageCount(pageSize);
        page.setPageData(items);
        return page;
    }

//    @Override
//    public Page<SysOrganizeTypeDTO> selectOrganizeType(String keywork) {
//        return organizeTypeService.selectOrganizeType(keywork);
//    }
}
