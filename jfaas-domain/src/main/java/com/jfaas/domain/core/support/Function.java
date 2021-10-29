package com.jfaas.domain.core.support;

/**
 * @author : neason-cn
 * @date : 2021/10/29
 */
public interface Function<I, O> {

    /**
     * The entrance of function
     *
     * @param input   the user input
     * @param context the system context
     * @return the result of function
     */
    O handle(I input, FunctionContext context);

}
