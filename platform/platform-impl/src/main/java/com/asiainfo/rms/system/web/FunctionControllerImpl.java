package com.asiainfo.rms.system.web;

import com.asiainfo.rms.system.dto.SysFunctionDTO;
import com.asiainfo.rms.system.service.FunctionService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@Transactional
public class FunctionControllerImpl implements FunctionController {
    private final FunctionService functionService;

    public FunctionControllerImpl(FunctionService functionService) {
        this.functionService = functionService;
    }

    @Override
    public String saveFunction(@RequestBody SysFunctionDTO functionDTO) {
        return functionService.saveFunction(functionDTO);
    }

    @Override
    public String updateFunction(@PathVariable("func_id") Integer funcId, @RequestBody SysFunctionDTO functionDTO) {
        functionDTO.setFuncId(funcId);
        return functionService.updateFunction(functionDTO);
    }

    @Override
    public String deleteFunctionById(@PathVariable("func_id")Integer funcId) {
        return functionService.deleteFunctionById(funcId);
    }

    @Override
    public SysFunctionDTO selectByFunctionId(@PathVariable("func_id")Integer funcId) {
        return functionService.selectByFuncId(funcId);
    }

    @Override
    public List<SysFunctionDTO> selectAllFunction(@RequestParam(value = "state", required = false)Integer state) {
        return functionService.selectAllFunction(state);
    }
}
