package uz.pdp.g33hateoas;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ErrorResponseDTO {
    private String error;
    private String message;
    private final LocalDateTime time = LocalDateTime.now();

    public ErrorResponseDTO(String error, String message) {
        this.error = error;
        this.message = message;
    }
}
