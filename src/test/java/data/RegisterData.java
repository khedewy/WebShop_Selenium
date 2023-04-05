package data;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class RegisterData {
    private WebDriver driver;
    public RegisterData(WebDriver driver){
        this.driver =driver;
    }

    public String firstName, lastName, email, Password;

    public void UserData() throws IOException, ParseException {
        String srcPFilePath = System.getProperty("user.dir")+"/src/test/java/data/registerData.json";
        File file = new File(srcPFilePath);

        JSONParser parser = new JSONParser();
        JSONArray jsonArray = (JSONArray) parser.parse(new FileReader(file));

        for (Object object : jsonArray){
            JSONObject person = (JSONObject) object;
            firstName = (String) person.get("firstName");
            lastName = (String) person.get("lastName");
            email = (String) person.get("email");
            Password = (String) person.get("password");

        }
    }
}
