package com.asiainfo.rms.system.web;

import com.asiainfo.rms.system.dto.SysFunctionDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequestMapping("/system")
public interface FunctionController {
    /**
     * 新增功能菜单
     *
     * @param functionDTO
     * @return
     */
    @RequestMapping(value = "/function", method = RequestMethod.POST)
    String saveFunction(@RequestBody SysFunctionDTO functionDTO);

    /**
     * 修改菜单
     *
     * @param funcId
     * @param functionDTO
     * @return
     */
    @RequestMapping(value = "/function/{func_id}", method = RequestMethod.PUT)
    String updateFunction(@PathVariable("func_id") Integer funcId, @RequestBody SysFunctionDTO functionDTO);

    /**
     * 删除菜单
     *
     * @param funcId
     * @return
     */
    @RequestMapping(value = "/function/{func_id}", method = RequestMethod.DELETE)
    String deleteFunctionById(@PathVariable("func_id") Integer funcId);

    /**
     * 根据funcId查询菜单
     *
     * @param funcId
     * @return
     */
    @RequestMapping(value = "/function/{func_id}", method = RequestMethod.GET)
    SysFunctionDTO selectByFunctionId(@PathVariable("func_id") Integer funcId);

    /**
     * 查询所有菜单
     *
     * @param state
     * @return
     */
    @RequestMapping(value = "/functions", method = RequestMethod.GET)
    List<SysFunctionDTO> selectAllFunction(@RequestParam(value = "state", required = false) Integer state);

}
