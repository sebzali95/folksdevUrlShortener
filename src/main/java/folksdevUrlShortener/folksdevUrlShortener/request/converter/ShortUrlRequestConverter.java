package folksdevUrlShortener.folksdevUrlShortener.request.converter;


import folksdevUrlShortener.folksdevUrlShortener.model.ShortUrl;
import folksdevUrlShortener.folksdevUrlShortener.request.ShortUrlRequest;
import org.springframework.stereotype.Component;

@Component
public class ShortUrlRequestConverter {

    public ShortUrl convertToEntity(ShortUrlRequest shortUrlRequest){
        return ShortUrl.builder()
                .url(shortUrlRequest.getUrl())
                .code(shortUrlRequest.getCode())
                .build();
    }


}
