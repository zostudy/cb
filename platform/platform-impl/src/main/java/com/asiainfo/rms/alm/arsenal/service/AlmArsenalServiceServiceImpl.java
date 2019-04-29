package com.asiainfo.rms.alm.arsenal.service;

import com.asiainfo.rms.alm.arsenal.convert.AlmArsenalServiceConvert;
import com.asiainfo.rms.alm.arsenal.dao.AlmArsenalServiceDao;
import com.asiainfo.rms.alm.arsenal.domain.AlmArsenalServiceRepository;
import com.asiainfo.rms.alm.arsenal.dto.AlmArsenalServiceDTO;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class AlmArsenalServiceServiceImpl implements AlmArsenalServiceService {
    private final AlmArsenalServiceDao almArsenalServiceDao;

    public AlmArsenalServiceServiceImpl(AlmArsenalServiceDao almArsenalServiceDao) {
        this.almArsenalServiceDao = almArsenalServiceDao;
    }

    @Override
    public String saveAlmArsenalService(AlmArsenalServiceDTO almArsenalServiceDTO) {
        JSONObject json = new JSONObject();
        AlmArsenalServiceRepository almArsenalServiceRepository;
        almArsenalServiceRepository = AlmArsenalServiceConvert.INSTANCE.toSYS(almArsenalServiceDTO);
        //service_id唯一性校验
        Integer serviceId = almArsenalServiceRepository.getServiceId();
        if (serviceId > 0 || serviceId <= 999999) {
            if (almArsenalServiceDao.getAlmArsenalServiceByServiceId(serviceId) == 0) {
                if (almArsenalServiceDao.saveAlmArsenalService(almArsenalServiceRepository) > 0) {
                    try {
                        json.put("code", 1);
                        json.put("msg", "success");
                        json.put("as_id", almArsenalServiceRepository.getAsId());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                try {
                    json.put("code", 0);
                    json.put("msg", "服务编码有重复，请重新输入!");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        } else {
            try {
                json.put("code", 0);
                json.put("msg", "服务编码超出范围，请重新输入!");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        return json.toString();
    }

    @Override
    public String updateAlmArsenalService(AlmArsenalServiceDTO almArsenalServiceDTO) {
        JSONObject json = new JSONObject();
        AlmArsenalServiceRepository almArsenalServiceRepository;
        almArsenalServiceRepository = AlmArsenalServiceConvert.INSTANCE.toSYS(almArsenalServiceDTO);
        if (almArsenalServiceDao.updateAlmArsenalService(almArsenalServiceRepository) > 0) {
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
    public String deleteAlmArsenalService(Integer asId) {
        JSONObject json = new JSONObject();
        Integer count = almArsenalServiceDao.deleteAlmArsenalService(asId);
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

    @Override
    public AlmArsenalServiceDTO selectAlmArsenalServiceById(Integer asId) {
        return AlmArsenalServiceConvert.INSTANCE.toDTO(almArsenalServiceDao.selectAlmArsenalServiceById(asId));
    }

    @Override
    public List<AlmArsenalServiceDTO> selectAllAlmArsenalService(String keyword, Integer pageNo, Integer pageSize) {
        Integer offset = null;
        if ((pageNo != null) && (pageSize != null)) {
            offset = pageNo;

        }
        List<AlmArsenalServiceRepository> itemList = almArsenalServiceDao.selectAllAlmArsenalService(keyword, offset, pageSize);
        if (itemList.size() > 0) {
            return AlmArsenalServiceConvert.INSTANCE.toDTOs(itemList);
        } else {
            return null;
        }
    }

    @Override
    public Integer getAllAlmArsenalService(String keyword) {
        return almArsenalServiceDao.getAllAlmArsenalService(keyword);
    }
}
