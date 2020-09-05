package service;

/**
 * @author aelmick
 * Des: StringHelper class
 * date: 05 September 2020
 */

import entity.Textbook;
import java.util.Set;

public interface TextbookService extends IService<Textbook, String>{
    Set<Textbook> getAll();
}
