package com.tanko.app.DTO;


import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PeopleDTO {
    String name;
    String nickname;
    Date birthday;
}
