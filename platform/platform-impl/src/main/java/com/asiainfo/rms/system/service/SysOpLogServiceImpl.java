package com.asiainfo.rms.system.service;

import com.asiainfo.rms.system.convert.SysOpLogConvert;
import com.asiainfo.rms.system.dao.SysOpLogDao;
import com.asiainfo.rms.system.domain.SysOpLogRepository;
import com.asiainfo.rms.system.dto.SysOpLogDTO;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class SysOpLogServiceImpl implements SysOpLogService {
    private final SysOpLogDao opLogDao;

    public SysOpLogServiceImpl(SysOpLogDao opLogDao) {
        this.opLogDao = opLogDao;
    }

    @Override
    public String saveOpLog(SysOpLogDTO opLogDTO) {
        JSONObject json = new JSONObject();
        SysOpLogRepository opLogRepository;
        opLogRepository = SysOpLogConvert.INSTANCE.toSYS(opLogDTO);
        opLogRepository.setOpDate(new java.sql.Date(new java.util.Date().getTime()));
        if(opLogDao.saveOpLog(opLogRepository)>0) {
            try {
                json.put("code", 1);
                json.put("msg", "success");
                json.put("op_log_id", opLogRepository.getOpLogId());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return json.toString();
    }

    @Override
    public List<SysOpLogDTO> selectAllOpLog(Integer opTypeId, String opContent, String keyword, String startTime, String endTime, Integer pageNo, Integer pageSize) {
        Integer offset = null;
        if ((pageNo != null) && (pageSize != null)) {
            offset = pageNo;

        }
        List<SysOpLogRepository> opLogList = opLogDao.selectAllOpLog(opTypeId, opContent,keyword,startTime, endTime, offset, pageSize);
        if (opLogList.size() > 0) {
            return SysOpLogConvert.INSTANCE.toDTOs(opLogList);
        } else {
            return null;
        }
    }

    @Override
    public Integer getOpTLogCount(Integer opTypeId, String opContent, String keyword, String startTime, String endTime) {
        return opLogDao.getOpTLogCount(opTypeId, opContent,keyword,startTime, endTime);
    }

    @Override
    public SysOpLogDTO selectByopLogId(Integer opLogId) {
        return SysOpLogConvert.INSTANCE.toDTO(opLogDao.selectByopLogId(opLogId));
    }
}
