package musachowdhury.chatbot;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;

public class Reply {

    static public String getAns(String tmp) {
        tmp = tmp.toLowerCase() + "  ";
        String toReturn = "Sry, I don't know about this.\nUse our News Section to find more ";
        if (tmp.contains("update") || tmp.contains("death") || tmp.contains("death rate") || (tmp.contains("many") && (tmp.contains("infected") || tmp.contains("death") || tmp.contains("recovered"))) || tmp.contains("live") || tmp.contains("situation") || tmp.contains("global")) {

            try {

                Document doc = Jsoup.connect("https://www.worldometers.info/coronavirus/?utm_campaign=homeAdvegas1?").get();
                Elements hold = doc.select(".maincounter-number");
                ArrayList<String> values = new ArrayList<String>();
                for (Element x : hold) {
                    String bfr = x.select("span").toString();
                    values.add((bfr.substring(bfr.indexOf(">") + 1, bfr.indexOf("</"))).replace(",", ""));
                }

                return "Scrapped from the Website\n\n" + "https://www.worldometers.info/coronavirus/\n\n" + "Global Report: \n\n" + "Total Cases : " + values.get(0) + "\n" + "Total Recovered : " + values.get(1) + "\n" + "Total Death : " + values.get(2) + "\n" + "Death Rate : " + (int) ((Double.parseDouble(values.get(1)) / Double.parseDouble(values.get(0))) * 100) + " %";


            } catch (Exception e) {
                return "No Internet Connection Is Detected\n" + "Or Website is not reachable right now ";
            }

        } else if (tmp.contains("hello") || tmp.contains("hi ") || tmp.contains("hlw ") || tmp.contains("hey ") || tmp.contains("greeting") || tmp.contains("whatsup") || tmp.contains("whats up")) {
            return "Hey !";
        } else if (tmp.indexOf("vaccine") != -1 || tmp.indexOf("cure") != -1 || tmp.indexOf("curable") != -1 || tmp.indexOf("medicine") != -1 || tmp.indexOf("remedy") != -1 || tmp.indexOf("treatment") != -1 || tmp.indexOf("drug") != -1) {
            return "Currently there is no medicine is founded to cure this virus.\n" + "But good news is many prototypes of vaccine is at final stage to release.";
        } else if (tmp.contains("about") || tmp.contains("origin") || tmp.contains("details") || tmp.contains("detail") || tmp.contains("begins") || tmp.contains("started") || tmp.contains("begin") || tmp.contains("appeared") || tmp.contains("information") || tmp.contains("covid") || tmp.contains("corona")) {
            return "Corona viruses (CoV) are a large family of viruses\n that cause illness ranging from the common cold to more severe diseases.\n It was was firs discovered in China";
        } else if (tmp.contains("safety") || tmp.contains("safe")) {
            return "Regularly and thoroughly clean your hands with an alcohol-based hand rub or wash them with soap and water.\n\n" + "Maintain at least 1 metre (3 feet) distance between yourself and others.\n\n" + "Stay home and self-isolate even with minor symptoms such as cough, headache, mild fever, until you recover.\n\n" + "Quit smoking";
        } else if (tmp.indexOf("affected") != -1 || tmp.indexOf("spread") != -1 || tmp.indexOf("infected") != -1 || tmp.indexOf("transmit") != -1 || tmp.indexOf("transmission") != -1 || tmp.indexOf("caught") != -1 || tmp.indexOf("catch") != -1) {
            return "It is super spreader. The followings ways it can transmit\n\n" + "Respiratory transmission\n" + "Aerosol transmission\n" + "Contact transmission\n" + "Also recently researchers think it might transmit through Air.";
        }
        return toReturn;

    }
}







