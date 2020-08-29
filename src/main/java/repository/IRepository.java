package repository;

public interface IRepository <Type, ID> {
    Type create (Type type);
    Type read (ID id);
    Type update (Type type);
    boolean delete (ID id);

}
