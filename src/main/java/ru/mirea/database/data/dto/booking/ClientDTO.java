package ru.mirea.database.data.dto.booking;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ClientDTO {

    protected String firstName;
    protected String lastName;
    protected String phoneNumber;
    protected String email;

}
