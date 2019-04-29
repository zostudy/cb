package com.asiainfo.rms.system.web;

import com.asiainfo.rms.system.dto.SysOrganizeDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/system")
public interface OrganizeController {

    /**
     * 新增组织信息
     *
     * @param organizeDTO
     * @return
     */
    @RequestMapping(value = "/organize", method = RequestMethod.POST)
    String saveOrganize(@RequestBody SysOrganizeDTO organizeDTO);

    /**
     * 修改组织信息
     *
     * @param organizeId
     * @param organizeDTO
     * @return
     */
    @RequestMapping(value = "/organize/{organize_id}", method = RequestMethod.PUT)
    String updateOrganize(@PathVariable("organize_id") Integer organizeId, @RequestBody SysOrganizeDTO organizeDTO);

    /**
     * 删除组织信息
     *
     * @param organizeId
     * @return
     */
    @RequestMapping(value = "/organize/{organize_id}", method = RequestMethod.DELETE)
    String deleteByOrganizeId(@PathVariable("organize_id") Integer organizeId);

    /**
     * 根据organizeId查询组织信息
     *
     * @param organizeId
     * @return
     */
    @RequestMapping(value = "/organize/{organize_id}", method = RequestMethod.GET)
    SysOrganizeDTO selectByOrganizeId(@PathVariable("organize_id") Integer organizeId);

    /**
     * 查询所有组织信息
     * @param code
     * @param organizeName
     * @param state
     * @return
             */
    @RequestMapping(value ="/organize/all",method = RequestMethod.GET)
    List<SysOrganizeDTO> selectAllOrganize(@RequestParam(value = "code", required = false) String code,
                                           @RequestParam(value = "organizeName", required = false) String organizeName,
                                           @RequestParam(value ="state",required = false)Integer state);

    /**
     * 根据父节点查询下面的子节点
     * @param parentOrganizeId
     * @param state
     * @return
     */
    @RequestMapping(value="/organize/query",method = RequestMethod.GET)
    List<SysOrganizeDTO> selectOrganizeByParentId(@RequestParam(value = "parent_organize_id",required = false)Integer parentOrganizeId,
                                                  @RequestParam(value ="state",required = false)Integer state);
    /**
     * 根据组织id和层级结构查询组织信息
     * @param organizeId
     * @param tire
     * @param organizeCode
     * @param staffId
     * @param staffCode
     * @return
     */
    @RequestMapping(value="/organize/info",method = RequestMethod.GET)
    SysOrganizeDTO selectOrganizeInfo(@RequestParam("tier")Integer tire,
                                      @RequestParam(value = "organize_id",required = false)Integer organizeId,
                                      @RequestParam(value = "organize_code",required = false)String organizeCode,
                                      @RequestParam(value = "staff_id",required = false)Integer staffId,
                                      @RequestParam(value = "staff_code",required = false)String staffCode);
}
