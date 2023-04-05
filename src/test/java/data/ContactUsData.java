package data;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ContactUsData {
    private WebDriver driver;
    public ContactUsData(WebDriver driver){
        this.driver =driver;
    }

    public String name, email, Message;

    public void UserData() throws IOException, ParseException {
        String srcPFilePath = System.getProperty("user.dir") + "/src/test/java/data/contactUsData.json";
        File file = new File(srcPFilePath);

        JSONParser parser = new JSONParser();
        JSONArray jsonArray = (JSONArray) parser.parse(new FileReader(file));

        for (Object object : jsonArray) {
            JSONObject person = (JSONObject) object;
            name = (String) person.get("name");
            email = (String) person.get("email");
            Message = (String) person.get("message");

        }
    }}