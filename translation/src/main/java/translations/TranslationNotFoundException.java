package translations;

class TranslationNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3606803441932271188L;

	TranslationNotFoundException(TranslationKey id) {
	    super("Could not find translation of the word:" + id.getword() +"of the " + id.getLanguage()+ "language!");
	  }
	}

