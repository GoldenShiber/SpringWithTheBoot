package translations;

import java.io.Serializable;
import java.util.Objects;

public class TranslationKey implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3965208982077846313L;
	private String language;
	private	String word;
	
	public TranslationKey() {
		
	}

	public TranslationKey(String language, String word) {
		this.language = language;
		this.word = word;
	}
	
	@Override
	public boolean equals(Object o) {
		if(this == o) return true;
		if(o == null || getClass() != o.getClass()) return false;
		TranslationKey translationKey = (TranslationKey) o;
		return language.equals(translationKey.language) && 
				word.equals(translationKey.word);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(language, word);
	}
	
	public String getLanguage() {
		return language;
	}
	
	public String getword() {
		return word;
	}
}
