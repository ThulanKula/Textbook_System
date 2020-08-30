package repository;

/**
 * @author aelmick
 * Des: StringHelper class
 * date: 29 August 2020
 */

import entity.Textbook;
import repository.IRepository;

import java.util.Set;

public interface TextbookRepository extends IRepository<Textbook, String> {
    Set<Textbook> getAll();
}
