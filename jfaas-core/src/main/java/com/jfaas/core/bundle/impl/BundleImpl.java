package com.jfaas.core.bundle.impl;

import java.net.URL;

import com.jfaas.domain.core.bundle.Bundle;

/**
 * @author : neason-cn
 * @date : 2021/10/29
 */
public class BundleImpl<T> implements Bundle<T> {

    private T instance;

    public BundleImpl(T instance) {
        this.instance = instance;
    }

    @Override
    public String getBundleId() {
        return null;
    }

    @Override
    public URL getBundleURL() {
        return null;
    }

    @Override
    public T getInstance() {
        return this.instance;
    }

    @Override
    public ClassLoader getBundleClassLoader() {
        return null;
    }

    @Override
    public String getStatus() {
        return null;
    }

}
