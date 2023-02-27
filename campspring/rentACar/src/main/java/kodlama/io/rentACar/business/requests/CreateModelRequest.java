package kodlama.io.rentACar.business.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateModelRequest {
    @NotNull
    @NotBlank
    @Size(min = 3, max = 20)
    private String name;
    @NotNull
    @NotBlank
    private int brandId;
}
