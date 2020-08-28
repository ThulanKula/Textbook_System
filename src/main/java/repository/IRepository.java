package repository;

public interface IRepository <Type> {
    Type create (Type type);
    Type read (Type type);
    Type update (Type type);
    void delete ();

}
