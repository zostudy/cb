package com.asiainfo.rms.alm.demand.service;

import com.asiainfo.rms.alm.demand.convert.AlmReqtmpSimpleParamConvert;
import com.asiainfo.rms.alm.demand.convert.AlmReqtmpTopicConvert;
import com.asiainfo.rms.alm.demand.dao.AlmReqtmpSimpleParamDao;
import com.asiainfo.rms.alm.demand.dao.AlmReqtmpTopicDao;
import com.asiainfo.rms.alm.demand.domain.AlmReqtmpSimpleParamRepository;
import com.asiainfo.rms.alm.demand.dto.AlmReqtmpSimpleParamDTO;
import com.asiainfo.rms.alm.demand.dto.AlmReqtmpTopicDTO;
import com.asiainfo.rms.alm.demand.dto.SimpleParamDTO;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class AlmReqtmpSimpleParamServiceImpl implements AlmReqtmpSimpleParamService {
    private final AlmReqtmpSimpleParamDao almReqtmpSimpleParamDao;
    private final AlmReqtmpTopicDao almReqtmpTopicDao;

    public AlmReqtmpSimpleParamServiceImpl(AlmReqtmpSimpleParamDao almReqtmpSimpleParamDao, AlmReqtmpTopicDao almReqtmpTopicDao) {
        this.almReqtmpSimpleParamDao = almReqtmpSimpleParamDao;
        this.almReqtmpTopicDao = almReqtmpTopicDao;
    }

    @Override
    public String saveAlmReqtmpSimpleParam(SimpleParamDTO simpleParamDTO) {
        JSONObject json = new JSONObject();

//        AlmReqtmpTopicDTO almReqtmpTopicDTO =simpleParamDTO.getTopicDTO();
//        AlmReqtmpTopicServiceImpl almReqtmpTopicService = new AlmReqtmpTopicServiceImpl(almReqtmpTopicDao);
//        String info =almReqtmpTopicService.saveAlmReqtmpTopic(almReqtmpTopicDTO);
//        try {
//            json.put("art_id",info);
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }

        AlmReqtmpSimpleParamRepository almReqtmpSimpleParamRepository;
        almReqtmpSimpleParamRepository = AlmReqtmpSimpleParamConvert.INSTANCE.toSYS(simpleParamDTO.getSimpleParamDTO());
        if (almReqtmpSimpleParamDao.saveAlmReqtmpSimpleParam(almReqtmpSimpleParamRepository) > 0) {
            try {
                json.put("code", 1);
                json.put("msg", "success");
                json.put("arsp_id", almReqtmpSimpleParamRepository.getArspId());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        return json.toString();
    }

    @Override
    public String updateAlmReqtmpSimpleParam(SimpleParamDTO simpleParamDTO) {
        JSONObject json = new JSONObject();
        int count = 0;
//        AlmReqtmpTopicDTO almReqtmpTopicDTO = simpleParamDTO.getTopicDTO();
//        if (almReqtmpTopicDTO != null) {
//            AlmReqtmpTopicServiceImpl almReqtmpTopicService = new AlmReqtmpTopicServiceImpl(almReqtmpTopicDao);
//            String info = almReqtmpTopicService.updateAlmReqtmpTopic(almReqtmpTopicDTO);
//            //修改基本信息
//            if(info.equals("1")){
//                count++;
//            }
//        }

        AlmReqtmpSimpleParamRepository almReqtmpSimpleParamRepository;
        almReqtmpSimpleParamRepository = AlmReqtmpSimpleParamConvert.INSTANCE.toSYS(simpleParamDTO.getSimpleParamDTO());
        if (almReqtmpSimpleParamDao.updateAlmReqtmpSimpleParam(almReqtmpSimpleParamRepository) > 0) {
            count++;
        }
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
    public String deleteAlmReqtmpSimpleParam(Integer arspId) {
        JSONObject json = new JSONObject();
        int count = 0;
//        AlmReqtmpSimpleParamRepository almReqtmpSimpleParamRepository = almReqtmpSimpleParamDao.selectAlmReqtmpSimpleParam(arspId);
//        Integer artId = almReqtmpSimpleParamRepository.getArtId();
//        AlmReqtmpTopicServiceImpl almReqtmpTopicService = new AlmReqtmpTopicServiceImpl(almReqtmpTopicDao);
//        String num = almReqtmpTopicService.deleteAlmReqtmpTopic(artId);
//        if (num.equals("1")) {
//            count++;
//        }
        if (almReqtmpSimpleParamDao.deleteAlmReqtmpSimpleParam(arspId) > 0) {
            count++;
        }
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
    public SimpleParamDTO selectAlmReqtmpSimpleParam(Integer arspId) {
        SimpleParamDTO simpleParamDTO = new SimpleParamDTO();
        AlmReqtmpSimpleParamDTO almReqtmpSimpleParamDTO = AlmReqtmpSimpleParamConvert.INSTANCE.toDTO(almReqtmpSimpleParamDao.selectAlmReqtmpSimpleParam(arspId));
        simpleParamDTO.setSimpleParamDTO(almReqtmpSimpleParamDTO);
        if (almReqtmpSimpleParamDTO != null) {
            int artId = almReqtmpSimpleParamDTO.getArtId();
            AlmReqtmpTopicDTO almReqtmpTopicDTO = AlmReqtmpTopicConvert.INSTANCE.toDTO(almReqtmpTopicDao.selectAlmReqtmpTopicById(artId));
            simpleParamDTO.setTopicDTO(almReqtmpTopicDTO);
        }

        return simpleParamDTO;

    }

    @Override
    public SimpleParamDTO selectSimpleParam(Integer artId) {
        SimpleParamDTO simpleParamDTO = new SimpleParamDTO();
        AlmReqtmpSimpleParamDTO almReqtmpSimpleParamDTO = AlmReqtmpSimpleParamConvert.INSTANCE.toDTO(almReqtmpSimpleParamDao.selectAlmReqtmpSimpleParamByArtId(artId));

        AlmReqtmpTopicDTO almReqtmpTopicDTO = AlmReqtmpTopicConvert.INSTANCE.toDTO(almReqtmpTopicDao.selectAlmReqtmpTopicById(artId));

        simpleParamDTO.setSimpleParamDTO(almReqtmpSimpleParamDTO);
        simpleParamDTO.setTopicDTO(almReqtmpTopicDTO);

        return simpleParamDTO;
    }

    @Override
    public List<AlmReqtmpSimpleParamDTO> selectAllAlmReqtmpSimpleParam(Integer artId,Integer modifyType, Integer pageNo, Integer pageSize) {
        Integer offset = null;
        if ((pageNo != null) && (pageSize != null)) {
            offset = pageNo;

        }
        List<AlmReqtmpSimpleParamRepository> itemList = almReqtmpSimpleParamDao.selectAllAlmReqtmpSimpleParam(artId,modifyType, offset, pageSize);
        if (itemList.size() > 0) {
            return AlmReqtmpSimpleParamConvert.INSTANCE.toDTOs(itemList);
        } else {
            return null;
        }
    }

    @Override
    public Integer getAllAlmReqtmpSimpleParam(Integer artId,Integer modifyType) {
        return almReqtmpSimpleParamDao.getAllAlmReqtmpSimpleParam(artId,modifyType);
    }
    
    public List<Integer> getAllAlmReqtmpSimpleParamType( Integer artId){
    	return almReqtmpSimpleParamDao.getAllAlmReqtmpSimpleParamType(artId);
    }
}
