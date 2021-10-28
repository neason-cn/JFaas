package com.jfaas.domain.common;

/**
 * @author : neason-cn
 * @date : 2021/10/28
 */
public interface LifeCycle {

    /**
     * Start the component.
     */
    void start();

    /**
     * Stop the component.
     */
    void stop();

    /**
     * Whether the component is started or not.
     * @return
     */
    boolean isStarted();

    /**
     * Whether the component is running or not.
     * @return
     */
    boolean isRunning();

    /**
     * Whether the component is stopped or not.
     * @return
     */
    boolean isStopped();

}
