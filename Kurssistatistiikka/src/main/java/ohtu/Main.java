package ohtu;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import org.apache.http.client.fluent.Request;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
// vaihda oma opiskelijanumerosi seuraavaan, ÄLÄ kuitenkaan laita githubiin omaa opiskelijanumeroasi
//        String studentNr = "011120775";
        String kurssinTiedot = "https://studies.cs.helsinki.fi/ohtustats/courseinfo";
        String text = Request.Get(kurssinTiedot).execute().returnContent().asString();
        Gson gson = new Gson();

        System.out.println(gson.fromJson(text, Kurssi.class));

        System.out.println("");
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
            System.out.println(" " + submission.toString());
        }
        System.out.println("");
        System.out.println("yhteensä: " + summa + " tehtävää " + h + " tuntia");

        String statsResponse = "https://studies.cs.helsinki.fi/ohtustats/stats";
        JsonParser parser = new JsonParser();
        String statsit = Request.Get(statsResponse).execute().returnContent().asString();

        int palautuksia = 0;
        int palautettaviaYht = 0;

        JsonObject parsittuData = parser.parse(statsit).getAsJsonObject();
        for (Map.Entry<String, JsonElement> JasonElement : parsittuData.entrySet()) {
            palautuksia += mapper.fromJson(JasonElement.getValue(), KurssiStatistiikka.class).getStudents();
            palautettaviaYht += mapper.fromJson(JasonElement.getValue(), KurssiStatistiikka.class).getExercise_total();

        }
        System.out.println("");

        System.out.println("Kurssilla yhteensä " + palautuksia + " palautusta, palautettuja tehtäviä " + palautettaviaYht + " kpl");
    }
}
