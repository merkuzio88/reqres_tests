package models;

import lombok.Data;

import java.util.Date;

@Data
public class UserUpdateResponseBody {

    public String name;
    public String job;
    public Date updatedAt;
}
