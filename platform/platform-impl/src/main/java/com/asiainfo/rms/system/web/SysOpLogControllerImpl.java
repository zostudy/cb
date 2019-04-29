package com.asiainfo.rms.system.web;

import com.asiainfo.rms.core.api.Page;
import com.asiainfo.rms.system.dto.SysOpLogDTO;
import com.asiainfo.rms.system.service.SysOpLogService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Transactional
public class SysOpLogControllerImpl implements SysOpLogController {
    private final SysOpLogService opLogService;

    public SysOpLogControllerImpl(SysOpLogService opLogService) {
        this.opLogService = opLogService;
    }

    @Override
    public String saveOpLog(@RequestBody SysOpLogDTO opLogDTO) {
        return opLogService.saveOpLog(opLogDTO);
    }

    @Override
    public Page<SysOpLogDTO> selectAllOpLog(@RequestParam(value = "op_type_id",required = false)Integer opTypeId,
                                            @RequestParam(value = "op_content",required = false)String opContent,
                                            @RequestParam(value = "keyword",required = false)String keyword,
                                            @RequestParam(value = "start_time",required = false)String startTime,
                                            @RequestParam(value = "end_time",required = false)String endTime,
                                            @RequestParam(value = "page_no") Integer pageNo,
                                            @RequestParam(value = "page_size") Integer pageSize) {
        Page<SysOpLogDTO> page = new Page<>();
        int cnt = opLogService.getOpTLogCount(opTypeId,opContent,keyword,startTime,endTime);
        if (cnt == 0) {
            return page;
        }
        List<SysOpLogDTO> items = opLogService.selectAllOpLog(opTypeId,opContent,keyword,startTime,endTime, pageNo, pageSize);
        if (CollectionUtils.isEmpty(items)) {
            return page;
        }
        page.setRowCount(cnt);
        page.generatePageCount(pageSize);
        page.setPageData(items);
        return page;
    }

    @Override
    public SysOpLogDTO selectByopLogId(@PathVariable("op_log_id") Integer opLogId) {
        return opLogService.selectByopLogId(opLogId);
    }
}
