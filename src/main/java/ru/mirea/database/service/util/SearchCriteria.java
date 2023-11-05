package ru.mirea.database.service.util;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SearchCriteria {

    @JsonProperty("key")
    private String filterKey;
    @JsonProperty("operation")
    private String operation;
    @JsonProperty("value")// CustomSpecification.SearchOperation
    private Object value;
    @JsonProperty("or")
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
