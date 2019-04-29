package com.asiainfo.rms.system.service;

import com.asiainfo.rms.system.dto.SysOrganizeDTO;

import java.util.List;

public interface OrganizeService {
    String saveOrganize(SysOrganizeDTO organizeDTO);

    String updateOrganize(SysOrganizeDTO organizeDTO);

    String deleteByOrganizeId(Integer organizeId);

    SysOrganizeDTO selectByOrganizeId(Integer organizeId);

    List<SysOrganizeDTO> selectAllOrganize(String code, String organizeName,Integer state);

    List<SysOrganizeDTO> selectOrganizeByParentId(Integer parentOrganizeId,Integer state);

    SysOrganizeDTO selectOrganizeInfo(Integer tire,Integer organizeId,String organizeCode,Integer staffId,String staffCode);

}
