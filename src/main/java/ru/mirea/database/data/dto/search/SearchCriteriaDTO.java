package ru.mirea.database.data.dto.search;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import ru.mirea.database.util.search.SearchCriteria;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SearchCriteriaDTO {

    @JsonProperty("search_criteria")
    protected List<SearchCriteria> searchCriteriaList;

}
