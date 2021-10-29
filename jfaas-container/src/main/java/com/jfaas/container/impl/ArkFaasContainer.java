package com.jfaas.container.impl;

import java.io.File;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

import com.alipay.sofa.ark.container.pipeline.RegisterServiceStage;
import com.alipay.sofa.ark.container.service.ArkServiceContainer;
import com.alipay.sofa.ark.spi.model.Plugin;
import com.alipay.sofa.ark.spi.registry.ServiceReference;
import com.alipay.sofa.ark.spi.service.extension.ArkServiceLoader;
import com.alipay.sofa.ark.spi.service.extension.ExtensionLoaderService;
import com.alipay.sofa.ark.spi.service.plugin.PluginFactoryService;
import com.alipay.sofa.ark.spi.service.plugin.PluginManagerService;
import com.jfaas.container.core.FaasContainer;
import com.jfaas.domain.core.Bundle;
import com.jfaas.domain.core.BundleInfo;
import com.jfaas.domain.core.impl.BundleImpl;

/**
 * @author : neason-cn
 * @date : 2021/10/28
 */
public class ArkFaasContainer implements FaasContainer {

    private ArkServiceContainer arkServiceContainer;
    private PluginManagerService pluginManagerService;
    private PluginFactoryService pluginFactoryService;
    private AtomicBoolean stopped = new AtomicBoolean(false);

    public ArkFaasContainer(String[] args) {
        this.arkServiceContainer = new ArkServiceContainer(args);
    }

    @Override
    public <T> T getBean(Class<T> clazz) {
        return arkServiceContainer.getService(clazz);
    }

    @Override
    public <T> Bundle<T> load(BundleInfo<T> bundleInfo) throws Exception {
        String bundlePath = bundleInfo.getBundleURL().getFile();
        Plugin plugin = pluginFactoryService.createPlugin(new File(bundlePath));
        pluginManagerService.registerPlugin(plugin);
        plugin.start();
        ServiceReference<T> serviceReference = plugin.getPluginContext().referenceService(bundleInfo.getSpiClass());
        return new BundleImpl<>(serviceReference.getService());
    }

    @Override
    public <T> Set<Bundle<T>> getAllBundles() {
        return null;
    }

    @Override
    public void start() {
        arkServiceContainer.start();
        arkServiceContainer.getService(RegisterServiceStage.class).process(null);
        ArkServiceLoader.setExtensionLoaderService(arkServiceContainer.getService(ExtensionLoaderService.class));
        this.pluginManagerService = arkServiceContainer.getService(PluginManagerService.class);
        this.pluginFactoryService = arkServiceContainer.getService(PluginFactoryService.class);
    }

    @Override
    public void stop() {
        arkServiceContainer.stop();
    }

    @Override
    public boolean isStarted() {
        return arkServiceContainer.isStarted();
    }

    @Override
    public boolean isRunning() {
        return arkServiceContainer.isRunning();
    }

    @Override
    public boolean isStopped() {
        return stopped.get();
    }
}
