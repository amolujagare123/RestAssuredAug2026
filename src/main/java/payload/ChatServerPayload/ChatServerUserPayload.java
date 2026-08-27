package payload.ChatServerPayload;

public class ChatServerUserPayload {


    public static String getChatServerUserPayload(String username,String password,String email,String name,String surname,String nickName)
    {
      String payload = "{\n" +
              "  \"username\": \""+username+"\",\n" +
              "  \"password\": \""+password+"\",\n" +
              "  \"email\": \""+email+"\",\n" +
              "  \"name\": \""+name+"\",\n" +
              "  \"surname\": \""+surname+"\",\n" +
              "  \"chat_nickname\": \""+nickName+"\",\n" +
              "  \"departments\": [\n" +
              "    1,\n" +
              "    2\n" +
              "  ],\n" +
              "  \"departments_read\": [\n" +
              "    2\n" +
              "  ],\n" +
              "  \"department_groups\": [\n" +
              "    1\n" +
              "  ],\n" +
              "  \"user_groups\": [\n" +
              "    1\n" +
              "  ]\n" +
              "}";

              return payload;
    }
}
