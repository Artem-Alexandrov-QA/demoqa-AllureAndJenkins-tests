package com.alexandrov.config;

import org.aeonbits.owner.Config;

@Config.Sources({"resources/config/credentials.properties"})
public interface CredentialsConfig extends Config {

    String login();
    String password();
    String browserURL();
}
