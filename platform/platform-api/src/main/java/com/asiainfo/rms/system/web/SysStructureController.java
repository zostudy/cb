package com.asiainfo.rms.system.web;

import com.asiainfo.rms.core.api.Page;
import com.asiainfo.rms.system.dto.SysStructureDTO;
import com.asiainfo.rms.system.dto.SysStructureDefDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/system")
public interface SysStructureController {

    /**
     * 新增分组
     * @param sysStructureDTO
     * @return
     */
    @RequestMapping(value = "/structure", method = RequestMethod.POST)
    String saveStructure(@RequestBody SysStructureDTO sysStructureDTO);

    /**
     * 修改分组
     * @param structureId
     * @param sysStructureDTO
     * @return
     */
    @RequestMapping(value = "/structure/{structure_id}", method = RequestMethod.PUT)
    String updateStructure(@PathVariable("structure_id")Integer structureId, @RequestBody SysStructureDTO sysStructureDTO);

    /**
     * 删除分组
     * @param structureId
     * @return
     */
    @RequestMapping(value = "/structure/{structure_id}", method = RequestMethod.DELETE)
    String deleteStructure(@PathVariable("structure_id")Integer structureId);

    /**
     * 查询分组
     * @param structureId
     * @return
     */
    @RequestMapping(value = "/structure/{structure_id}", method = RequestMethod.GET)
    SysStructureDTO selectByStructureId(@PathVariable("structure_id")Integer structureId);

    /**
     * 查询所有分组
     * @return
     */
    @RequestMapping(value = "/structure/all",method = RequestMethod.GET)
    List<SysStructureDefDTO> selectAllStructure();

    @RequestMapping(value="/structure/info",method = RequestMethod.GET)
    Page<SysStructureDefDTO> selectStructureByKeyword(@RequestParam(value = "keyword",required = false) String keyword,
                                                      @RequestParam(value = "structure_parent_id",required = false)Integer structureParentId,
                                                      @RequestParam(value = "page_no") Integer pageNo,
                                                      @RequestParam(value = "page_size") Integer pageSize);

}
