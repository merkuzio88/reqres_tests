package models;

import lombok.Data;

import java.util.Date;

@Data
public class UserGetResponseBody {

    public String name;
    public String job;
    public String id;
    public Date createdAt;
}
