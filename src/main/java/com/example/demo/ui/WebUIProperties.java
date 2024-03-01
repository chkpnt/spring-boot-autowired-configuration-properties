package com.example.demo.ui;

public interface WebUIProperties {

    String getContextPath();

    boolean isLdapLoginEnabled();

    boolean isDummyUserEnabled();

    String getDummyUserName();

    String getDummyUserPassword();
}
