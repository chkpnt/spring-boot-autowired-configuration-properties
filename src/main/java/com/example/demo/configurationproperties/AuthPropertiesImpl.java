package com.example.demo.configurationproperties;

import javax.validation.constraints.NotEmpty;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

@Validated
@ConfigurationProperties(prefix = "com.example.auth")
class AuthPropertiesImpl implements AuthProperties {

    private Ldap ldap = new LdapImpl();

    private DummyUser dummyUser = new DummyUserImpl();

    private boolean debug;

    @Override
    public Ldap getLdap() {
        return ldap;
    }

    @Override
    public DummyUser getDummyUser() {
        return dummyUser;
    }

    public void setDebug(boolean debug) {
        this.debug = debug;
    }

    public boolean isDebug() {
        return debug;
    }

    @Override
    public boolean isDebugEnabled() {
        return isDebug();
    }

    @Validated
    @ConfigurationProperties(prefix = "com.example.auth.ldap")
    public static class LdapImpl implements Ldap {

        @NotEmpty
        private String server;

        @NotEmpty
        private String baseDn;

        private String bindDn;
        private String bindPassword;

        @Override
        public String getServer() {
            return server;
        }

        public void setServer(String server) {
            this.server = server;
        }

        @Override
        public String getBaseDn() {
            return baseDn;
        }

        public void setBaseDn(String baseDn) {
            this.baseDn = baseDn;
        }

        @Override
        public String getBindDn() {
            return bindDn;
        }

        public void setBindDn(String bindDn) {
            this.bindDn = bindDn;
        }

        @Override
        public String getBindPassword() {
            return bindPassword;
        }

        public void setBindPassword(String bindPassword) {
            this.bindPassword = bindPassword;
        }

        @Override
        public boolean isLdapBindEnabled() {
            return StringUtils.isNoneBlank(bindDn, bindPassword);
        }

    }

    @Validated
    @ConfigurationProperties(prefix = "com.example.auth.dummy-user")
    public static class DummyUserImpl implements DummyUser {

        private String name;

        private String password;

        @Override
        public boolean isEnabled() {
            return StringUtils.isNoneBlank(name, password);
        }

        @Override
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }
}
