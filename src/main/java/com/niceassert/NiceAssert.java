package com.niceassert;

import static org.apache.commons.lang3.StringUtils.isBlank;

import java.util.Collection;
import java.util.Iterator;

import lombok.experimental.UtilityClass;
import org.apache.commons.collections4.CollectionUtils;

@UtilityClass
public class NiceAssert {

    public static void notNull(Object o) {
        check(o == null, "Object", "not null");
    }

    public static void notEmpty(String s) {
        check(isBlank(s), "String to be not empty", "empty");
    }

    public static void notEmpty(Collection<?> collection) {
        check(CollectionUtils.isEmpty(collection), "Collection", "empty");
    }

    public static void notEmpty(Iterator<?> iterator) {
        check(!iterator.hasNext(), "Collection", "empty");
    }

    private static void check(boolean failureCondition, String subject, String reason) {
        if (failureCondition) {
            throw new IllegalArgumentException("Expected " + subject + " not to be " + reason);
        }
    }
}
