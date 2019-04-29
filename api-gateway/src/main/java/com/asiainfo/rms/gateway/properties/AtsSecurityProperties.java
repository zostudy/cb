package com.asiainfo.rms.gateway.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "ats.security")
public class AtsSecurityProperties {
	
	private SkipUri[] skipUris;

	public SkipUri[] getSkipUris() {
		return skipUris;
	}

	public void setSkipUris(SkipUri[] skipUris) {
		this.skipUris = skipUris;
	}

	public AtsSecurityProperties(SkipUri[] skipUris) {
		this.skipUris = skipUris;
	}

	public AtsSecurityProperties() {}
	
}
