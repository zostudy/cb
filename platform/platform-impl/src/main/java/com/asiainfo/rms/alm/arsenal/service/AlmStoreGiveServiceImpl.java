package com.asiainfo.rms.alm.arsenal.service;

import com.asiainfo.rms.alm.arsenal.convert.AlmAsnltmpSgExtendConvert;
import com.asiainfo.rms.alm.arsenal.convert.AlmAsnltmpStoreGiveConvert;
import com.asiainfo.rms.alm.arsenal.dao.AlmAsnltmpSgExtendDao;
import com.asiainfo.rms.alm.arsenal.dao.AlmAsnltmpStoreGiveDao;
import com.asiainfo.rms.alm.arsenal.domain.AlmAsnltmpSgExtendRepository;
import com.asiainfo.rms.alm.arsenal.domain.AlmAsnltmpStoreGiveRepository;
import com.asiainfo.rms.alm.arsenal.dto.AlmAsnltmpSgExtendDTO;
import com.asiainfo.rms.alm.arsenal.dto.AlmAsnltmpStoreGiveDTO;
import com.asiainfo.rms.alm.arsenal.dto.AlmStoreGiveDTO;
import com.asiainfo.rms.core.exception.BusinessException;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class AlmStoreGiveServiceImpl implements AlmStoreGiveService {
    private final AlmAsnltmpSgExtendDao almAsnltmpSgExtendDao;
    private final AlmAsnltmpStoreGiveDao almAsnltmpStoreGiveDao;

    public AlmStoreGiveServiceImpl(AlmAsnltmpSgExtendDao almAsnltmpSgExtendDao, AlmAsnltmpStoreGiveDao almAsnltmpStoreGiveDao) {
        this.almAsnltmpSgExtendDao = almAsnltmpSgExtendDao;
        this.almAsnltmpStoreGiveDao = almAsnltmpStoreGiveDao;
    }

    @Override
    public String saveStoreGive(AlmStoreGiveDTO almStoreGiveDTO) {
        JSONObject json = new JSONObject();
        int count = 0;
        Integer aasId = 0;
        AlmAsnltmpSgExtendDTO sgExtendDTO = almStoreGiveDTO.getSgExtend();
        AlmAsnltmpStoreGiveDTO storeGiveDTO = almStoreGiveDTO.getStoreGive();

        if (storeGiveDTO != null) {
            AlmAsnltmpStoreGiveRepository almAsnltmpStoreGiveRepository;
            almAsnltmpStoreGiveRepository = AlmAsnltmpStoreGiveConvert.INSTANCE.toSYS(storeGiveDTO);
            almAsnltmpStoreGiveRepository.setCreateTime(new java.sql.Date(new java.util.Date().getTime()));
            almAsnltmpStoreGiveRepository.setOnlineState(0);
            almAsnltmpStoreGiveDao.saveAlmAsnltmpStoreGive(almAsnltmpStoreGiveRepository);
            count++;
            aasId = almAsnltmpStoreGiveRepository.getAasId();
        }

        if (sgExtendDTO != null) {
            AlmAsnltmpSgExtendRepository almAsnltmpSgExtendRepository;
            almAsnltmpSgExtendRepository = AlmAsnltmpSgExtendConvert.INSTANCE.toSYS(sgExtendDTO);
            almAsnltmpSgExtendRepository.setOnlineState(0);
            almAsnltmpSgExtendRepository.setAasId(aasId);
            almAsnltmpSgExtendDao.saveAlmAsnltmpSgExtend(almAsnltmpSgExtendRepository);
            count++;
        }

        if (count > 0) {
            try {
                json.put("code", 1);
                json.put("msg", "success");
                json.put("aas_id", aasId);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        return json.toString();
    }

    @Override
    public String updateStoreGive(AlmStoreGiveDTO almStoreGiveDTO) {
        JSONObject json = new JSONObject();
        int count = 0;
        AlmAsnltmpSgExtendDTO sgExtendDTO = almStoreGiveDTO.getSgExtend();
        AlmAsnltmpStoreGiveDTO storeGiveDTO = almStoreGiveDTO.getStoreGive();
        if (storeGiveDTO != null) {
            AlmAsnltmpStoreGiveRepository almAsnltmpStoreGiveRepository;
            almAsnltmpStoreGiveRepository = AlmAsnltmpStoreGiveConvert.INSTANCE.toSYS(storeGiveDTO);
            Integer aasId = almAsnltmpStoreGiveRepository.getAasId();
            Integer artType = almAsnltmpStoreGiveRepository.getArtType();
            Integer aatId = almAsnltmpStoreGiveRepository.getAatId();
            if (aasId != null && artType != null && aatId != null) {
                almAsnltmpStoreGiveDao.updateAlmAsnltmpStoreGive(almAsnltmpStoreGiveRepository);
                count++;
            } else {
                throw new BusinessException("数据有误，请修改后重新提交!");
            }

        }

        if (sgExtendDTO != null) {
            AlmAsnltmpSgExtendRepository almAsnltmpSgExtendRepository;
            almAsnltmpSgExtendRepository = AlmAsnltmpSgExtendConvert.INSTANCE.toSYS(sgExtendDTO);
            Integer aasId = almAsnltmpSgExtendRepository.getAasId();
            Integer artType = almAsnltmpSgExtendRepository.getArtType();
            Integer aatId = almAsnltmpSgExtendRepository.getAatId();
            if (aasId != null && artType != null && aatId != null) {
                almAsnltmpSgExtendDao.updateAlmAsnltmpSgExtend(almAsnltmpSgExtendRepository);
                count++;
            } else {
                throw new BusinessException("数据有误，请修改后重新提交!");
            }
        }
        if (count > 0) {
            try {
                json.put("code", 1);
                json.put("msg", "success!");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return json.toString();
    }

    @Override
    public AlmStoreGiveDTO selectStoreGive(Integer aatId) {
        AlmAsnltmpStoreGiveDTO storeDTO = AlmAsnltmpStoreGiveConvert.INSTANCE.toDTO(almAsnltmpStoreGiveDao.selectStoreGiveInfo(aatId));
        AlmAsnltmpSgExtendDTO sgExtendDTO = AlmAsnltmpSgExtendConvert.INSTANCE.toDTO(almAsnltmpSgExtendDao.selectSgExtendInfo(aatId));
        AlmStoreGiveDTO almStoreGiveDTO = new AlmStoreGiveDTO();
        if (storeDTO != null) almStoreGiveDTO.setStoreGive(storeDTO);
        if (sgExtendDTO != null) almStoreGiveDTO.setSgExtend(sgExtendDTO);
        return almStoreGiveDTO;
    }
}
