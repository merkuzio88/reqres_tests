package models;

import lombok.Data;

import java.util.Date;

@Data
public class UserCreateResponseBody {

    public String name;
    public String job;
    public String id;
    public Date createdAt;
}
