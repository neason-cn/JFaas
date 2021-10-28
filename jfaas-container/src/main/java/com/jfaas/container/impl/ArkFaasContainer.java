package com.jfaas.container.impl;

import java.util.concurrent.atomic.AtomicBoolean;

import com.alipay.sofa.ark.container.service.ArkServiceContainer;
import com.jfaas.container.core.FaasContainer;
import org.springframework.util.Assert;

/**
 * @author : neason-cn
 * @date : 2021/10/28
 */
public class ArkFaasContainer implements FaasContainer {

    private ArkServiceContainer arkContainer;
    private AtomicBoolean stopped = new AtomicBoolean(false);

    public ArkFaasContainer(ArkServiceContainer container) {
        Assert.notNull(container, "The arkContain can not be null.");
        this.arkContainer = container;
    }

    public <T> T getBean(Class<T> clazz) {
        return arkContainer.getService(clazz);
    }

    public void start() {
        arkContainer.start();
    }

    public void stop() {
        arkContainer.stop();
    }

    public boolean isStarted() {
        return arkContainer.isStarted();
    }

    public boolean isRunning() {
        return arkContainer.isRunning();
    }

    public boolean isStopped() {
        return stopped.get();
    }
}
