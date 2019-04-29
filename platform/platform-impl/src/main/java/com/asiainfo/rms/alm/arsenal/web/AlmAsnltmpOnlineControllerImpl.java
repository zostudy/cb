package com.asiainfo.rms.alm.arsenal.web;

import com.asiainfo.rms.alm.arsenal.dto.AlmAsnltmpOnlineDTO;
import com.asiainfo.rms.alm.arsenal.service.AlmAsnltmpOnlineService;
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
public class AlmAsnltmpOnlineControllerImpl implements AlmAsnltmpOnlineController {
    private final AlmAsnltmpOnlineService almAsnltmpOnlineService;

    public AlmAsnltmpOnlineControllerImpl(AlmAsnltmpOnlineService almAsnltmpOnlineService) {
        this.almAsnltmpOnlineService = almAsnltmpOnlineService;
    }

    @Override
    public String saveAlmAsnltmpOnline(@RequestBody AlmAsnltmpOnlineDTO almAsnltmpOnlineDTO) {
        return almAsnltmpOnlineService.saveAlmAsnltmpOnline(almAsnltmpOnlineDTO);
    }

    @Override
    public String updateAlmAsnltmpOnline(@PathVariable("aao_id")Integer aaoId, @RequestBody AlmAsnltmpOnlineDTO almAsnltmpOnlineDTO) {
        almAsnltmpOnlineDTO.setAaoId(aaoId);
        return almAsnltmpOnlineService.updateAlmAsnltmpOnline(almAsnltmpOnlineDTO);
    }

    @Override
    public String deleteAlmAsnltmpOnline(@PathVariable("aao_id")Integer aaoId) {
        return almAsnltmpOnlineService.deleteAlmAsnltmpOnline(aaoId);
    }

    @Override
    public AlmAsnltmpOnlineDTO selectAlmAsnltmpOnline(@PathVariable("aao_id")Integer aaoId) {
        return almAsnltmpOnlineService.selectAlmAsnltmpOnline(aaoId);
    }

    @Override
    public Page<AlmAsnltmpOnlineDTO> selectAllAlmAsnltmpOnline(@RequestParam(value = "keyword",required = false)String keyword,
                                                               @RequestParam(value = "page_no") Integer pageNo,
                                                               @RequestParam(value = "page_size") Integer pageSize) {
        Page<AlmAsnltmpOnlineDTO> page = new Page<>();
        int cnt = almAsnltmpOnlineService.getAllAlmAsnltmpOnlineCount(keyword);
        if (cnt == 0) {
            return page;
        }
        List<AlmAsnltmpOnlineDTO> items = almAsnltmpOnlineService.selectAllAlmAsnltmpOnline(keyword, pageNo, pageSize);
        if (CollectionUtils.isEmpty(items)) {
            return page;
        }
        page.setRowCount(cnt);
        page.generatePageCount(pageSize);
        page.setPageData(items);
        return page;
    }
}
