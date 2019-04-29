package com.asiainfo.rms.system.web;

import com.asiainfo.rms.core.api.Page;
import com.asiainfo.rms.system.dto.SysStructureDTO;
import com.asiainfo.rms.system.dto.SysStructureDefDTO;
import com.asiainfo.rms.system.service.SysStructureService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Transactional
public class SysStructureControllerImpl implements SysStructureController {
    private SysStructureService sysStructureService;

    public SysStructureControllerImpl(SysStructureService sysStructureService) {
        this.sysStructureService = sysStructureService;
    }

    @Override
    public String saveStructure(@RequestBody SysStructureDTO sysStructureDTO) {
        return sysStructureService.saveStructure(sysStructureDTO);
    }

    @Override
    public String updateStructure(@PathVariable("structure_id")Integer structureId, @RequestBody SysStructureDTO sysStructureDTO) {
        return sysStructureService.updateStructure(structureId,sysStructureDTO);
    }

    @Override
    public String deleteStructure(@PathVariable("structure_id")Integer structureId) {
        return sysStructureService.deleteStructure(structureId);
    }

    @Override
    public SysStructureDTO selectByStructureId(@PathVariable("structure_id")Integer structureId) {
        return sysStructureService.selectByStructureId(structureId);
    }

    @Override
    public List<SysStructureDefDTO> selectAllStructure() {
        return sysStructureService.selectAllStructure();
    }

    @Override
    public Page<SysStructureDefDTO> selectStructureByKeyword(@RequestParam(value = "keyword",required = false) String keyword,
                                                             @RequestParam(value = "structure_parent_id",required = false)Integer structureParentId,
                                                             @RequestParam(value = "page_no") Integer pageNo,
                                                             @RequestParam(value = "page_size") Integer pageSize) {
        Page<SysStructureDefDTO> page = new Page<>();
        int cnt = sysStructureService.getStructureByKeywordCount(keyword,structureParentId);
        if (cnt == 0) {
            return page;
        }
        List<SysStructureDefDTO> items = sysStructureService.selectStructureByKeyword(keyword,structureParentId, pageNo, pageSize);
        if (CollectionUtils.isEmpty(items)) {
            return page;
        }
        page.setRowCount(cnt);
        page.generatePageCount(pageSize);
        page.setPageData(items);
        return page;
    }
}
