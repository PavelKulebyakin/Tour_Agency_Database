package ru.mirea.database.data.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import ru.mirea.database.service.util.SearchCriteria;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class HousingSearchDTO {

    @JsonProperty("search_criteria")
    private List<SearchCriteria> searchCriteriaList;

}
