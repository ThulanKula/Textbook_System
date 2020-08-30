package repository;

/**
 *  @Author : Thulani Kula
 *  Date : 25 August 2020
 *
 * **/

public interface IRepository <Type, ID> {
    Type create (Type type);
    Type read (ID id);
    Type update (Type type);
    boolean delete (ID id);
}
