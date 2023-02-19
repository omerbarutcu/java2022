package kodlama.io.devs.business.requests;

import kodlama.io.devs.business.concretes.ProgrammingLanguageManager;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateProgrammingLanguageSubTechnologyRequest {
    private String name;
    private String languageName;
}
