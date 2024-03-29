package folksdevUrlShortener.folksdevUrlShortener.util;

import javafx.print.Collation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.SecureRandom;
import java.util.Collections;
import java.util.stream.Collector;
import java.util.stream.Collectors;


@Component
public class RandomStringGenerator {

    @Value("${codeLength}")
    private int codeLength;

    public String generateRandomString() {

        SecureRandom random = new SecureRandom();
        String generated = "";


        var letters = "abcdefhgijklmnprstuvyzqw123456789"
                .toUpperCase()
                .chars()
                .mapToObj(x -> (char) x)
                .collect(Collectors.toList());

        Collections.shuffle(letters);

        for (int i = 0; i < codeLength; i++) {
            generated += letters.get(random.nextInt(letters.size()));
        }
        return generated;
    }
}
