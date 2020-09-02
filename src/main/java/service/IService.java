package service;

/**
 * @Auhtor : Thulani Kula
 * Date: 02 Sept. 2020
 *
 * **/

public interface IService <Type, ID> {
    Type create (Type type);
    Type read (ID id);
    Type update (Type type);
    boolean delete (ID id);

}