package com.example.demo.configurationproperties;

public interface AuthProperties {
    boolean isDebugEnabled();

    Ldap getLdap();

    DummyUser getDummyUser();

    interface Ldap {
        String getServer();

        String getBaseDn();

        String getBindDn();

        String getBindPassword();

        boolean isLdapBindEnabled();

    }

    interface DummyUser {
        boolean isEnabled();

        String getName();

        String getPassword();
    }
}
