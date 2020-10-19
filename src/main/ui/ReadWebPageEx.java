package ui;

import com.github.cliftonlabs.json_simple.JsonException;
import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsoner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class ReadWebPageEx {

    public static void readWeb() throws IOException {
        BufferedReader br = null;
        try {
//            String apikey = "60ed0dbd15fc3aeade1b199bbe57ee05";
//            String londonweatherquery = "https://api.openweathermap.org/data/2.5/weather?q=London,uk&mode=html&APPID=";
//            String theURL =
//            String theURL = "https://www.students.cs.ubc.ca/~cs-210/2018w1/welcomemsg.html"; //this can point to any URL
            URL url = new URL("https://api.openweathermap.org/data/2.5/weather?q=London,uk&APPID="
                    + "60ed0dbd15fc3aeade1b199bbe57ee05");
            br = new BufferedReader(new InputStreamReader(url.openStream()));

            String line;

            StringBuilder sb = new StringBuilder();

            whileHelper(br, sb);

//            System.out.println(sb);
            JsonObject json = (JsonObject) Jsoner.deserialize(sb.toString());
            System.out.println(json.get("coord"));
        } catch (JsonException e) {
            e.printStackTrace();
        } finally {

            if (br != null) {
                br.close();
            }
        }

    }

    private static void whileHelper(BufferedReader br, StringBuilder sb) throws IOException {
        String line;
        while ((line = br.readLine()) != null) {

            sb.append(line);
            sb.append(System.lineSeparator());
        }
    }
}

