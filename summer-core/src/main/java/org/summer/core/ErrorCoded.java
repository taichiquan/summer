package org.summer.core;

/**
 * @author yc
 * @date 2016/10/20
 * @description
 */
public interface ErrorCoded {

    static final String UNCODED = "uncoded";

    String getErrorCode();
}
