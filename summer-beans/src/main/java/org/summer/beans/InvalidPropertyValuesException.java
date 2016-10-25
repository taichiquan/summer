package org.summer.beans;

import org.summer.core.ErrorCoded;

import java.util.LinkedList;
import java.util.List;

/**
 * @author yc
 * @date 2016/10/24
 * @description
 */
public class InvalidPropertyValuesException extends BeansException {

    private List missingField = new LinkedList();
    private PropertyValues propertyValues;

    public InvalidPropertyValuesException(PropertyValues propertyValues) {
        super("InvalidPropertyValues");
        this.propertyValues = propertyValues;
    }

    public void addMissingField(String field, String errorCode) {
        missingField.add(new MissingFieldException(field, errorCode));
    }



    public static class MissingFieldException extends Exception implements ErrorCoded {

        private String missingField;
        private String errorCode = UNCODED;

        public MissingFieldException(String field, String errorCode) {
            super("Field '" + field + "' is required");
            this.missingField = field;
            this.errorCode = errorCode;
        }

        public String getMissingField() {
            return missingField;
        }

        public String getErrorCode() {
            return errorCode;
        }
    }

}

