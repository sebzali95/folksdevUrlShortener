package folksdevUrlShortener.folksdevUrlShortener.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ShortUrlDto {


    private Long id;
    private String url;
    private String code;
}
