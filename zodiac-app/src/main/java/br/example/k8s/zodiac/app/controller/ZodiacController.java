package br.example.k8s.zodiac.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ZodiacController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ZodiacController.class);

    @Value("${app.zodiac.name}")
    private String appName;

    @Value("${app.zodiac.version}")
    private String version;
    
    @Value("${app.zodiac.message}")
    private String message;

    @GetMapping(value = "/zodiac/{month}/{day}", produces = {"application/json"})
    public String getSunSign(@PathVariable("month") int month, @PathVariable("day") int day) {

        LOGGER.info("Request received!!! Month : {}, Day : {}", month, day);

        String sunSign = null;

        if ((month == 12 && day >= 22 && day <= 31) || (month == 1 && day >= 1 && day <= 19))
            sunSign = "Capricorn";
        else if ((month == 1 && day >= 20 && day <= 31) || (month == 2 && day >= 1 && day <= 17))
            sunSign = "Aquarius";
        else if ((month == 2 && day >= 18 && day <= 29) || (month == 3 && day >= 1 && day <= 19))
            sunSign = "Pisces";
        else if ((month == 3 && day >= 20 && day <= 31) || (month == 4 && day >= 1 && day <= 19))
            sunSign = "Aries";
        else if ((month == 4 && day >= 20 && day <= 30) || (month == 5 && day >= 1 && day <= 20))
            sunSign = "Taurus";
        else if ((month == 5 && day >= 21 && day <= 31) || (month == 6 && day >= 1 && day <= 20))
            sunSign = "Gemini";
        else if ((month == 6 && day >= 21 && day <= 30) || (month == 7 && day >= 1 && day <= 22))
            sunSign = "Cancer";
        else if ((month == 7 && day >= 23 && day <= 31) || (month == 8 && day >= 1 && day <= 22))
            sunSign = "Leo";
        else if ((month == 8 && day >= 23 && day <= 31) || (month == 9 && day >= 1 && day <= 22))
            sunSign = "Virgo";
        else if ((month == 9 && day >= 23 && day <= 30) || (month == 10 && day >= 1 && day <= 22))
            sunSign = "Libra";
        else if ((month == 10 && day >= 23 && day <= 31) || (month == 11 && day >= 1 && day <= 21))
            sunSign = "Scorpio";
        else if ((month == 11 && day >= 22 && day <= 30) || (month == 12 && day >= 1 && day <= 21))
            sunSign = "Sagittarius";
        else
            sunSign = "Illegal date";

        LOGGER.info("Sunsign : {}", sunSign);

        return "{\n" +
                "\t\"application\": \"" + appName + "\",\n" +
                "\t\"version\": \"" + version + "\",\n" +
                "\t\"response\": \"" + sunSign + "\",\n" +
                "\t\"message\": \"" + message + "\"\n" +
                "}";
    }
}
