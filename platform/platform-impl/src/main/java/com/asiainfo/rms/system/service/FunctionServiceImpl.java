package com.asiainfo.rms.system.service;

import com.asiainfo.rms.core.exception.BusinessException;
import com.asiainfo.rms.system.convert.SysFunction;
import com.asiainfo.rms.system.dao.SysFunctionDao;
import com.asiainfo.rms.system.domain.SysFunctionRepository;
import com.asiainfo.rms.system.dto.SysFunctionDTO;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class FunctionServiceImpl implements FunctionService {
    private final SysFunctionDao functionDao;

    public FunctionServiceImpl(SysFunctionDao functionDao) {
        this.functionDao = functionDao;
    }

    @Override
    public String saveFunction(SysFunctionDTO functionDTO) {
        JSONObject json = new JSONObject();
        functionDTO.setState(1);
        SysFunctionRepository functionRepository;
        functionRepository = SysFunction.INSTANCE.toSYS(functionDTO);

        String code =functionRepository.getFuncCode();
        if(functionDao.getFunctionByCode(code)>0){
            throw new BusinessException("菜单编码有重复，请重新输入！");
        }else{
            if (functionDao.saveFunction(functionRepository) > 0) {

                try {
                    json.put("code", 0);
                    json.put("msg", "success");
                    json.put("func_id", functionRepository.getFuncId());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
//        List<SysFunctionRepository> funcList = functionDao.selectAllFuncCode();
//        if (funcList.size() == 0) {
//            code = "F" + String.format("%0" + 3 + "d", 1);
//        } else {
//            Integer num = Integer.valueOf(funcList.get(0).getFuncCode().substring(1)) + 1;
//            code = "F" + String.format("%0" + 3 + "d", num);
//        }
//        functionRepository.setFuncCode(code);

        return json.toString();
    }

    @Override
    public String updateFunction(SysFunctionDTO functionDTO) {
        JSONObject json = new JSONObject();
        if (functionDao.updateFunction(SysFunction.INSTANCE.toSYS(functionDTO)) > 0) {
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
    public String deleteFunctionById(Integer funcId) {
        JSONObject json = new JSONObject();
        Integer count = functionDao.deleteFunctionById(funcId);
        try {
            if (count > 0) {
                json.put("code", 1);
                json.put("msg", "seccess");
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
    public SysFunctionDTO selectByFuncId(Integer funcId) {
        return SysFunction.INSTANCE.toDTO(functionDao.selectByFunctionId(funcId));
    }

    @Override
    public List<SysFunctionDTO> selectAllFunction(Integer state) {
        return SysFunction.INSTANCE.toDTOs(functionDao.selectAllFunction(state));
    }

    @Override
    public List<SysFunctionDTO> selectFunctionByStaffId(Integer staffId) {
        return SysFunction.INSTANCE.toDTOs(functionDao.selectFunctionByStaffId(staffId));
    }
}
