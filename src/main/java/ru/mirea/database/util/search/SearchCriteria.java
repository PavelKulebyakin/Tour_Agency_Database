package ru.mirea.database.util.search;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SearchCriteria {

    @JsonProperty("key")
    protected String filterKey;
    @JsonProperty("operation")
    protected String operation;
    @JsonProperty("value")//
    protected Object value;
    @JsonProperty("or")
    protected boolean orPredicate;

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
