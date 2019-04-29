package com.asiainfo.rms.system.service;

import com.asiainfo.rms.system.convert.SysStaffOrgRelatConvert;
import com.asiainfo.rms.system.dao.SysStaffOrgRelatDao;
import com.asiainfo.rms.system.domain.SysStaffOrgRelatRepository;
import com.asiainfo.rms.system.dto.SysStaffOrgRelatDTO;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Component
@Transactional
public class StaffOrgRelatServiceImpl implements StaffOrgRelatService {
    private final SysStaffOrgRelatDao staffOrgRelatDao;

    public StaffOrgRelatServiceImpl(SysStaffOrgRelatDao staffOrgRelatDao) {
        this.staffOrgRelatDao = staffOrgRelatDao;
    }

    @Override
    public String saveStaffOrgRelat(SysStaffOrgRelatDTO staffOrgRelatDTO) {
        Map<String, Serializable> reqMap = new HashMap<>();
        JSONObject json = new JSONObject();
        SysStaffOrgRelatRepository staffOrgRelatRepository;
        staffOrgRelatRepository = SysStaffOrgRelatConvert.INSTANCE.toSYS(staffOrgRelatDTO);
        staffOrgRelatRepository.setCreateTime(new java.sql.Date(new java.util.Date().getTime()));
        staffOrgRelatRepository.setState(1);

        if (staffOrgRelatDao.saveStaffOrgRelat(staffOrgRelatRepository) > 0) {
            try {
                json.put("code", 1);
                json.put("msg", "success");
                json.put("staff_org_relat_id", staffOrgRelatRepository.getStaffOrgRelatId());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return json.toString();
    }
//
//    @Override
//    public String updateStaffOrgRelat(SysStaffOrgRelatDTO staffOrgRelatDTO) {
//        JSONObject json = new JSONObject();
//        if (staffOrgRelatDao.updateStaffOrgRelat(SysStaffOrgRelatConvert.INSTANCE.toSYS(staffOrgRelatDTO)) > 0) {
//            try {
//                json.put("code", 1);
//                json.put("msg", "修改成功！");
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }
//        }
//        return json.toString();
//    }

    @Override
    public String deleteStaffOrgRelatById(Integer staffOrgRelatId) {
        JSONObject json = new JSONObject();
        Integer count = staffOrgRelatDao.deleteStaffOrgRelat(staffOrgRelatId);
        if (count > 0) {
            try {
                json.put("code", 1);
                json.put("msg", "success");
                json.put("row_count", count);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return json.toString();
    }
//
//    @Override
//    public SysStaffOrgRelatDTO selectByStaffOrgRelatId(Integer staffOrgRelatId) {
//        return SysStaffOrgRelatConvert.INSTANCE.toDTO(staffOrgRelatDao.selectByStaffOrgRelatId(staffOrgRelatId));
//    }

    @Override
    public SysStaffOrgRelatDTO selectStaffOrgRelatByStaffId(Integer staffId) {
        return SysStaffOrgRelatConvert.INSTANCE.toDTO(staffOrgRelatDao.selectStaffOrgRelatByStaffId(staffId));
    }
}
