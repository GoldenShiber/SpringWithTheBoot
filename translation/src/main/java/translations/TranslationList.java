package translations;

import org.springframework.data.jpa.repository.JpaRepository;

interface TranslationList extends JpaRepository<Translation, TranslationKey> {

}