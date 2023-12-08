package ru.mirea.database.data.dto.booking;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientDTO {

    protected Long id;
    protected String firstName;
    protected String lastName;
    protected String phoneNumber;
    protected String email;

}
