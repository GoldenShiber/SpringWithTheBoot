package translations;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(TranslationKey.class)
class Translation {

  private String translation;
  @Id
  private String language;
  @Id
  private String word;

  Translation() {}

  Translation(String language, String word, String translation) {
	  this.language = language;
	  this.word = word;
	  this.translation = translation;
  }
  
  public String getLanguage() {
	    return this.language;
	  }
  
  public String getTranslation() {
    return this.translation;
  }
  
  public String getWord() {
	    return this.word;
	  }

  public void setLanguage(String language) {
    this.language = language;
  }

  public void setTranslation(String translation) {
    this.translation = translation;
  }

  public void setWord(String word) {
    this.word = word;
  }

  @Override
  public boolean equals(Object o) {

    if (this == o)
      return true;
    if (!(o instanceof Translation))
      return false;
    Translation translation = (Translation) o;
    return Objects.equals(this.translation, translation.translation) && Objects.equals(this.language, translation.language)
    		&& Objects.equals(this.word, translation.word);
    
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.translation, this.language, this.word);
  }

  @Override
  public String toString() {
    return "Translation{" + "translation=" + this.translation + ", language='" + this.getLanguage() + '\'' + ", word='" + this.getWord() + '\'' + '}';
  }
}
