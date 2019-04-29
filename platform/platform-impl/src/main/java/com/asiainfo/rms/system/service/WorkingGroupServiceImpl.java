package com.asiainfo.rms.system.service;

import com.asiainfo.rms.system.convert.SysWorkingGroupConvert;
import com.asiainfo.rms.system.dao.SysWorkingGroupDao;
import com.asiainfo.rms.system.domain.SysWorkingGroupRepository;
import com.asiainfo.rms.system.dto.SysWorkingGroupDTO;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class WorkingGroupServiceImpl implements WorkingGroupService {
    private final SysWorkingGroupDao workingGroupDao;

    public WorkingGroupServiceImpl(SysWorkingGroupDao workingGroupDao) {
        this.workingGroupDao = workingGroupDao;
    }

    @Override
    public String saveWorkingGroup(SysWorkingGroupDTO workingGroupDTO) {
        JSONObject json = new JSONObject();
        String code;
        SysWorkingGroupRepository workingGroupRepository;
        workingGroupRepository = SysWorkingGroupConvert.INSTANCE.toSYS(workingGroupDTO);
        workingGroupRepository.setState(1);
        workingGroupRepository.setCreateDate(new java.sql.Date(new java.util.Date().getTime()));
        List<SysWorkingGroupRepository> wgList = workingGroupDao.selectAllCode();
        if (wgList.size() == 0) {
            code = "WR" + String.format("%0" + 3 + "d", 1);
        } else {
            Integer num = Integer.valueOf(wgList.get(0).getCode().substring(2)) + 1;
            code = "WR" + String.format("%0" + 3 + "d", num);
        }
        workingGroupRepository.setCode(code);
        if (workingGroupDao.saveWorkingGroup(workingGroupRepository) > 0) {
            try {
                json.put("code", 1);
                json.put("msg", "success");
                json.put("work_group_id", workingGroupRepository.getWorkGroupId());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return json.toString();


    }

    @Override
    public String updateWorkingGroup(SysWorkingGroupDTO workingGroupDTO) {
        JSONObject json = new JSONObject();
        if (workingGroupDao.updateWorkingGroup(SysWorkingGroupConvert.INSTANCE.toSYS(workingGroupDTO)) > 0) {
            try {
                json.put("code", 1);
                json.put("msg", "success");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return json.toString();
    }

    @Override
    public String deleteWorkingGroupById(Integer workGroupId) {
        JSONObject json = new JSONObject();
        Integer count = workingGroupDao.deleteWorkingGroupById(workGroupId);
        if (count > 0) {
            try {
                json.put("code", 1);
                json.put("msg","success");
                json.put("row_count", count);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return json.toString();
    }

    @Override
    public List<SysWorkingGroupDTO> selectAllWorkingGroup(String workGroupName, Integer pageNo, Integer pageSize) {
        return SysWorkingGroupConvert.INSTANCE.toDTOs(workingGroupDao.selectAllWorkingGroup(workGroupName, pageNo, pageSize));
    }

    @Override
    public int getWorkingGroupCount(String workGroupName) {
        return workingGroupDao.getWorkingGroupCount(workGroupName);
    }
}
