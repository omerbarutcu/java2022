package kodlama.io.rentACar.core.utilities.exceptions;

import lombok.*;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ValidationProblemDetails extends ProblemDetails{
    private Map<String,String> validationErrors;
}
