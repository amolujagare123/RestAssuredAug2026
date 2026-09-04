import io.restassured.path.json.JsonPath;
import junit.framework.Assert;

public class ComplexJson {

    public static void main(String[] args) {

        String respStr = "{\n" +
                "  \"dashboard\": {\n" +
                "    \"purchaseAmount\": 1162,\n" +
                "    \"website\": \"scriptinglogic.com\"\n" +
                "  },\n" +
                "  \"courses\": [\n" +
                "    {\n" +
                "      \"title\": \"Selenium Python\",\n" +
                "      \"price\": 50,\n" +
                "      \"copies\": 6\n" +
                "    },\n" +
                "    {\n" +
                "      \"title\": \"Cypress\",\n" +
                "      \"price\": 40,\n" +
                "      \"copies\": 4\n" +
                "    },\n" +
                "    {\n" +
                "      \"title\": \"RPA\",\n" +
                "      \"price\": 45,\n" +
                "      \"copies\": 10\n" +
                "    },\n" +
                "    {\n" +
                "      \"title\": \"Appium\",\n" +
                "      \"price\": 36,\n" +
                "      \"copies\": 7\n" +
                "    }\n" +
                "  ]\n" +
                "}";

        JsonPath jsonPath = new JsonPath(respStr);

        // 1. Print No of courses returned by API
        int totalCourses = jsonPath.get("courses.size()");
        System.out.println("totalCourses="+totalCourses);


        //  2.Print Purchase Amount
        int purchaseAmount = jsonPath.get("dashboard.purchaseAmount");
        System.out.println("purchaseAmount="+purchaseAmount);


        // 3. Print Title of the first course

        String title = jsonPath.get("courses[0].title");
        System.out.println("title="+title);


        // 4. Print All course titles and their respective Prices
        System.out.println("=========================");
        System.out.println("Title\tPrice");
        System.out.println("=========================");
        for(int i=0;i<totalCourses;i++) {
             title = jsonPath.get("courses["+i+"].title");
             int price = jsonPath.get("courses["+i+"].price");

            System.out.println(title+"\t"+price);

        }



        // 5. Print no of copies sold by RPA Course
        int copies=0;
        for(int i=0;i<totalCourses;i++) {

            title = jsonPath.get("courses["+i+"].title");

            if( title.equals("RPA"))
               copies = jsonPath.get("courses["+i+"].copies");
        }

        System.out.println("Copies by RPA="+copies);



            // 6. Verify if Sum of all Course prices matches with Purchase Amount

        int sum = 0 ;
        for (int i=0 ; i<totalCourses ;i++)
        {
            copies = jsonPath.get("courses["+i+"].copies");
            int price = jsonPath.get("courses["+i+"].price");

            sum = sum + (copies * price);
        }

        System.out.println("sum="+sum);
        purchaseAmount = jsonPath.get("dashboard.purchaseAmount");
        System.out.println("purchaseAmount="+purchaseAmount);

        Assert.assertEquals(purchaseAmount,sum);
    }
}
