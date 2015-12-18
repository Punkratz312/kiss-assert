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

    public static void notTrue(Boolean isTrue) {
        check(isTrue == null || isTrue, "Condition", "true");
    }

    public static void notFalse(Boolean isFalse) {
        check(isFalse == null || !isFalse, "Condition", "false");
    }

    public static void notNull(Object o) {
        notNull(o, "Object");
    }

    public static void notNull(Object o, String subject) {
        check(o == null, subject, "null");
    }

    public static void notEmpty(String s) {
        notEmpty(s, "String");
    }

    public static void notEmpty(String s, String subject) {
        check(isBlank(s), subject, "empty");
    }

    public static void notBlank(String s) {
        notBlank(s, "blank");
    }

    public static void notBlank(String s, String subject) {
        check(isBlank(s), subject, "blank");
    }

    public static void notEmpty(Collection<?> collection) {
        notEmpty(collection, "Collection");
    }

    public static void notEmpty(Collection<?> collection, String subject) {
        check(isEmpty(collection), subject, "empty");
    }

    public static void notEmpty(Iterator<?> iterator) {
        notEmpty(iterator, "Iterator");
    }

    public static void notEmpty(Iterator<?> iterator, String subject) {
        check(iterator == null || !iterator.hasNext(), subject, "empty");
    }

    private static void check(boolean failureCondition, String subject, String reason) {
        if (failureCondition) {
            // TODO enable exception type configuration
            throw new IllegalArgumentException("Expected " + subject + " not to be " + reason);
        }
    }
}
