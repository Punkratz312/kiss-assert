package com.kissassert;

import static org.apache.commons.collections4.CollectionUtils.isEmpty;
import static org.apache.commons.lang3.StringUtils.isBlank;

import java.util.Collection;
import java.util.Iterator;

import lombok.experimental.UtilityClass;

/**
 * @author <a href="mailto:vincent@potucek.com">Vincent Potucek</a>
 */
@UtilityClass
public class Assert {

    public static void notNull(Object o) {
        check(o == null, "Object", "null");
    }

    public static void notEmpty(String s) {
        check(isBlank(s), "String", "empty");
    }

    public static void notEmpty(Collection<?> collection) {
        check(isEmpty(collection), "Collection", "empty");
    }

    public static void notEmpty(Iterator<?> iterator) {
        check(iterator == null || !iterator.hasNext(), "Iterator", "empty");
    }

    private static void check(boolean failureCondition, String subject, String reason) {
        if (failureCondition) {
            // TODO enable exception type configuration
            throw new IllegalArgumentException("Expected " + subject + " not to be " + reason);
        }
    }
}
