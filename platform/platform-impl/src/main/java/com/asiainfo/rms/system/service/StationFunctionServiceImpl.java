package com.asiainfo.rms.system.service;

import com.asiainfo.rms.core.exception.BusinessException;
import com.asiainfo.rms.system.convert.SysStationFuncConvert;
import com.asiainfo.rms.system.dao.SysStationFuncDao;
import com.asiainfo.rms.system.domain.SysStationFuncRepository;
import com.asiainfo.rms.system.dto.SysStationFuncDTO;
import com.asiainfo.rms.system.dto.SysStationFunctionDTO;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class StationFunctionServiceImpl implements StationFunctionService {
    private final SysStationFuncDao stationFuncDao;

    public StationFunctionServiceImpl(SysStationFuncDao stationFuncDao) {
        this.stationFuncDao = stationFuncDao;
    }

    @Override
    public String saveStationFunc(SysStationFunctionDTO sysStationFunctionDTO) {
        JSONObject json = new JSONObject();
        int i=0;
        for(SysStationFuncDTO stationFuncDTO : sysStationFunctionDTO.getFuncDTOS()){

            SysStationFuncRepository stationFuncRepository;
            stationFuncRepository = SysStationFuncConvert.INSTANCE.toSYS(stationFuncDTO);

            if(stationFuncRepository.getOperateType().equals("C")){
                //根据station_id清除掉所有数据
                Integer stationId = stationFuncRepository.getStationId();

                if(i==0){
                    stationFuncDao.deleteStationFuncByStationId(stationId);
                }

                stationFuncRepository.setState(1);
                stationFuncRepository.setChecked(1);

                stationFuncRepository.setCreateTime(new java.sql.Date(new java.util.Date().getTime()));
                if (stationFuncDao.saveStationFunc(stationFuncRepository) > 0) {
                    i++;
                }
            }else if(stationFuncDTO.getOperateType().equals("U")){
                if (stationFuncDao.updateStationFunc(SysStationFuncConvert.INSTANCE.toSYS(stationFuncDTO)) > 0) {
                    i++;
                }
            }else{
                throw new BusinessException("操作类型错误!");
            }
        }
        try {
            json.put("code", 1);
            json.put("msg", "success!");
            json.put("row_count",i);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return json.toString();
    }

//    @Override
//    public String updateStationFunc(SysStationFuncDTO stationFuncDTO) {
//        JSONObject json = new JSONObject();
//        if (stationFuncDao.updateStationFunc(SysStationFuncConvert.INSTANCE.toSYS(stationFuncDTO)) > 0) {
//            try {
//                json.put("code", 1);
//                json.put("msg", "success");
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }
//        }
//        return json.toString();
//    }
//
//    @Override
//    public String deleteStationFuncById(Integer stationFuncRelatId) {
//        JSONObject json = new JSONObject();
//
//        Integer count = stationFuncDao.deleteStationFuncById(stationFuncRelatId);
//        if (count > 0) {
//            try {
//                json.put("code", 1);
//                json.put("row_count", count);
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }
//        }
//        return json.toString();
//    }

    @Override
    public SysStationFuncDTO selectByStationFuncRelatId(Integer stationFuncRelatId) {
        return SysStationFuncConvert.INSTANCE.toDTO(stationFuncDao.selectByStationFuncRelatId(stationFuncRelatId));
    }

    @Override
    public SysStationFuncDTO selectStationFuncByStaffId(Integer staffId) {
        return SysStationFuncConvert.INSTANCE.toDTO(stationFuncDao.selectStationFuncByStaffId(staffId));
    }

    @Override
    public List<SysStationFuncDTO> selectStationFuncByStationId(Integer stationId) {
        return SysStationFuncConvert.INSTANCE.toDTOs(stationFuncDao.selectStationFuncByStationId(stationId));
    }
}
