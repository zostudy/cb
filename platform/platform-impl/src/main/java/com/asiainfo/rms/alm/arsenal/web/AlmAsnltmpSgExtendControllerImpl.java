package com.asiainfo.rms.alm.arsenal.web;

import com.asiainfo.rms.alm.arsenal.dto.AlmAsnltmpSgExtendDTO;
import com.asiainfo.rms.alm.arsenal.service.AlmAsnltmpSgExtendService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Transactional
public class AlmAsnltmpSgExtendControllerImpl implements AlmAsnltmpSgExtendController {
    private final AlmAsnltmpSgExtendService almAsnltmpSgExtendService;

    public AlmAsnltmpSgExtendControllerImpl(AlmAsnltmpSgExtendService almAsnltmpSgExtendService) {
        this.almAsnltmpSgExtendService = almAsnltmpSgExtendService;
    }

//    @Override
//    public String saveAlmAsnltmpSgExtend(@RequestBody AlmAsnltmpSgExtendDTO almAsnltmpSgExtendDTO) {
//        return almAsnltmpSgExtendService.saveAlmAsnltmpSgExtend(almAsnltmpSgExtendDTO);
//    }
//
//    @Override
//    public String updateAlmAsnltmpSgExtend(@PathVariable("aas_id") Integer aasId, @RequestBody AlmAsnltmpSgExtendDTO almAsnltmpSgExtendDTO) {
//        almAsnltmpSgExtendDTO.setAasId(aasId);
//        return almAsnltmpSgExtendService.updateAlmAsnltmpSgExtend(almAsnltmpSgExtendDTO);
//    }

//    @Override
//    public String deleteAlmAsnltmpSgExtend(@PathVariable("aas_id")Integer aasId) {
//        return almAsnltmpSgExtendService.deleteAlmAsnltmpSgExtend(aasId);
//    }

    @Override
    public AlmAsnltmpSgExtendDTO selectAlmAsnltmpSgExtend(@PathVariable("aas_id")Integer aasId) {
        return almAsnltmpSgExtendService.selectAlmAsnltmpSgExtend(aasId);
    }

//    @Override
//    public Page<AlmAsnltmpSgExtendDTO> selectAllAlmAsnltmpSgExtend(@RequestParam("aat_id")Integer aatId,
//                                                                   @RequestParam("page_no")Integer pageNo,
//                                                                   @RequestParam("page_size")Integer pageSize) {
//        Page<AlmAsnltmpSgExtendDTO> page = new Page<>();
//        int cnt = almAsnltmpSgExtendService.getAllAllAlmAsnltmpSgExtend(aatId);
//        if (cnt == 0) {
//            return page;
//        }
//        List<AlmAsnltmpSgExtendDTO> items = almAsnltmpSgExtendService.selectAllAlmAsnltmpSgExtend(aatId, pageNo, pageSize);
//        if (CollectionUtils.isEmpty(items)) {
//            return page;
//        }
//        page.setRowCount(cnt);
//        page.generatePageCount(pageSize);
//        page.setPageData(items);
//        return page;
//    }
}
