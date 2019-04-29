package com.asiainfo.rms.alm.arsenal.service;

import com.asiainfo.rms.alm.arsenal.convert.AlmAsnltmpServiceValueConvert;
import com.asiainfo.rms.alm.arsenal.dao.AlmAsnltmpServiceValueDao;
import com.asiainfo.rms.alm.arsenal.domain.AlmAsnltmpServiceValueRepository;
import com.asiainfo.rms.alm.arsenal.dto.AlmAsnltmpServiceValueDTO;
import com.asiainfo.rms.alm.arsenal.dto.AlmServiceValueDTO;
import com.asiainfo.rms.core.exception.BusinessException;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class AlmAsnltmpServiceValueServiceImpl implements AlmAsnltmpServiceValueService {
    private final AlmAsnltmpServiceValueDao almAsnltmpServiceValueDao;

    public AlmAsnltmpServiceValueServiceImpl(AlmAsnltmpServiceValueDao almAsnltmpServiceValueDao) {
        this.almAsnltmpServiceValueDao = almAsnltmpServiceValueDao;
    }

    @Override
    public String saveAlmAsnltmpServiceValue(AlmServiceValueDTO almServiceValueDTO) {
        JSONObject json = new JSONObject();
        int count = 0;
        List<AlmAsnltmpServiceValueDTO> serviceValuelist = almServiceValueDTO.getServiceValueDTOS();
        if (serviceValuelist.size() > 0) {
            for (AlmAsnltmpServiceValueDTO serviceValueDTO : serviceValuelist) {
                AlmAsnltmpServiceValueRepository almAsnltmpServiceValueRepository;
                almAsnltmpServiceValueRepository = AlmAsnltmpServiceValueConvert.INSTANCE.toSYS(serviceValueDTO);
                switch (almAsnltmpServiceValueRepository.getOperateType()) {
                    case "C":
                        almAsnltmpServiceValueDao.saveAlmAsnltmpServiceValue(almAsnltmpServiceValueRepository);
                        count++;
                        break;
                    case "U":
                        almAsnltmpServiceValueDao.updateAlmAsnltmpServiceValue(almAsnltmpServiceValueRepository);
                        count++;
                        break;
                    default:
                        throw new BusinessException("");
                }
            }
        }
        try {
            json.put("code", 1);
            json.put("msg", "success!!!!");
            json.put("row_count", count);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return json.toString();
    }

//    @Override
//    public String updateAlmAsnltmpServiceValue(AlmAsnltmpServiceValueDTO almAsnltmpServiceValueDTO) {
//        JSONObject json = new JSONObject();
//        AlmAsnltmpServiceValueRepository almAsnltmpServiceValueRepository;
//        almAsnltmpServiceValueRepository = AlmAsnltmpServiceValueConvert.INSTANCE.toSYS(almAsnltmpServiceValueDTO);
//        if (almAsnltmpServiceValueDao.updateAlmAsnltmpServiceValue(almAsnltmpServiceValueRepository) > 0) {
//            try {
//                json.put("code", 1);
//                json.put("msg", "success");
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }
//
//        }
//        return json.toString();
//    }

    @Override
    public String deleteAlmAsnltmpServiceValue(Integer asvId) {
        JSONObject json = new JSONObject();
        Integer count = almAsnltmpServiceValueDao.deleteAlmAsnltmpServiceValue(asvId);
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

//    @Override
//    public AlmAsnltmpServiceValueDTO selectAlmAsnltmpServiceValue(Integer asvId) {
//        return AlmAsnltmpServiceValueConvert.INSTANCE.toDTO(almAsnltmpServiceValueDao.selectAlmAsnltmpServiceValue(asvId));
//    }
//
//    @Override
//    public List<AlmAsnltmpServiceValueDTO> selectAllAlmAsnltmpServiceValue(String keyword, Integer pageNo, Integer pageSize) {
//        Integer offset = null;
//        if ((pageNo != null) && (pageSize != null)) {
//            offset = pageNo;
//
//        }
//        List<AlmAsnltmpServiceValueRepository> itemList = almAsnltmpServiceValueDao.selectAllAlmAsnltmpServiceValue(keyword, offset, pageSize);
//        if (itemList.size() > 0) {
//            return AlmAsnltmpServiceValueConvert.INSTANCE.toDTOs(itemList);
//        } else {
//            return null;
//        }
//    }
//
//    @Override
//    public Integer getAllAlmAsnltmpServiceValueCouont(String keyword) {
//        return almAsnltmpServiceValueDao.getAllAlmAsnltmpServiceValueCount(keyword);
//    }
}
