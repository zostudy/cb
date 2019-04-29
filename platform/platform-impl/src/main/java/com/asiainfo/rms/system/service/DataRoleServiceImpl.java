package com.asiainfo.rms.system.service;

import com.asiainfo.rms.system.convert.SysDataRoleConvert;
import com.asiainfo.rms.system.dao.SysDataRoleDao;
import com.asiainfo.rms.system.domain.SysDataRoleRepostitory;
import com.asiainfo.rms.system.dto.SysDataRoleDTO;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class DataRoleServiceImpl implements SysDataRoleService {
    private final SysDataRoleDao dataRoleDao;

    public DataRoleServiceImpl(SysDataRoleDao dataRoleDao) {
        this.dataRoleDao = dataRoleDao;
    }

    @Override
    public String saveSysDataRole(SysDataRoleDTO dataRoleDTO) {
        JSONObject json = new JSONObject();
        String code;
        SysDataRoleRepostitory dataRoleRepostitory;
        dataRoleRepostitory = SysDataRoleConvert.INSTANCE.toSYS(dataRoleDTO);

        List<SysDataRoleRepostitory> dataRoleList = dataRoleDao.selectAllCode();
        if (dataRoleList.size() == 0) {
            code = "DR" + String.format("%0" + 3 + "d", 1);
            dataRoleRepostitory.setCode(code);
        } else {
            Integer num = Integer.valueOf(dataRoleList.get(0).getCode().substring(2)) + 1;
            code = "DR" + String.format("%0" + 3 + "d", num);
        }
        dataRoleRepostitory.setCode(code);
        dataRoleRepostitory.setState(1);
        dataRoleRepostitory.setCreateDate(new java.sql.Date(new java.util.Date().getTime()));
        if (dataRoleDao.saveSysDataRole(dataRoleRepostitory) > 0) {
            try {
                json.put("code", 1);
                json.put("msg", "success");
                json.put("data_role_id", dataRoleRepostitory.getDataRoleId());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return json.toString();
    }

    @Override
    public String updateSysDataRole(SysDataRoleDTO dataRoleDTO) {
        JSONObject json = new JSONObject();
        SysDataRoleRepostitory dataRoleRepostitory = SysDataRoleConvert.INSTANCE.toSYS(dataRoleDTO);
        dataRoleRepostitory.setCreateDate(new java.sql.Date(new java.util.Date().getTime()));
        if (dataRoleDao.updateSysDataRole(dataRoleRepostitory) > 0) {
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
    public String deleteSysDataRoleById(Integer dataRoleId) {
        JSONObject json = new JSONObject();
        Integer count = dataRoleDao.deleteSysDataRoleById(dataRoleId);

        try {
            if (count > 0) {
                json.put("code", 1);
                json.put("msg", "success");
                json.put("row_count", count);
            } else {
                json.put("code", 0);
                json.put("msg", "fail");
                json.put("row_count", 0);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return json.toString();
    }

    @Override
    public List<SysDataRoleDTO> selectSysDataRole(String keyword,Integer organizeId, Integer pageNo, Integer pageSize) {
        Integer offset = null;
        if ((pageNo != null) && (pageSize != null)) {
            offset = pageNo;

        }
        List<SysDataRoleRepostitory> dataRoleList = dataRoleDao.selectSysDataRole(keyword,organizeId, offset, pageSize);
        if (dataRoleList.size() > 0) {
            return SysDataRoleConvert.INSTANCE.toDTOs(dataRoleList);
        } else {
            return null;
        }
    }

    @Override
    public Integer getSysDataRoleCount(String keyword,Integer organizeId) {
        return dataRoleDao.getSysDataRoleCount(keyword,organizeId);
    }

}
