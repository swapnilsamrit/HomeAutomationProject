package com.home.cloud;

public interface BootStrapService {
    boolean initNetworks();
    boolean initMqtt();

    void initSystem();
}
