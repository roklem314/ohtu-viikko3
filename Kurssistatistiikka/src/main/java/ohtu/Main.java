package ohtu;

import com.google.gson.Gson;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.util.Scanner;
import org.apache.http.client.fluent.Request;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
// vaihda oma opiskelijanumerosi seuraavaan, ÄLÄ kuitenkaan laita githubiin omaa opiskelijanumeroasi
//        String studentNr = "011120775";
        System.out.println("opiskelijanumero: ");      
        String studentNr = scanner.next();
        if (args.length > 0) {
            studentNr = args[0];
        }
        String url = "https://studies.cs.helsinki.fi/ohtustats/students/" + studentNr + "/submissions";
        String bodyText = Request.Get(url).execute().returnContent().asString();
//        System.out.println("json-muotoinen data:");
//        System.out.println(bodyText);

        Gson mapper = new Gson();
        Submission[] subs = mapper.fromJson(bodyText, Submission[].class);

//        System.out.println("Oliot:");
        System.out.println("");
        int summa = 0;
        int h = 0;
        for (Submission submission : subs) {
            summa += submission.getExercies().size();
            h += submission.getHours();
            System.out.println(" " +submission.toString());
        }
        System.out.println("");
        System.out.println("yhteensä: " + summa + " tehtävää " + h + " tuntia");
    }
}
