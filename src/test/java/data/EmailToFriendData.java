package data;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class EmailToFriendData {
    private WebDriver driver;
    public EmailToFriendData(WebDriver driver){
        this.driver =driver;
    }

    public String friendEmail, MyEmail, Message;

    public void UserData() throws IOException, ParseException {
        String srcPFilePath = System.getProperty("user.dir")+"/src/test/java/data/emailToFriendData.json";
        File file = new File(srcPFilePath);

        JSONParser parser = new JSONParser();
        JSONArray jsonArray = (JSONArray) parser.parse(new FileReader(file));

        for (Object object : jsonArray){
            JSONObject person = (JSONObject) object;
            friendEmail = (String) person.get("friendEmail");
            MyEmail = (String) person.get("myEmail");
            Message = (String) person.get("Message");

        }
}}
