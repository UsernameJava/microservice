package com.one.two.ResourceProcessor.retry;

import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;

import static java.util.Objects.isNull;

public class ConditionalRetryPredicate implements Predicate<Map<String, Object>> {
    @Override
    public boolean test(Map<String, Object> stringObjectMap) {
        if (isNull(stringObjectMap) || isNull(stringObjectMap.get("id"))) {
            return false;
        }
        return true;
    }
}
