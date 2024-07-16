package models;

import lombok.Data;

@Data
public class UserGetResponseBody {

    public Data data;
    public Support support;

    public static class Data{
        public int id;
        public String email;
        public String first_name;
        public String last_name;
        public String avatar;
    }

    public static class Support{
        public String url;
        public String text;
    }
}
