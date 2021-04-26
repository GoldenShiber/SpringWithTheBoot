package translations;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class TranslationController {

  private final TranslationList repository;

  TranslationController(TranslationList repository) {
    this.repository = repository;
  }


  // Aggregate root
  // tag::get-aggregate-root[]
  @GetMapping("/translations")
  List<Translation> all() {
    return repository.findAll();
  }
  // end::get-aggregate-root[]
  
  
    @PostMapping("/translations")
  Translation newTranslation(@RequestBody Translation newTranslation) {
    return repository.save(newTranslation);
  }
   

  // Single item
  
  @GetMapping("/translations/{language}/{word}")
  Translation one(@PathVariable String language, @PathVariable String word) {
    TranslationKey id = new TranslationKey(language, word);
    return repository.findById(id)
      .orElseThrow(() -> new TranslationNotFoundException(id));
  }

  @PutMapping("/translations/{language}/{word}")
  Translation replaceTranslation(@RequestBody Translation newTranslation, @PathVariable String language, @PathVariable String word
		  ) {
	 TranslationKey id = new TranslationKey(language, word);
    return repository.findById(id)
      .map(translation -> {
        translation.setTranslation(newTranslation.getTranslation());
        translation.setLanguage(language);
        translation.setWord(word);
        return repository.save(translation);
      })
      .orElseGet(() -> {
        newTranslation.setLanguage(language);
        newTranslation.setWord(word);
        return repository.save(newTranslation);
      });
  }

  @DeleteMapping("/translations/{language}/{word}")
  void deleteTranslation(@PathVariable String language, @PathVariable String word) {
	TranslationKey id = new TranslationKey(language, word);
    repository.deleteById(id);
  }
}