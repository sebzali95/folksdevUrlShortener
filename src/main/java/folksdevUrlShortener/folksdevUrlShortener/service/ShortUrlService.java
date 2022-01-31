package folksdevUrlShortener.folksdevUrlShortener.service;


import folksdevUrlShortener.folksdevUrlShortener.exception.CodeAlreadyExists;
import folksdevUrlShortener.folksdevUrlShortener.exception.ShortUrlNotFoundException;
import folksdevUrlShortener.folksdevUrlShortener.model.ShortUrl;
import folksdevUrlShortener.folksdevUrlShortener.repository.ShortUrlRepository;
import folksdevUrlShortener.folksdevUrlShortener.util.RandomStringGenerator;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShortUrlService {

    private final ShortUrlRepository repository;
    private final RandomStringGenerator randomStringGenerator;


    public ShortUrlService(ShortUrlRepository shortUrlRepository, ShortUrlRepository repository, RandomStringGenerator randomStringGenerator) {
        this.repository = repository;
        this.randomStringGenerator = randomStringGenerator;
    }

    public List<ShortUrl> getAllShortUrl() {
        return repository.findAll();
    }

    public ShortUrl getUrlByCode(String code) {

        return repository.findAllByCode(code).orElseThrow(
                () -> new ShortUrlNotFoundException("url not found!")
        );
    }

    public ShortUrl create(ShortUrl shortUrl) {
        if (shortUrl.getCode() == null || shortUrl.getCode().isEmpty()) {
            shortUrl.setCode(generateCode());
        }
        else if (repository.findAllByCode(shortUrl.getCode()).isPresent()) {
            throw new CodeAlreadyExists("code already exists");
        }
        shortUrl.setCode(shortUrl.getCode().toUpperCase());
        return repository.save(shortUrl);
    }

    private String generateCode() {
        String code;

        do {
            code = randomStringGenerator.generateRandomString();
        }
        while (repository.findAllByCode(code).isPresent());

        return code;

    }

}
