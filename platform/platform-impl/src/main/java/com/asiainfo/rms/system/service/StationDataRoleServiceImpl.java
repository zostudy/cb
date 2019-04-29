package com.asiainfo.rms.system.service;

import com.asiainfo.rms.system.convert.SysStationDataRoleConvert;
import com.asiainfo.rms.system.dao.SysStationDataRoleDao;
import com.asiainfo.rms.system.domain.SysStationDataRoleRepository;
import com.asiainfo.rms.system.dto.SysStationDataRoleDTO;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Component
@Transactional
public class StationDataRoleServiceImpl implements SysStationDataRoleService {
    private final SysStationDataRoleDao stationDataRoleDao;

    public StationDataRoleServiceImpl(SysStationDataRoleDao stationDataRoleDao) {
        this.stationDataRoleDao = stationDataRoleDao;
    }

    @Override
    public String saveStationDataRole(SysStationDataRoleDTO stationDataRoleDTO) {
        JSONObject json = new JSONObject();
        SysStationDataRoleRepository stationDataRoleRepository;
        stationDataRoleRepository = SysStationDataRoleConvert.INSTANCE.toSYS(stationDataRoleDTO);
        //校验数据权限是否存在
        Integer opId = stationDataRoleRepository.getOpId();
        Integer dataRoleId = stationDataRoleRepository.getDataRoleId();
        Integer stationId = stationDataRoleRepository.getStationId();
        if((stationDataRoleDao.getOpIdAndRoleIdCount(opId,dataRoleId,stationId)) ==0){
        	stationDataRoleRepository.setState(1);
            if (stationDataRoleDao.saveStationDataRole(stationDataRoleRepository) > 0) {
                try {
                    json.put("code", 1);
                    json.put("msg", "success");
                    json.put("rel_id", stationDataRoleRepository.getRelId());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }else{
            try {
                json.put("code", 0);
                json.put("msg", "该权限数据已经存在，请重新选择！");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        return json.toString();

    }

    @Override
    public String deleteStationDataRole(Integer relId) {
        JSONObject json = new JSONObject();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-DD HH:mm:ss");
        Date endDate = new Date();
//		try {
//			endDate = simpleDateFormat.parse(new Date().toString());
//		} catch (ParseException e1) {
//			e1.printStackTrace();
//		}
        Integer count = stationDataRoleDao.deleteStationDataRole(0, endDate, relId);
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
    public List<SysStationDataRoleDTO> selectStationDataRoleByStationId(Integer stationId, String keyword, Integer pageNo, Integer pageSize) {
        Integer offset = null;
        if ((pageNo != null) && (pageSize != null)) {
            offset = pageNo;

        }
        List<SysStationDataRoleRepository> dataRoleList = stationDataRoleDao.selectStationDataRoleByStationId(stationId, keyword, offset, pageSize);
        if (dataRoleList.size() > 0) {
            return SysStationDataRoleConvert.INSTANCE.toDTOs(dataRoleList);
        } else {
            return null;
        }
    }

    @Override
    public Integer getStationDataRoleCount(Integer stationId, String keyword) {
        return stationDataRoleDao.getStationDataRoleCount(stationId, keyword);
    }
}
