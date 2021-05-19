package cl.binter.challenge.infrastructure.providers.db;

import cl.binter.challenge.infrastructure.providers.db.model.DbText;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DbRepository extends JpaRepository<DbText, Long> {
    Optional<DbText> findById(Long id);

    @Query(value= "select id from text", nativeQuery = true)
    List<Long> getAllIds();

}
