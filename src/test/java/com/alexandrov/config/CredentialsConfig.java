package com.alexandrov.config;

import org.aeonbits.owner.Config;

import static org.aeonbits.owner.Config.*;

@Config.Sources("classpath:config/credentials.properties")
public interface CredentialsConfig extends Config {

    String login();
    String password();
    String remoteURL();
}
