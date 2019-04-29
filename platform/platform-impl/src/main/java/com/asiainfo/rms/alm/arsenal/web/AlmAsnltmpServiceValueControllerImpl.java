package com.asiainfo.rms.alm.arsenal.web;

import com.asiainfo.rms.alm.arsenal.dto.AlmServiceValueDTO;
import com.asiainfo.rms.alm.arsenal.service.AlmAsnltmpServiceValueService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Transactional
public class AlmAsnltmpServiceValueControllerImpl implements AlmAsnltmpServiceValueController {
    private final AlmAsnltmpServiceValueService almAsnltmpServiceValueService;

    public AlmAsnltmpServiceValueControllerImpl(AlmAsnltmpServiceValueService almAsnltmpServiceValueService) {
        this.almAsnltmpServiceValueService = almAsnltmpServiceValueService;
    }

    @Override
    public String saveAlmAsnltmpServiceValue(@RequestBody AlmServiceValueDTO almServiceValueDTO) {
        return almAsnltmpServiceValueService.saveAlmAsnltmpServiceValue(almServiceValueDTO);
    }

//    @Override
//    public String updateAlmAsnltmpServiceValue(@PathVariable("asv_id")Integer asvId,@RequestBody AlmAsnltmpServiceValueDTO almAsnltmpServiceValueDTO) {
//        almAsnltmpServiceValueDTO.setAsvId(asvId);
//        return almAsnltmpServiceValueService.updateAlmAsnltmpServiceValue(almAsnltmpServiceValueDTO);
//    }

    @Override
    public String deleteAlmAsnltmpServiceValue(@PathVariable("asv_id")Integer asvId) {
        return almAsnltmpServiceValueService.deleteAlmAsnltmpServiceValue(asvId);
    }

//    @Override
//    public AlmAsnltmpServiceValueDTO selectAlmAsnltmpServiceValue(@PathVariable("asv_id")Integer asvId) {
//        return almAsnltmpServiceValueService.selectAlmAsnltmpServiceValue(asvId);
//    }
//
//    @Override
//    public Page<AlmAsnltmpServiceValueDTO> selectAllAlmAsnltmpServiceValue(@RequestParam(value = "keyword",required = false)String keyword,
//                                                                           @RequestParam(value = "page_no") Integer pageNo,
//                                                                           @RequestParam(value = "page_size") Integer pageSize) {
//        Page<AlmAsnltmpServiceValueDTO> page = new Page<>();
//        int cnt = almAsnltmpServiceValueService.getAllAlmAsnltmpServiceValueCouont(keyword);
//        if (cnt == 0) {
//            return page;
//        }
//        List<AlmAsnltmpServiceValueDTO> items = almAsnltmpServiceValueService.selectAllAlmAsnltmpServiceValue(keyword, pageNo, pageSize);
//        if (CollectionUtils.isEmpty(items)) {
//            return page;
//        }
//        page.setRowCount(cnt);
//        page.generatePageCount(pageSize);
//        page.setPageData(items);
//        return page;
//    }
}
