package com.jfaas.container.core;

import com.jfaas.domain.common.LifeCycle;

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

}
