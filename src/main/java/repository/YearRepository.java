package repository;
/**
 *  @Author : Thulani Kula
 *  * Date : 25 August 2020
 *
 * **/
import entity.Year;
import java.util.Map;
import java.util.Set;

public interface YearRepository extends IRepository<Year, String> {
    Set<Year> getAll();
}
