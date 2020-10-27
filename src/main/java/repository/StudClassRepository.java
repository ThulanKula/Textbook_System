package repository;
/**
 *Author: Lukanyo Tando Nkohla
 *  Student No. 218328877
 */
<<<<<<< Updated upstream:src/main/java/repository/StudClassRepository.java
import entity.StudClass;
import entity.Subject;
=======
import com.thulani.entity.StudClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
>>>>>>> Stashed changes:src/main/java/com/thulani/repository/StudClassRepository.java

import java.util.Set;
@Repository
public interface StudClassRepository extends JpaRepository<StudClass, String> {

}
