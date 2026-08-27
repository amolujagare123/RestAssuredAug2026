package payload.GoRestPayload;

public class GoRestCreateUpdateUser {

    public static String getCreateUserPayload()
    {
        String payload = "{ \n" +
                " \"name\": \"Amol Ujagare\", \n" +
                " \"email\": \"amol.pune@gmail.com\", \n" +
                " \"gender\": \"male\", \n" +
                " \"status\": \"inactive\" \n" +
                "}";

        return payload;
    }

    public static String getCreateUserPayload(String name,String email,String gender,String status)
    {
        String payload = "{ \n" +
                " \"name\": \""+name+"\", \n" +
                " \"email\": \""+email+"\", \n" +
                " \"gender\": \""+gender+"\", \n" +
                " \"status\": \""+status+"\" \n" +
                "}";

        return payload;
    }

}
