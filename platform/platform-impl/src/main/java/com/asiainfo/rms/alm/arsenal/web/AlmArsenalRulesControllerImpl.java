package com.asiainfo.rms.alm.arsenal.web;

import com.asiainfo.rms.alm.arsenal.dto.AlmArsenalRulesDTO;
import com.asiainfo.rms.alm.arsenal.service.AlmArsenalRulesService;
import com.asiainfo.rms.core.api.Page;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Transactional
public class AlmArsenalRulesControllerImpl implements AlmArsenalRulesController{
    private final AlmArsenalRulesService almArsenalRulesService;

    public AlmArsenalRulesControllerImpl(AlmArsenalRulesService almArsenalRulesService) {
        this.almArsenalRulesService = almArsenalRulesService;
    }

    @Override
    public String saveAlmArsenalRules(@RequestBody AlmArsenalRulesDTO almArsenalRulesDTO) {
        return almArsenalRulesService.saveAlmArsenalRules(almArsenalRulesDTO);
    }

    @Override
    public String updateAlmArsenalRules(@PathVariable("ar_id")Integer arId, @RequestBody AlmArsenalRulesDTO almArsenalRulesDTO) {
        almArsenalRulesDTO.setArId(arId);
        return almArsenalRulesService.updateAlmArsenalRules(almArsenalRulesDTO);
    }

    @Override
    public String deleteAlmArsenalRules(@PathVariable("ar_id")Integer arId) {
        return almArsenalRulesService.deleteAlmArsenalRules(arId);
    }

    @Override
    public AlmArsenalRulesDTO selectArsenalRulesById(@PathVariable("ar_id")Integer arId) {
        return almArsenalRulesService.selectArsenalRulesById(arId);
    }

    @Override
    public Page<AlmArsenalRulesDTO> selectAllArsenalRules(@RequestParam(value = "keyword",required = false)String keyword,
                                                          @RequestParam(value = "page_no") Integer pageNo,
                                                          @RequestParam(value = "page_size") Integer pageSize) {
        Page<AlmArsenalRulesDTO> page = new Page<>();
        int cnt = almArsenalRulesService.getAllArsenalRules(keyword);
        if (cnt == 0) {
            return page;
        }
        List<AlmArsenalRulesDTO> items = almArsenalRulesService.selectAllArsenalRules(keyword, pageNo, pageSize);
        if (CollectionUtils.isEmpty(items)) {
            return page;
        }
        page.setRowCount(cnt);
        page.generatePageCount(pageSize);
        page.setPageData(items);
        return page;
    }
}
