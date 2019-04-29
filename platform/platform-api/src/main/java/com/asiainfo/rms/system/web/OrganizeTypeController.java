package com.asiainfo.rms.system.web;

import com.asiainfo.rms.core.api.Page;
import com.asiainfo.rms.system.dto.SysOrganizeTypeDTO;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/system")
public interface OrganizeTypeController {

    /**
     * 保存组织类型
     * @param organizeTypeDTO
     * @return
     */
    @RequestMapping(value="/organize_type",method = RequestMethod.POST)
    String saveOrganizeType(@RequestBody SysOrganizeTypeDTO organizeTypeDTO);

    /**
     * 修改组织类型
     * @param organizeTypeId
     * @param organizeTypeDTO
     * @return
     */
    @RequestMapping(value="/organize_type/{organize_type_id}",method = RequestMethod.PUT)
    String updateOrganizeType(@PathVariable("organize_type_id")Integer organizeTypeId, @RequestBody SysOrganizeTypeDTO organizeTypeDTO);

    /**
     * 删除组织类型
     * @param organizeTypeId
     * @return
     */
    @RequestMapping(value="/organize_type/{organize_type_id}",method = RequestMethod.DELETE)
    String deleteOrganizeTypeById(@PathVariable("organize_type_id")Integer organizeTypeId);


    @RequestMapping(value = "/organize_type/all",method = RequestMethod.GET)
    Page<SysOrganizeTypeDTO> selectOrganizeType(@RequestParam(value = "keyword", required = false)String keyword,
                                                @RequestParam(value = "page_no") Integer pageNo,
                                                @RequestParam(value = "page_size") Integer pageSize);
}
