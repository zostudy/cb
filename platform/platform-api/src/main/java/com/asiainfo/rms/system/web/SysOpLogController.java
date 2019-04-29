package com.asiainfo.rms.system.web;

import com.asiainfo.rms.core.api.Page;
import com.asiainfo.rms.system.dto.SysOpLogDTO;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/system")
public interface SysOpLogController {

    /**
     * 新增操作日志
     * @param opLogDTO
     */
    @RequestMapping(value="/op_log",method = RequestMethod.POST)
    String saveOpLog(@RequestBody SysOpLogDTO opLogDTO);

    /**
     * 查询所有操作日志
     * @param opTypeId
     * @param opContent
     * @param keyword
     * @param startTime
     * @param endTime
     * @param pageNo
     * @param pageSize
     * @return
     */
    @RequestMapping(value="/op_log/all",method = RequestMethod.GET)
    Page<SysOpLogDTO> selectAllOpLog(@RequestParam(value = "op_type_id",required = false)Integer opTypeId,
                                  @RequestParam(value = "op_content",required = false)String opContent,
                                  @RequestParam(value = "keyword",required = false)String keyword,
                                  @RequestParam(value = "start_time",required = false)String startTime,
                                  @RequestParam(value = "end_time",required = false)String endTime,
                                  @RequestParam(value = "page_no") Integer pageNo,
                                  @RequestParam(value = "page_size") Integer pageSize);

    /**
     * 根据ID查询操作日志
     * @param opLogId
     * @return
     */
    @RequestMapping(value="/op_log/{op_log_id}",method = RequestMethod.GET)
    SysOpLogDTO selectByopLogId(@PathVariable("opLogId")Integer opLogId);
}
