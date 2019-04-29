package com.asiainfo.rms.alm.arsenal.web;

import com.asiainfo.rms.alm.arsenal.dto.AlmAsnltmpConfigDTO;
import com.asiainfo.rms.alm.arsenal.service.AlmAsnltmpConfigService;
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
public class AlmAsnltmpConfigControllerImpl implements AlmAsnltmpConfigController {
    private final AlmAsnltmpConfigService almAsnltmpConfigService;

    public AlmAsnltmpConfigControllerImpl(AlmAsnltmpConfigService almAsnltmpConfigService) {
        this.almAsnltmpConfigService = almAsnltmpConfigService;
    }

    @Override
    public String saveAlmAsnltmpConfig(@RequestBody AlmAsnltmpConfigDTO almAsnltmpConfigDTO) {
        return almAsnltmpConfigService.saveAlmAsnltmpConfig(almAsnltmpConfigDTO);
    }

    @Override
    public String updateAlmAsnltmpConfig(@PathVariable("aac_id")Integer aacId, @RequestBody AlmAsnltmpConfigDTO almAsnltmpConfigDTO) {
        almAsnltmpConfigDTO.setAacId(aacId);
        return almAsnltmpConfigService.updateAlmAsnltmpConfig(almAsnltmpConfigDTO);
    }

    @Override
    public String deleteAlmAsnltmpConfig(@PathVariable("aac_id")Integer aacId) {
        return almAsnltmpConfigService.deleteAlmAsnltmpConfig(aacId);
    }

    @Override
    public AlmAsnltmpConfigDTO selectAlmAsnltmpConfigById(@PathVariable("aac_id")Integer aacId) {
        return almAsnltmpConfigService.selectAlmAsnltmpConfigById(aacId);
    }

    @Override
    public Page<AlmAsnltmpConfigDTO> selectAllAlmAsnltmpConfig(@RequestParam(value = "keyword",required = false)String keyword,
                                                               @RequestParam(value = "page_no") Integer pageNo,
                                                               @RequestParam(value = "page_size") Integer pageSize) {
        Page<AlmAsnltmpConfigDTO> page = new Page<>();
        int cnt = almAsnltmpConfigService.getAllAlmAsnltmpConfigCount(keyword);
        if (cnt == 0) {
            return page;
        }
        List<AlmAsnltmpConfigDTO> items = almAsnltmpConfigService.selectAllAlmAsnltmpConfig(keyword, pageNo, pageSize);
        if (CollectionUtils.isEmpty(items)) {
            return page;
        }
        page.setRowCount(cnt);
        page.generatePageCount(pageSize);
        page.setPageData(items);
        return page;
    }
}
