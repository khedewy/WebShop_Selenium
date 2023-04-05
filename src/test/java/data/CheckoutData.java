package data;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class CheckoutData {
    private WebDriver driver;
    public CheckoutData(WebDriver driver){
        this.driver =driver;
    }

    public String firstName,lastName, email, company, country, city, address1, address2, zip, phone, fax;

    public void UserData() throws IOException, ParseException {
        String srcPFilePath = System.getProperty("user.dir") + "/src/test/java/data/checkoutData.json";
        File file = new File(srcPFilePath);

        JSONParser parser = new JSONParser();
        JSONArray jsonArray = (JSONArray) parser.parse(new FileReader(file));

        for (Object object : jsonArray) {
            JSONObject person = (JSONObject) object;
            firstName = (String) person.get("firstName");
            lastName = (String) person.get("lastName");
            email = (String) person.get("email");
            company = (String) person.get("company");
            country = (String) person.get("country");
            city = (String) person.get("city");
            address1 = (String) person.get("address1");
            address2 = (String) person.get("address2");
            zip = (String) person.get("zip");
            phone = (String) person.get("phone");
            fax = (String) person.get("fax");
        }
    }
}
