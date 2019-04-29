package com.asiainfo.rms.system.service;

import com.asiainfo.rms.system.convert.SysStationConvert;
import com.asiainfo.rms.system.dao.SysStationDao;
import com.asiainfo.rms.system.domain.SysStationRepository;
import com.asiainfo.rms.system.dto.SysStationDTO;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class StationServiceImpl implements StationService {
    private final SysStationDao stationDao;

    public StationServiceImpl(SysStationDao stationDao) {
        this.stationDao = stationDao;
    }

    @Override
    public String saveStation(SysStationDTO stationDTO) {
        JSONObject json = new JSONObject();
        String code;
        SysStationRepository stationRepository;
        stationRepository = SysStationConvert.INSTANCE.toSYS(stationDTO);
        stationRepository.setState(1);

        List<SysStationRepository> stationList = stationDao.selectAllCode();
        if (stationList.size() == 0) {
            code = "S" + String.format("%0" + 3 + "d", 1);
        } else {
            Integer num = Integer.valueOf(stationList.get(0).getCode().substring(1)) + 1;
            code = "S" + String.format("%0" + 3 + "d", num);
        }
        stationRepository.setCode(code);
        if (stationDao.saveStation(stationRepository) > 0) {
            try {
                json.put("code", 1);
                json.put("msg", "success");
                json.put("station_id", stationRepository.getStationId());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return json.toString();
    }

    @Override
    public String updateStation(SysStationDTO stationDTO) {
        JSONObject json = new JSONObject();
        if (stationDao.updateStation(SysStationConvert.INSTANCE.toSYS(stationDTO)) > 0) {
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
    public String deleteStationById(Integer stationId) {
        JSONObject json = new JSONObject();
        Integer count = stationDao.deleteStationById(stationId);
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
    public SysStationDTO selectByStationId(Integer stationId) {
        return SysStationConvert.INSTANCE.toDTO(stationDao.selectByStationId(stationId));
    }

    @Override
    public List<SysStationDTO> selectAllStation(String keyWord,Integer selectedStaffId, Integer pageNo, Integer pageSize) {
        Integer offset = null;
        if ((pageNo != null) && (pageSize != null)) {
            offset = pageNo;

        }
        List<SysStationRepository> stationList = stationDao.selectAllStation(keyWord,selectedStaffId, offset, pageSize);
        if (stationList.size() > 0) {
            return SysStationConvert.INSTANCE.toDTOs(stationList);
        } else {
            return null;
        }
    }

    @Override
    public int getStationCount(String keyWord,Integer selectedStaffId) {
        return stationDao.getStationCount(keyWord,selectedStaffId);
    }
}
