package org.summer.core;

/**
 * @author yc
 * @date 2016/10/20
 * @description
 */
public interface ParameterizableErrorCoded extends ErrorCoded {

    Object[] getErrorArgs();
}
