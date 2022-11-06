package kodlama.io.devs.webApi.controllers;

import kodlama.io.devs.business.abstracts.ProgrammingLanguageSubTechnologyService;
import kodlama.io.devs.entities.concretes.ProgrammingLanguageSubTechnology;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(name = "api/languagesubtechnologies")
public class ProgrammingLanguageSubTechnologyController {
    ProgrammingLanguageSubTechnologyService technologyService;

    @Autowired
    public ProgrammingLanguageSubTechnologyController(ProgrammingLanguageSubTechnologyService technologyService) {
        this.technologyService = technologyService;
    }

    @PostMapping("/add")
    public void add(@RequestParam int id,@RequestBody ProgrammingLanguageSubTechnology languageSubTechnology) throws Exception {
        technologyService.add( languageSubTechnology,id);
    }

    @PutMapping("/update")
    public void update(@RequestBody ProgrammingLanguageSubTechnology languageSubTechnology) throws Exception {
        technologyService.update(languageSubTechnology);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id) {
        technologyService.delete(id);
    }

    @GetMapping("/getall")
    public List<ProgrammingLanguageSubTechnology> getAll() {
        return technologyService.getAll();
    }

    @GetMapping("/{id}")
    public ProgrammingLanguageSubTechnology findById(@PathVariable int id) {
        return technologyService.findById(id);
    }
}
