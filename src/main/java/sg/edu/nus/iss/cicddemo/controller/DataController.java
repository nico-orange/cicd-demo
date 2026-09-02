package sg.edu.nus.iss.cicddemo.controller;

import com.github.javafaker.Faker;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class DataController {

    @GetMapping("/")
    public String healthCheck() {
        return "HEALTH CHECK OK!";
    }

    @GetMapping("/version")
    public String version() {
        return "The actual version is 1.0.0";
    }

    @GetMapping("/nations")
    public List<Map<String, String>> getRandomNations() {
        Faker faker = new Faker();
        List<Map<String, String>> nations = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            var nation = faker.nation();

            nations.add(Map.of(
                    "nationality", nation.nationality(),
                    "capitalCity", nation.capitalCity(),
                    "flag", nation.flag(),
                    "language", nation.language()
            ));
        }

        return nations;
    }

    @GetMapping("/currencies")
    public List<Map<String, String>> getRandomCurrencies() {
        Faker faker = new Faker();
        List<Map<String, String>> currencies = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            var currency = faker.currency();

            currencies.add(Map.of(
                    "name", currency.name(),
                    "code", currency.code()
            ));
        }

        return currencies;
    }
}