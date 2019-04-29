package com.asiainfo.rms.alm.arsenal.web;

import com.asiainfo.rms.alm.arsenal.dto.AlmReqtmpConfigDTO;
import com.asiainfo.rms.alm.arsenal.service.AlmReqtmpConfigService;
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
public class AlmReqtmpConfigControllerImpl implements AlmReqtmpConfigController {
    private final AlmReqtmpConfigService almReqtmpConfigService;

    public AlmReqtmpConfigControllerImpl(AlmReqtmpConfigService almReqtmpConfigService) {
        this.almReqtmpConfigService = almReqtmpConfigService;
    }


    @Override
    public String saveAlmReqtmpConfig(@RequestBody AlmReqtmpConfigDTO almReqtmpConfigDTO) {
        return almReqtmpConfigService.saveAlmReqtmpConfig(almReqtmpConfigDTO);
    }

    @Override
    public String updateAlmReqtmpConfig(@PathVariable("id") Integer id, @RequestBody AlmReqtmpConfigDTO almReqtmpConfigDTO) {
        almReqtmpConfigDTO.setId(id);
        return almReqtmpConfigService.updateAlmReqtmpConfig(almReqtmpConfigDTO);
    }

    @Override
    public String deleteAlmReqtmpConfig(@PathVariable("id")Integer id) {
        return almReqtmpConfigService.deleteAlmReqtmpConfig(id);
    }

    @Override
    public AlmReqtmpConfigDTO selectAlmReqtmpConfig(@PathVariable("id")Integer id) {
        return almReqtmpConfigService.selectAlmReqtmpConfig(id);
    }

    @Override
    public Page<AlmReqtmpConfigDTO> selectAllAlmReqtmpConfig(@RequestParam(value = "keyword",required = false)String keyword,
                                                             @RequestParam(value = "page_no") Integer pageNo,
                                                             @RequestParam(value = "page_size") Integer pageSize) {
        Page<AlmReqtmpConfigDTO> page = new Page<>();
        int cnt = almReqtmpConfigService.getAllAlmReqtmpConfigCount(keyword);
        if (cnt == 0) {
            return page;
        }
        List<AlmReqtmpConfigDTO> items = almReqtmpConfigService.selectAllAlmReqtmpConfig(keyword, pageNo, pageSize);
        if (CollectionUtils.isEmpty(items)) {
            return page;
        }
        page.setRowCount(cnt);
        page.generatePageCount(pageSize);
        page.setPageData(items);
        return page;
    }
}
