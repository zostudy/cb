package com.asiainfo.rms.alm.arsenal.web;

import com.asiainfo.rms.alm.arsenal.dto.AlmArsenalServiceDTO;
import com.asiainfo.rms.alm.arsenal.service.AlmArsenalServiceService;
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
public class AlmArsenalServiceControllerImpl implements AlmArsenalServiceController {
    private final AlmArsenalServiceService almArsenalServiceService;

    public AlmArsenalServiceControllerImpl(AlmArsenalServiceService almArsenalServiceService) {
        this.almArsenalServiceService = almArsenalServiceService;
    }

    @Override
    public String saveAlmArsenalService(@RequestBody AlmArsenalServiceDTO almArsenalServiceDTO) {
        return almArsenalServiceService.saveAlmArsenalService(almArsenalServiceDTO);
    }

    @Override
    public String updateAlmArsenalService(@PathVariable("as_id")Integer asId, @RequestBody AlmArsenalServiceDTO almArsenalServiceDTO) {
        almArsenalServiceDTO.setAsId(asId);
        return almArsenalServiceService.updateAlmArsenalService(almArsenalServiceDTO);
    }

    @Override
    public String deleteAlmArsenalService(@PathVariable("as_id")Integer asId) {
        return almArsenalServiceService.deleteAlmArsenalService(asId);
    }

    @Override
    public AlmArsenalServiceDTO selectAlmArsenalServiceById(@PathVariable("as_id")Integer asId) {
        return almArsenalServiceService.selectAlmArsenalServiceById(asId);
    }

    @Override
    public Page<AlmArsenalServiceDTO> selectAllAlmArsenalService(@RequestParam(value = "keyword",required = false)String keyword,
                                                                 @RequestParam(value = "page_no") Integer pageNo,
                                                                 @RequestParam(value = "page_size") Integer pageSize) {
        Page<AlmArsenalServiceDTO> page = new Page<>();
        int cnt = almArsenalServiceService.getAllAlmArsenalService(keyword);
        if (cnt == 0) {
            return page;
        }
        List<AlmArsenalServiceDTO> items = almArsenalServiceService.selectAllAlmArsenalService(keyword, pageNo, pageSize);
        if (CollectionUtils.isEmpty(items)) {
            return page;
        }
        page.setRowCount(cnt);
        page.generatePageCount(pageSize);
        page.setPageData(items);
        return page;
    }
}
