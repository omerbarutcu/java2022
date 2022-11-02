package kodlama.io.devs.webApi.controllers;

import kodlama.io.devs.business.abstracts.ProgrammingLanguageService;
import kodlama.io.devs.entities.concretes.ProgrammingLanguage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/programminglanguages")
public class ProgrammingLanguageController {
    private ProgrammingLanguageService programmingLanguageService;

    @Autowired
    public ProgrammingLanguageController(ProgrammingLanguageService programmingLanguageService) {
        this.programmingLanguageService = programmingLanguageService;
    }

    @PostMapping("/add")
    public void add(@RequestBody ProgrammingLanguage programmingLanguage) throws Exception {
        programmingLanguageService.add(programmingLanguage);
    }

    @PutMapping("/update")
    public void update(@RequestBody ProgrammingLanguage programmingLanguage) {
        programmingLanguageService.update(programmingLanguage);
    }

    @DeleteMapping("/delete")
    public void delete(@PathVariable int id) {
        programmingLanguageService.delete(id);
    }

    @GetMapping("/getall")
    public List<ProgrammingLanguage> getAll() {
        return programmingLanguageService.getAll();
    }

    @GetMapping("/getbyid")
    public ProgrammingLanguage getById(@PathVariable int id) {
        return programmingLanguageService.getById(id);
    }
}
