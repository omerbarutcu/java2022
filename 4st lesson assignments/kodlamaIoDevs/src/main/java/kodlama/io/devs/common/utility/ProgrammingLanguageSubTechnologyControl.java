package kodlama.io.devs.common.utility;

import kodlama.io.devs.dataAccess.abstracts.ProgrammingLanguageSubTechnologyRepository;
import kodlama.io.devs.entities.concretes.ProgrammingLanguageSubTechnology;

import java.util.List;

public class ProgrammingLanguageSubTechnologyControl {

    public static boolean programmingLanguageSubTechnologyNameControl(ProgrammingLanguageSubTechnology languageSubTechnology, List<ProgrammingLanguageSubTechnology> languageSubTechnologies) {
        for (ProgrammingLanguageSubTechnology technology : languageSubTechnologies) {
            if (technology.getName().equalsIgnoreCase(languageSubTechnology.getName())) {
                return false;
            }
            if (technology.getName().isEmpty()) {
                return false;
            }
        }
        return true;
    }
}
