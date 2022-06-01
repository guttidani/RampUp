import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.util.Arrays;
import java.util.List;

//import org.json.JSONObject;
@Slf4j
public class JsonParser {



    public static String ReadJsonFromFile(String path) {

        String line;
        String json="";

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            while ((line = br.readLine()) != null) {
                json+=line;
            }
            log.info("Read Json from: " + path);
            br.close();
        } catch (FileNotFoundException e) {
            System.out.println("file not found");
            log.info("File not found");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("There is some problem");
            log.info("There is some problem");
            e.printStackTrace();
        }

        return json;
    }

    public static void writeJsonToFile(String json, String path){
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(path));
            bw.write(json);
            log.info("Json write into file: " + path);
            bw.close();
        } catch (IOException e) {
            log.info("There is some problem");
            e.printStackTrace();
        }
    }
}
