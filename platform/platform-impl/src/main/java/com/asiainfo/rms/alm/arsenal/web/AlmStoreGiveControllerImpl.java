package com.asiainfo.rms.alm.arsenal.web;

import com.asiainfo.rms.alm.arsenal.dto.AlmStoreGiveDTO;
import com.asiainfo.rms.alm.arsenal.service.AlmStoreGiveService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Transactional
public class AlmStoreGiveControllerImpl implements AlmStoreGiveController {
    private final AlmStoreGiveService almStoreGiveService;

    public AlmStoreGiveControllerImpl(AlmStoreGiveService almStoreGiveService) {
        this.almStoreGiveService = almStoreGiveService;
    }

    @Override
    public String saveStoreGive(@RequestBody AlmStoreGiveDTO almStoreGiveDTO) {
        return almStoreGiveService.saveStoreGive(almStoreGiveDTO);
    }

    @Override
    public String updateStoreGive(@RequestBody AlmStoreGiveDTO almStoreGiveDTO) {
        return almStoreGiveService.updateStoreGive(almStoreGiveDTO);
    }

    @Override
    public AlmStoreGiveDTO selectStoreGive(@PathVariable("aat_id")Integer aatId) {
        return almStoreGiveService.selectStoreGive(aatId);

    }
}
