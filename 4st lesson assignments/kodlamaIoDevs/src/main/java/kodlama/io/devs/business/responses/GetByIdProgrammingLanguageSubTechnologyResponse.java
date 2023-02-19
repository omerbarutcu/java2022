package kodlama.io.devs.business.responses;

import kodlama.io.devs.entities.concretes.ProgrammingLanguage;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetByIdProgrammingLanguageSubTechnologyResponse {
    private int id;
    private String name;
    private String languageName;
}
