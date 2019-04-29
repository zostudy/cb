package com.asiainfo.rms.system;

import com.asiainfo.rms.system.web.LoginController;
import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient(name = "platform", path = "/rms/platform")
public interface LoginClient extends LoginController {
}
