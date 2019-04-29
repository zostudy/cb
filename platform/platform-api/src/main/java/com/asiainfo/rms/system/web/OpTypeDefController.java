package com.asiainfo.rms.system.web;

import com.asiainfo.rms.core.api.Page;
import com.asiainfo.rms.system.dto.SysOpTypeDefDTO;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequestMapping("/system")
public interface OpTypeDefController {
    /**
     * 新增操作类型
     *
     * @param sysOpTypeDefDTO
     * @return
     */
    @RequestMapping(value = "/op_type_def", method = RequestMethod.POST)
    String saveOpTypeDef(@RequestBody SysOpTypeDefDTO sysOpTypeDefDTO);

    /**
     * 修改操作类型
     *
     * @param opTypeId
     * @param sysOpTypeDefDTO
     * @return
     */
    @RequestMapping(value = "op_type_def/{op_type_id}", method = RequestMethod.PUT)
    String updateOpTypeDef(@PathVariable("op_type_id") Integer opTypeId,
                        @RequestBody SysOpTypeDefDTO sysOpTypeDefDTO);

    /**
     * 删除操作类型
     *
     * @param opTypeId
     * @return
     */
    @RequestMapping(value = "op_type_def/{op_type_id}", method = RequestMethod.DELETE)
    String deleteOpTypeDefById(@PathVariable("op_type_id") Integer opTypeId);

    /**
     * 带分页查询所有操作类型
     *
     * @return
     */
    @RequestMapping(value = "op_type_def/all", method = RequestMethod.GET)
    Page<SysOpTypeDefDTO> selectAllOpType(@RequestParam(value = "code", required = false) String code,
                                          @RequestParam(value = "op_type_name", required = false) String opTypeName,
                                          @RequestParam(value = "page_no") Integer pageNo,
                                          @RequestParam(value = "page_size") Integer pageSize);
}
