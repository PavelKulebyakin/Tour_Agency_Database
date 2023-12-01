package ru.mirea.database.data.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
public class NameIdDTO {

    protected Long id;
    protected String name;

    public static SortedMap<String, Long> toSortedMap(List<NameIdDTO> list){
        return list.stream().collect(Collectors
                .toMap(NameIdDTO::getName, NameIdDTO::getId, (key1, key2) -> key1, TreeMap::new));
    }
}
