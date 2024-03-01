package com.example.demo.configurationproperties;

import com.example.demo.ui.WebUIProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix="com.example.webui")
public class WebUIPropertiesImpl implements WebUIProperties {

    private String contextPath;

    private final AuthProperties authProperties;

    public WebUIPropertiesImpl(AuthProperties authProperties) {
        this.authProperties = authProperties;
    }

    @Override
    public String getContextPath() {
        return contextPath;
    }

    public void setContextPath(String contextPath) {
        this.contextPath = contextPath;
    }

    @Override
    public boolean isLdapLoginEnabled() {
        return authProperties.getLdap().isLdapBindEnabled();
    }

    @Override
    public boolean isDummyUserEnabled() {
        return authProperties.getDummyUser().isEnabled();
    }

    @Override
    public String getDummyUserName() {
        return authProperties.getDummyUser().getName();
    }

    @Override
    public String getDummyUserPassword() {
        return authProperties.getDummyUser().getPassword();
    }
}
