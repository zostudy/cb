package com.asiainfo.rms.system.service;

import com.asiainfo.rms.system.convert.SysStationWfRoleConvert;
import com.asiainfo.rms.system.dao.SysStationWfRoleDao;
import com.asiainfo.rms.system.domain.SysStationWfRoleRepository;
import com.asiainfo.rms.system.dto.SysStationWfRoleDTO;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class StationWfRoleServiceImpl implements SysStationWfRoleService {
    private final SysStationWfRoleDao stationWfRoleDao;

    public StationWfRoleServiceImpl(SysStationWfRoleDao stationWfRoleDao) {
        this.stationWfRoleDao = stationWfRoleDao;
    }

    @Override
    public String saveStationWfRole(SysStationWfRoleDTO stationWfRoleDTO) {
        JSONObject json = new JSONObject();
        SysStationWfRoleRepository stationWfRoleRepository;
        stationWfRoleRepository = SysStationWfRoleConvert.INSTANCE.toSYS(stationWfRoleDTO);
        stationWfRoleRepository.setCreateDate(new java.sql.Date(new java.util.Date().getTime()));
        if (stationWfRoleDao.saveStationWfRole(stationWfRoleRepository) > 0) {
            try {
                json.put("code", 1);
                json.put("msg", "success");
                json.put("rel_id", stationWfRoleRepository.getRelId());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return json.toString();

    }

    @Override
    public String deleteStationWfRole(Integer relId) {
        JSONObject json = new JSONObject();
        Integer count = stationWfRoleDao.deleteStationWfRole(relId);
        if (count > 0) {
            try {
                json.put("code", 1);
                json.put("row_count", count);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return json.toString();
    }

    @Override
    public List<SysStationWfRoleDTO> selectStationWfRoleByStationId(Integer stationId, String keyword, Integer pageNo, Integer pageSize) {
        Integer offset = null;
        if ((pageNo != null) && (pageSize != null)) {
            offset = pageNo;

        }
        List<SysStationWfRoleRepository> wfRoleList = stationWfRoleDao.selectStationWfRoleByStationId(stationId, keyword, offset, pageSize);
        if (wfRoleList.size() > 0) {
            return SysStationWfRoleConvert.INSTANCE.toDTOs(wfRoleList);
        } else {
            return null;
        }
    }

    @Override
    public Integer getStationWfRoleCount(Integer stationId, String keyword) {
        return stationWfRoleDao.getStationWfRoleCount(stationId, keyword);
    }
}
