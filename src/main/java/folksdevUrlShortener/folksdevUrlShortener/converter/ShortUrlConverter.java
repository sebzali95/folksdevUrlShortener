package folksdevUrlShortener.folksdevUrlShortener.converter;


import folksdevUrlShortener.folksdevUrlShortener.dto.ShortUrlDto;
import folksdevUrlShortener.folksdevUrlShortener.model.ShortUrl;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ShortUrlConverter {

    public ShortUrlDto convertToDto(ShortUrl shortUrl) {
        return ShortUrlDto.builder()
                .id(shortUrl.getId())
                .url(shortUrl.getUrl())
                .code(shortUrl.getCode())
                .build();

    }

    public List<ShortUrlDto> convertToDto(List<ShortUrl> shortUrl) {
        return shortUrl.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());

    }
}
