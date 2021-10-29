package com.jfaas.domain.core.impl;

import com.jfaas.domain.core.Bundle;

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
    public T getInstance() {
        return this.instance;
    }

}
