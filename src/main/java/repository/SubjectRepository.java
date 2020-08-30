package repository;
import entity.Subject;
import java.util.Set;

    public interface SubjectRepository extends IRepository<Subject, String>{
        Set<Subject> getAll();
    }

