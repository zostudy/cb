package com.asiainfo.rms.system.service;

import com.asiainfo.rms.core.exception.BusinessException;
import com.asiainfo.rms.system.convert.SysStaffWorkingGroupConvert;
import com.asiainfo.rms.system.dao.SysStaffWorkingGroupDao;
import com.asiainfo.rms.system.domain.SysStaffWorkingGroupRepository;
import com.asiainfo.rms.system.dto.SysStaffWorkingGroupDTO;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class StaffWorkingGroupServiceImpl implements StaffWorkingGroupService {
    private final SysStaffWorkingGroupDao staffWorkingGroupDao;

    public StaffWorkingGroupServiceImpl(SysStaffWorkingGroupDao staffWorkingGroupDao) {
        this.staffWorkingGroupDao = staffWorkingGroupDao;
    }

    @Override
    public String saveStaffWorkingGroup(SysStaffWorkingGroupDTO staffWorkingGroupDTO) {
        JSONObject json = new JSONObject();
        SysStaffWorkingGroupRepository staffWorkingGroupRepository;
        staffWorkingGroupRepository = SysStaffWorkingGroupConvert.INSTANCE.toSYS(staffWorkingGroupDTO);

        //校验
        Integer staffId = staffWorkingGroupRepository.getStaffId();
        Integer workGroupId = staffWorkingGroupRepository.getWorkGroupId();
        if (staffWorkingGroupDao.getWorkGroupById(staffId, workGroupId) > 0) {
            throw new BusinessException("该用户已经存在工作组中！");
        } else {
            if (staffWorkingGroupDao.saveStaffWorkingGroup(staffWorkingGroupRepository) > 0) {
                try {
                    json.put("code", 1);
                    json.put("msg", "success!!!");
                    json.put("rel_id", staffWorkingGroupRepository.getRelId());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
        return json.toString();

    }

    @Override
    public String deleteStaffWorkingGroup(Integer relId) {
        JSONObject json = new JSONObject();
        Integer count = staffWorkingGroupDao.deleteStaffWorkingGroup(relId);
        if (count > 0) {
            try {
                json.put("code", 1);
                json.put("msg", "success!!!");
                json.put("row_count", count);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        return json.toString();

    }

    @Override
    public List<SysStaffWorkingGroupDTO> selectStaffWorkingGroup(Integer workGroupId, String keyword, Integer pageNo, Integer pageSize) {
        Integer offset = null;
        if ((pageNo != null) && (pageSize != null)) {
            offset = pageNo;

        }
        List<SysStaffWorkingGroupRepository> staffWorkingGroupList = staffWorkingGroupDao.selectStaffWorkingGroup(workGroupId, keyword, offset, pageSize);
        if (staffWorkingGroupList.size() > 0) {
            return SysStaffWorkingGroupConvert.INSTANCE.toDTOs(staffWorkingGroupList);
        } else {
            return null;
        }
    }

    @Override
    public Integer getStaffWorkingGroupCount(Integer workGroupId, String keyword) {
        return staffWorkingGroupDao.getStaffWorkingGroupCount(workGroupId, keyword);
    }

    @Override
    public List<SysStaffWorkingGroupDTO> selectStaffByWorkGroupId(Integer workGroupId, String keyword, Integer pageNo, Integer pageSize) {
        Integer offset = null;
        if ((pageNo != null) && (pageSize != null)) {
            offset = pageNo;

        }
        List<SysStaffWorkingGroupRepository> staffWorkingGroupList = staffWorkingGroupDao.selectStaffByWorkGroupId(workGroupId, keyword, offset, pageSize);
        if (staffWorkingGroupList.size() > 0) {
            return SysStaffWorkingGroupConvert.INSTANCE.toDTOs(staffWorkingGroupList);
        } else {
            return null;
        }
    }

    @Override
    public Integer getStaffByWorkGroupIdCount(Integer workGroupId, String keyword) {
        return staffWorkingGroupDao.getStaffByWorkGroupIdCount(workGroupId, keyword);
    }
}
