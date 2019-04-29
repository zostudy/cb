package com.asiainfo.rms.alm.demand.service;

import com.asiainfo.rms.alm.demand.convert.AlmReqtmpFunctionConvert;
import com.asiainfo.rms.alm.demand.convert.AlmReqtmpTopicConvert;
import com.asiainfo.rms.alm.demand.dao.AlmReqtmpFunctionDao;
import com.asiainfo.rms.alm.demand.dao.AlmReqtmpTopicDao;
import com.asiainfo.rms.alm.demand.domain.AlmReqtmpFunctionRepository;
import com.asiainfo.rms.alm.demand.dto.AlmReqtmpFunctionDTO;
import com.asiainfo.rms.alm.demand.dto.AlmReqtmpTopicDTO;
import com.asiainfo.rms.alm.demand.dto.FunctionDTO;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class AlmReqtmpFunctionServiceImpl implements AlmReqtmpFunctionService {
    private final AlmReqtmpFunctionDao almReqtmpFunctionDao;
    private final AlmReqtmpTopicDao almReqtmpTopicDao;

    public AlmReqtmpFunctionServiceImpl(AlmReqtmpFunctionDao almReqtmpFunctionDao, AlmReqtmpTopicDao almReqtmpTopicDao) {
        this.almReqtmpFunctionDao = almReqtmpFunctionDao;
        this.almReqtmpTopicDao = almReqtmpTopicDao;
    }

    @Override
    public String saveAlmReqtmpFunction(FunctionDTO functionDTO) {
        JSONObject json = new JSONObject();
        AlmReqtmpTopicDTO almReqtmpTopicDTO = functionDTO.getTopicDTO();
        AlmReqtmpTopicServiceImpl almReqtmpTopicService = new AlmReqtmpTopicServiceImpl(almReqtmpTopicDao);
        String info = almReqtmpTopicService.saveAlmReqtmpTopic(almReqtmpTopicDTO);
        JSONObject jsonReturn;
        String artId = "";
        try {
        	jsonReturn = new JSONObject(info);
        	artId=jsonReturn.getString("art_id");
            json.put("art_id", artId);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        AlmReqtmpFunctionRepository almReqtmpFunctionRepository;
        almReqtmpFunctionRepository = AlmReqtmpFunctionConvert.INSTANCE.toSYS(functionDTO.getFunctionDTO());
        almReqtmpFunctionRepository.setArtId(Integer.parseInt(artId));
        if (almReqtmpFunctionDao.saveAlmReqtmpFunction(almReqtmpFunctionRepository) > 0) {
            try {
                json.put("code", 1);
                json.put("msg", "success");
                json.put("arf_id", almReqtmpFunctionRepository.getArfId());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return json.toString();
    }

    @Override
    public String updateAlmReqtmpFunction(FunctionDTO functionDTO) {
        JSONObject json = new JSONObject();
        int count = 0;
        AlmReqtmpTopicDTO almReqtmpTopicDTO = functionDTO.getTopicDTO();
        if (almReqtmpTopicDTO != null) {
            AlmReqtmpTopicServiceImpl almReqtmpTopicService = new AlmReqtmpTopicServiceImpl(almReqtmpTopicDao);
            String info = almReqtmpTopicService.updateAlmReqtmpTopic(almReqtmpTopicDTO);
            String updateNum = "";
            try {
            	JSONObject jsonReturn = new JSONObject(info);
            	updateNum=jsonReturn.getString("row_count");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            //修改基本信息
            if (updateNum.equals("1")) {
                count++;
            }
        }
        AlmReqtmpFunctionRepository almReqtmpFunctionRepository;
        almReqtmpFunctionRepository = AlmReqtmpFunctionConvert.INSTANCE.toSYS(functionDTO.getFunctionDTO());
        if (almReqtmpFunctionDao.updateAlmReqtmpFunction(almReqtmpFunctionRepository) > 0) {
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
    public String deleteAlmReqtmpFunction(Integer arfId) {
        JSONObject json = new JSONObject();
        int count = 0;
        AlmReqtmpFunctionRepository almReqtmpFunctionRepository = almReqtmpFunctionDao.selectAlmReqtmpFunction(arfId);
        Integer artId = almReqtmpFunctionRepository.getArtId();
        AlmReqtmpTopicServiceImpl almReqtmpTopicService = new AlmReqtmpTopicServiceImpl(almReqtmpTopicDao);
        String num = almReqtmpTopicService.deleteAlmReqtmpTopic(artId);
        String delNum = "";
        try {
        	JSONObject jsonReturn = new JSONObject(num);
        	delNum=jsonReturn.getString("row_count");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (delNum.equals("1")) {
            count++;
        }
        if (almReqtmpFunctionDao.deleteAlmReqtmpFunction(arfId) > 0) {
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
    public FunctionDTO selectAlmReqtmpFunction(Integer arfId) {
        FunctionDTO functionDTO = new FunctionDTO();
        AlmReqtmpFunctionDTO almReqtmpFunctionDTO = AlmReqtmpFunctionConvert.INSTANCE.toDTO(almReqtmpFunctionDao.selectAlmReqtmpFunction(arfId));
        functionDTO.setFunctionDTO(almReqtmpFunctionDTO);
        if (almReqtmpFunctionDTO != null) {

            int artId = almReqtmpFunctionDTO.getArtId();
            AlmReqtmpTopicDTO almReqtmpTopicDTO = AlmReqtmpTopicConvert.INSTANCE.toDTO(almReqtmpTopicDao.selectAlmReqtmpTopicById(artId));
            functionDTO.setTopicDTO(almReqtmpTopicDTO);
        }
        return functionDTO;
    }

    @Override
    public FunctionDTO selectFunction(Integer artId) {
        FunctionDTO functionDTO = new FunctionDTO();
        AlmReqtmpFunctionDTO almReqtmpFunctionDTO = AlmReqtmpFunctionConvert.INSTANCE.toDTO(almReqtmpFunctionDao.selectAlmReqtmpFunctionByArtId(artId));
        AlmReqtmpTopicDTO almReqtmpTopicDTO = AlmReqtmpTopicConvert.INSTANCE.toDTO(almReqtmpTopicDao.selectAlmReqtmpTopicById(artId));
        functionDTO.setFunctionDTO(almReqtmpFunctionDTO);
        functionDTO.setTopicDTO(almReqtmpTopicDTO);
        return functionDTO;
    }

    @Override
    public List<AlmReqtmpFunctionDTO> selectAllAlmReqtmpFunction(String keyword,Integer artType,String artName, String artTag,Integer artRegion,Integer urgentLevel,String submitStaffName, Integer pageNo, Integer pageSize) {
        Integer offset = null;
        if ((pageNo != null) && (pageSize != null)) {
            offset = pageNo;

        }
        List<AlmReqtmpFunctionRepository> itemList = almReqtmpFunctionDao.selectAllAlmReqtmpFunction(keyword,artType,artName,artTag,artRegion,urgentLevel,submitStaffName, offset, pageSize);
        if (itemList.size() > 0) {
            return AlmReqtmpFunctionConvert.INSTANCE.toDTOs(itemList);
        } else {
            return null;
        }
    }

    @Override
    public Integer getAllAlmReqtmpFunctionCount(String keyword,Integer artType,String artName, String artTag,Integer artRegion,Integer urgentLevel,String submitStaffName) {
        return almReqtmpFunctionDao.getAllAlmReqtmpFunctionCount(keyword,artType,artName,artTag,artRegion,urgentLevel,submitStaffName);
    }
}
