package com.asiainfo.rms.alm.arsenal.web;

import com.asiainfo.rms.alm.arsenal.dto.AlmAsnltmpLabelConfigDTO;
import com.asiainfo.rms.alm.arsenal.service.AlmAsnltmpLabelConfigService;
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
public class AlmAsnltmpLabelConfigControllerImpl implements AlmAsnltmpLabelConfigController {
    private final AlmAsnltmpLabelConfigService asnltmpLabelConfigService;

    public AlmAsnltmpLabelConfigControllerImpl(AlmAsnltmpLabelConfigService asnltmpLabelConfigService) {
        this.asnltmpLabelConfigService = asnltmpLabelConfigService;
    }

    @Override
    public String saveAlmAsnltmpLabelConfig(@RequestBody AlmAsnltmpLabelConfigDTO almAsnltmpLabelConfigDTO) {
        return asnltmpLabelConfigService.saveAlmAsnltmpLabelConfig(almAsnltmpLabelConfigDTO);
    }

    @Override
    public String updateAlmAsnltmpLabelConfig(@PathVariable("im_id")Integer lmId, @RequestBody AlmAsnltmpLabelConfigDTO almAsnltmpLabelConfigDTO) {
        almAsnltmpLabelConfigDTO.setLmId(lmId);
        return asnltmpLabelConfigService.updateAlmAsnltmpLabelConfig(almAsnltmpLabelConfigDTO);
    }

    @Override
    public String deleteAlmAsnltmpLabelConfig(@PathVariable("im_id")Integer lmId) {
        return asnltmpLabelConfigService.deleteAlmAsnltmpLabelConfig(lmId);
    }

    @Override
    public AlmAsnltmpLabelConfigDTO selectAlmAsnltmpLabelConfigById(@PathVariable("im_id")Integer lmId) {
        return asnltmpLabelConfigService.selectAlmAsnltmpLabelConfigById(lmId);
    }

    @Override
    public Page<AlmAsnltmpLabelConfigDTO> selectAllAlmAsnltmpLabelConfig(@RequestParam(value = "keyword",required = false)String keyword,
                                                                         @RequestParam(value = "page_no") Integer pageNo,
                                                                         @RequestParam(value = "page_size") Integer pageSize) {
        Page<AlmAsnltmpLabelConfigDTO> page = new Page<>();
        int cnt = asnltmpLabelConfigService.getAllAlmAsnltmpLabelConfigCount(keyword);
        if (cnt == 0) {
            return page;
        }
        List<AlmAsnltmpLabelConfigDTO> items = asnltmpLabelConfigService.selectAllAlmAsnltmpLabelConfig(keyword, pageNo, pageSize);
        if (CollectionUtils.isEmpty(items)) {
            return page;
        }
        page.setRowCount(cnt);
        page.generatePageCount(pageSize);
        page.setPageData(items);
        return page;
    }
}
