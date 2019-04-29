package com.asiainfo.rms.workflow.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.asiainfo.rms.workflow.dto.process.cb.AlmCbFineFlowDTO;
import com.asiainfo.rms.workflow.dto.process.cb.AlmCbFlowDTO;

@Component
public class ComputerSalaryUtils {

	public List<AlmCbFlowDTO> computer(AlmCbFlowDTO[] almCbFlowDTOs) throws Exception{
		// 首先根据岗位类型分类
		List<AlmCbFlowDTO> fixedAlmCbFlowDTOs = new ArrayList<AlmCbFlowDTO>();
		List<AlmCbFlowDTO> assemblyAlmCbFlowDTOs = new ArrayList<AlmCbFlowDTO>();
		List<AlmCbFlowDTO> assemblyAverageAlmCbFlowDTOs = new ArrayList<AlmCbFlowDTO>();
		List<AlmCbFlowDTO> assemblyLineAlmCbFlowDTOs = new ArrayList<AlmCbFlowDTO>();
		List<AlmCbFlowDTO> assemblyLineAverageAlmCbFlowDTOs = new ArrayList<AlmCbFlowDTO>();
		List<AlmCbFlowDTO> repairBoardAlmCbFlowDTOs = new ArrayList<AlmCbFlowDTO>();
		List<AlmCbFlowDTO> repairBoardAverageAlmCbFlowDTOs = new ArrayList<AlmCbFlowDTO>();
		List<AlmCbFlowDTO> sawBoardAlmCbFlowDTOs = new ArrayList<AlmCbFlowDTO>();
		List<AlmCbFlowDTO> sawBoardAverageAlmCbFlowDTOs = new ArrayList<AlmCbFlowDTO>();
		List<AlmCbFlowDTO> thermoCompressorAlmCbFlowDTOs = new ArrayList<AlmCbFlowDTO>();
		List<AlmCbFlowDTO> thermoCompressorAverageAlmCbFlowDTOs = new ArrayList<AlmCbFlowDTO>();
		List<AlmCbFlowDTO> allAlmCbFlowDTOs = new ArrayList<AlmCbFlowDTO>();
		List<AlmCbFlowDTO> allAverageAlmCbFlowDTOs = new ArrayList<AlmCbFlowDTO>();
		for (AlmCbFlowDTO almCbFlowDTO : almCbFlowDTOs) {
			switch(String.valueOf(almCbFlowDTO.getStationType())) {
				case "1": {
					fixedAlmCbFlowDTOs.add(almCbFlowDTO);
					break;
				}
				case "2": {
					allAverageAlmCbFlowDTOs.add(almCbFlowDTO);
					break;
				}
				case "3": {
					allAlmCbFlowDTOs.add(almCbFlowDTO);
					break;
				}
				case "4": {
					repairBoardAverageAlmCbFlowDTOs.add(almCbFlowDTO);
					break;
				}
				case "5": {
					repairBoardAlmCbFlowDTOs.add(almCbFlowDTO);
					break;
				}
				case "6": {
					thermoCompressorAverageAlmCbFlowDTOs.add(almCbFlowDTO);
					break;
				}
				case "7": {
					thermoCompressorAlmCbFlowDTOs.add(almCbFlowDTO);
					break;
				}
				case "8": {
					sawBoardAverageAlmCbFlowDTOs.add(almCbFlowDTO);
					break;
				}
				case "9": {
					sawBoardAlmCbFlowDTOs.add(almCbFlowDTO);
					break;
				}
				case "10": {
					assemblyAverageAlmCbFlowDTOs.add(almCbFlowDTO);
					break;
				}
				case "11": {
					assemblyAlmCbFlowDTOs.add(almCbFlowDTO);
					break;
				}
				case "12": {
					assemblyLineAverageAlmCbFlowDTOs.add(almCbFlowDTO);
					break;
				}
				case "13": {
					assemblyLineAlmCbFlowDTOs.add(almCbFlowDTO);
					break;
				}
			}
		}
		List<AlmCbFlowDTO> result = new ArrayList<AlmCbFlowDTO>();
		Map<Long, List<AlmCbFlowDTO>> resultMap = new HashMap<Long, List<AlmCbFlowDTO>>();
		if (!fixedAlmCbFlowDTOs.isEmpty()) {
			result = this.fixedAlmCbFlowDTOs(fixedAlmCbFlowDTOs);
		} else {
			if (!assemblyAverageAlmCbFlowDTOs.isEmpty() || !assemblyAlmCbFlowDTOs.isEmpty()) {
				resultMap = this.changeByStation(assemblyAverageAlmCbFlowDTOs, resultMap);
				resultMap = this.changeByStation(assemblyAlmCbFlowDTOs, resultMap);
			} else if (!assemblyLineAverageAlmCbFlowDTOs.isEmpty() || !assemblyLineAlmCbFlowDTOs.isEmpty()) {
				resultMap = this.changeByStation(assemblyLineAverageAlmCbFlowDTOs, resultMap);
				resultMap = this.changeByStation(assemblyLineAlmCbFlowDTOs, resultMap);
			} else if (!repairBoardAverageAlmCbFlowDTOs.isEmpty() || !repairBoardAlmCbFlowDTOs.isEmpty()) {
				resultMap = this.changeByStation(repairBoardAverageAlmCbFlowDTOs, resultMap);
				resultMap = this.changeByStation(repairBoardAlmCbFlowDTOs, resultMap);
			} else if (!sawBoardAverageAlmCbFlowDTOs.isEmpty() || !sawBoardAlmCbFlowDTOs.isEmpty()) {
				resultMap = this.changeByStation(sawBoardAverageAlmCbFlowDTOs, resultMap);
				resultMap = this.changeByStation(sawBoardAlmCbFlowDTOs, resultMap);
			} else if (!thermoCompressorAverageAlmCbFlowDTOs.isEmpty() || !thermoCompressorAlmCbFlowDTOs.isEmpty()) {
				resultMap = this.changeByStation(thermoCompressorAverageAlmCbFlowDTOs, resultMap);
				resultMap = this.changeByStation(thermoCompressorAlmCbFlowDTOs, resultMap);
			} 
			resultMap = this.changeByStation(allAverageAlmCbFlowDTOs, resultMap);
			resultMap = this.changeByStation(allAlmCbFlowDTOs, resultMap);
			result = this.computerSalary(resultMap);
		}
		return result;
	}
	
	private List<AlmCbFlowDTO> fixedAlmCbFlowDTOs(List<AlmCbFlowDTO> fixedAlmCbFlowDTOs) throws Exception{
		for (AlmCbFlowDTO almCbFlowDTO : fixedAlmCbFlowDTOs) {
			if (StringUtils.isEmpty(almCbFlowDTO.getStationCode())) {
				throw new Exception("岗位金额为空");
			}
			almCbFlowDTO.setObjAmount("1");
			almCbFlowDTO.setObjStaff("1");
			BigDecimal stationCode = new BigDecimal(almCbFlowDTO.getStationCode().trim());
			BigDecimal objStaff = new BigDecimal(almCbFlowDTO.getObjStaff());
			BigDecimal stationCodeStaff = stationCode.divide(objStaff, 10, RoundingMode.HALF_UP);
			BigDecimal objAmount = new BigDecimal(almCbFlowDTO.getObjAmount());
			BigDecimal stationCodeStaffAmount =  stationCodeStaff.multiply(objAmount);
			NumberFormat currency = NumberFormat.getNumberInstance();
			currency.setMinimumFractionDigits(2);
			currency.setMaximumFractionDigits(4);
			almCbFlowDTO.setObjFormula(almCbFlowDTO.getStationCode().trim()+ "(单额) / " + almCbFlowDTO.getObjStaff() + "(人数) * " + almCbFlowDTO.getObjAmount() + "(数量) = " + currency.format(stationCodeStaffAmount).trim() + "(总额)");
			almCbFlowDTO.setObjAccount(currency.format(stationCodeStaffAmount).trim());
		}
		return fixedAlmCbFlowDTOs;
	}
	
	private Map<Long, List<AlmCbFlowDTO>> changeByStation(List<AlmCbFlowDTO> almCbFlowDTOs, Map<Long, List<AlmCbFlowDTO>> result) throws Exception {
		if (almCbFlowDTOs.isEmpty()) {
			return result;
		}
		for (AlmCbFlowDTO almCbFlowDTO : almCbFlowDTOs) {
			List<AlmCbFlowDTO> list = null;
			if (result.containsKey(almCbFlowDTO.getStationId())) {
				list = result.get(almCbFlowDTO.getStationId());
			} else {
				list = new ArrayList<AlmCbFlowDTO>();
			}
			list.add(almCbFlowDTO);
			result.put(almCbFlowDTO.getStationId(), list);
		}
		return result;
	}
	
	private List<AlmCbFlowDTO> computerSalary(Map<Long, List<AlmCbFlowDTO>> result) throws Exception {
		List<AlmCbFlowDTO> list = new ArrayList<AlmCbFlowDTO>();
		if (result.isEmpty()) {
			return list;
		}
		for (Long key : result.keySet()) {
			List<AlmCbFlowDTO> almCbFlows = result.get(key);
			for (AlmCbFlowDTO almCbFlowDTO : almCbFlows) {
				if (almCbFlowDTO.getStationType().compareTo(2) == 0 ||
						almCbFlowDTO.getStationType().compareTo(4) == 0 ||
						almCbFlowDTO.getStationType().compareTo(6) == 0 ||
						almCbFlowDTO.getStationType().compareTo(8) == 0 ||
						almCbFlowDTO.getStationType().compareTo(10) == 0 ||
						almCbFlowDTO.getStationType().compareTo(12) == 0) {
					if (StringUtils.isEmpty(almCbFlowDTO.getStationCode())) {
						throw new Exception("岗位金额为空");
					}
					almCbFlowDTO.setObjStaff(String.valueOf(almCbFlows.size()));
				} else {
					if (StringUtils.isEmpty(almCbFlowDTO.getStationCode())) {
						throw new Exception("岗位金额为空");
					}
					almCbFlowDTO.setObjStaff("1");
				}
				BigDecimal stationCode = new BigDecimal(almCbFlowDTO.getStationCode().trim());
				if (Long.valueOf(almCbFlowDTO.getObjStaff()).compareTo(0L) <= 0) {
					throw new Exception("参与人数必须为大于等于壹的数");
				}
				BigDecimal objStaff = new BigDecimal(almCbFlowDTO.getObjStaff());
				BigDecimal stationCodeStaff = stationCode.divide(objStaff, 10, RoundingMode.HALF_UP);
				BigDecimal objAmount = new BigDecimal(almCbFlowDTO.getObjAmount());
				BigDecimal stationCodeStaffAmount =  stationCodeStaff.multiply(objAmount).setScale(2, RoundingMode.HALF_DOWN);
				NumberFormat currency = NumberFormat.getNumberInstance();
				currency.setMinimumFractionDigits(2);
				currency.setMaximumFractionDigits(4);
				almCbFlowDTO.setObjFormula(almCbFlowDTO.getStationCode().trim()+ "(单额) / " + almCbFlowDTO.getObjStaff() + "(人数) * " + almCbFlowDTO.getObjAmount() + "(数量) = " + currency.format(stationCodeStaffAmount).trim() + "(总额)");
				almCbFlowDTO.setObjAccount(stationCodeStaffAmount.toString());
				list.add(almCbFlowDTO);
			}
		}
		return list;
	}
	
	public List<AlmCbFineFlowDTO> computerFine(AlmCbFineFlowDTO[] result) throws Exception {
		List<AlmCbFineFlowDTO> list = new ArrayList<AlmCbFineFlowDTO>();
		if (result == null || result.length == 0) {
			return list;
		}
		for (AlmCbFineFlowDTO almCbFineFlowDTO : result) {
			if (StringUtils.isEmpty(almCbFineFlowDTO.getFineMoney())) {
				throw new Exception("处罚金额为空");
			}
			BigDecimal fineMoney = new BigDecimal(almCbFineFlowDTO.getFineMoney().trim());
			if (Long.valueOf(almCbFineFlowDTO.getFineAmount()).compareTo(0L) <= 0) {
				throw new Exception("参与人数必须为大于等于壹的数");
			}
			BigDecimal objStaff = new BigDecimal("1");
			BigDecimal stationCodeStaff = fineMoney.divide(objStaff, 10, RoundingMode.HALF_UP);
			BigDecimal objAmount = new BigDecimal(almCbFineFlowDTO.getFineAmount());
			BigDecimal stationCodeStaffAmount =  stationCodeStaff.multiply(objAmount).setScale(2, RoundingMode.HALF_DOWN);
			NumberFormat currency = NumberFormat.getNumberInstance();
			currency.setMinimumFractionDigits(2);
			currency.setMaximumFractionDigits(4);
			almCbFineFlowDTO.setFineFormula(almCbFineFlowDTO.getFineMoney().trim()+ "(单额) / 1(人数) * " + almCbFineFlowDTO.getFineAmount() + "(数量) = " + currency.format(stationCodeStaffAmount).trim() + "(总额)");
			almCbFineFlowDTO.setFineAccount(stationCodeStaffAmount.toString());
			list.add(almCbFineFlowDTO);
		}
		return list;
	}
}
