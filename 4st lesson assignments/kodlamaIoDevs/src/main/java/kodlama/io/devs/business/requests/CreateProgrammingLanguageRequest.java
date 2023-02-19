package kodlama.io.devs.business.requests;

import kodlama.io.devs.business.concretes.ProgrammingLanguageManager;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateProgrammingLanguageRequest {
    private String name;


}
