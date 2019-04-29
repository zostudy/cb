package com.asiainfo.rms.workflow.bo.process.common;

import java.util.List;

import com.asiainfo.rms.workflow.bo.workflow.StakeholderBO;

import lombok.Data;

@Data
public class LaunchProcessBO {

    private String staffId;
	
    private List<StakeholderBO> stds;
	
    private String opinion;
	
    private String result;
    
    private String plantime;
    
    private String sourcePath;
    
    private String processKey;
    
    private String objectTypeId;
    
    private String objectId;
    
    private String cond;
    
    private String direction;
}
