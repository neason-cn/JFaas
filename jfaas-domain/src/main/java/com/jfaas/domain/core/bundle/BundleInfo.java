package com.jfaas.domain.core.bundle;

import java.net.URL;

/**
 * @author : neason-cn
 * @date : 2021/10/29
 */
public interface BundleInfo<T> {

    URL getBundleURL();

    Class<T> getSpiClass();

}
