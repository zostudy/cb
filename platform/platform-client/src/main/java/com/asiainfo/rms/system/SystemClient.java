package com.asiainfo.rms.system;

import com.asiainfo.rms.system.web.SystemController;
import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient(name = "platform", path = "/rms/platform")
public interface SystemClient extends SystemController {

}
