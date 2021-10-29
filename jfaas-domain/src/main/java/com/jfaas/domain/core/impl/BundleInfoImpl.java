package com.jfaas.domain.core.impl;

import java.net.URL;

import com.jfaas.domain.core.BundleInfo;

/**
 * @author : neason-cn
 * @date : 2021/10/29
 */
public class BundleInfoImpl<T> implements BundleInfo<T> {

    private URL bundleURL;
    private Class<T> spiClass;

    public BundleInfoImpl(URL url, Class<T> spiClass) {
        this.bundleURL = url;
        this.spiClass = spiClass;
    }

    @Override
    public URL getBundleURL() {
        return this.bundleURL;
    }

    @Override
    public Class<T> getSpiClass() {
        return this.spiClass;
    }

}
