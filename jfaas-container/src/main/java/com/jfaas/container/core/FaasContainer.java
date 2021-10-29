package com.jfaas.container.core;

import java.util.Set;

import com.jfaas.domain.common.LifeCycle;
import com.jfaas.domain.core.bundle.Bundle;
import com.jfaas.domain.core.bundle.BundleInfo;

/**
 * @author : neason-cn
 * @date : 2021/10/28
 */
public interface FaasContainer extends LifeCycle {

    /**
     * Get the bean instance which stored in faasContainer
     *
     * @param clazz
     * @param <T>
     * @return
     */
    <T> T getBean(Class<T> clazz);

    /**
     * Load and instantiate a bundle
     *
     * @param bundleInfo
     * @return
     * @throws Exception
     */
    <T> Bundle<T> load(BundleInfo<T> bundleInfo) throws Exception;

    /**
     * Get the all bundles of the container
     *
     * @return
     */
    <T> Set<Bundle<T>> getAllBundles();

}
