package ru.mirea.database.data.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import ru.mirea.database.util.SearchCriteria;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class HousingSearchDTO {

    private List<SearchCriteria> searchCriteriaList;

}
