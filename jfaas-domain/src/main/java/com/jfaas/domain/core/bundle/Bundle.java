package com.jfaas.domain.core.bundle;

import java.net.URL;

/**
 * @author : neason-cn
 * @date : 2021/10/29
 */
public interface Bundle<T> {

    String getBundleId();

    URL getBundleURL();

    T getInstance();

    ClassLoader getBundleClassLoader();

    String getStatus();

}
