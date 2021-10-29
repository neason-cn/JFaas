package com.jfaas.domain.core.bundle;

import com.jfaas.domain.exception.FaasRuntimeException;

/**
 * @author : neason-cn
 * @date : 2021/10/29
 */
public interface BundleActivator {

    /**
     * init bundle
     *
     * @param context
     * @throws FaasRuntimeException
     */
    void init(BundleContext context) throws FaasRuntimeException;

    /**
     * destroy bundle
     *
     * @param context
     * @throws FaasRuntimeException
     */
    void destroy(BundleContext context) throws FaasRuntimeException;

}
