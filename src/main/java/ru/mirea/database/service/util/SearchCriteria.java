package ru.mirea.database.service.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SearchCriteria {

    private String filterKey;
    private String operation;       // CustomSpecification.SearchOperation
    private Object value;
    private boolean orPredicate;

    public static SearchCriteria from(String key, String operation, Object value) {
        return new SearchCriteria(key, operation, value, false);
    }

    public static SearchCriteria from(String key, String operation, Object value, Boolean orPredicate) {
        return new SearchCriteria(key, operation, value, orPredicate);
    }

    public boolean isOrPredicate() {
        return orPredicate;
    }

}
