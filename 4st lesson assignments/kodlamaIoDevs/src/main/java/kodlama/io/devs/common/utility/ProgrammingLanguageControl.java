package kodlama.io.devs.common.utility;

import kodlama.io.devs.entities.concretes.ProgrammingLanguage;

import java.util.List;

public final class ProgrammingLanguageControl {
    public static boolean nameControl(ProgrammingLanguage programmingLanguage, List<ProgrammingLanguage> programmingLanguages) {
        for (ProgrammingLanguage language : programmingLanguages) {
            if (language.getName().equals(programmingLanguage.getName())) {
                return false;
            }
            if (language.getName().isEmpty()) {
                return false;
            }
        }
        return true;
    }
}
