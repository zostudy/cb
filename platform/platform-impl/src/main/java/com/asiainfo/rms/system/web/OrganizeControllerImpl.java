package com.asiainfo.rms.system.web;

import com.asiainfo.rms.system.dto.SysOrganizeDTO;
import com.asiainfo.rms.system.service.OrganizeService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Transactional
public class OrganizeControllerImpl implements OrganizeController {
    private final OrganizeService organizeService;

    public OrganizeControllerImpl(OrganizeService organizeService) {
        this.organizeService = organizeService;
    }

    @Override
    public String saveOrganize(@RequestBody SysOrganizeDTO organizeDTO) {
        return organizeService.saveOrganize(organizeDTO);
    }

    @Override
    public String updateOrganize(@PathVariable("organize_id")Integer organizeId, @RequestBody SysOrganizeDTO organizeDTO) {
        organizeDTO.setOrganizeId(organizeId);
        return organizeService.updateOrganize(organizeDTO);
    }

    @Override
    public String deleteByOrganizeId(@PathVariable("organize_id")Integer organizeId) {
        return organizeService.deleteByOrganizeId(organizeId);
    }

    @Override
    public SysOrganizeDTO selectByOrganizeId(@PathVariable("organize_id")Integer organizeId) {
        return organizeService.selectByOrganizeId(organizeId);
    }

//    @Override
//    public SysOrganizeDTO selectOrganizeByStaffId(@PathVariable("staff_id")Integer staffId) {
//        return organizeService.selectOrganizeByStaffId(staffId);
//    }

    @Override
    public List<SysOrganizeDTO> selectAllOrganize(@RequestParam(value = "code", required = false) String code,
                                                  @RequestParam(value = "organizeName", required = false) String organizeName,
                                                  @RequestParam(value ="state",required = false)Integer state) {
       return organizeService.selectAllOrganize(code,organizeName,state);

    }

    @Override
    public List<SysOrganizeDTO> selectOrganizeByParentId(@RequestParam(value = "parent_organize_id",required = false)Integer parentOrganizeId,
                                                         @RequestParam(value ="state",required = false)Integer state) {
        return organizeService.selectOrganizeByParentId(parentOrganizeId, state);
    }

    @Override
    public SysOrganizeDTO selectOrganizeInfo(@RequestParam("tier")Integer tire,
                                             @RequestParam(value = "organize_id",required = false)Integer organizeId,
                                             @RequestParam(value = "organize_code",required = false)String organizeCode,
                                             @RequestParam(value = "staff_id",required = false)Integer staffId,
                                             @RequestParam(value = "staff_code",required = false)String staffCode) {
        return organizeService.selectOrganizeInfo(tire,organizeId,  organizeCode, staffId, staffCode);
    }

}
