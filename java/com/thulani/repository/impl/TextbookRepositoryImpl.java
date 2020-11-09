//package com.thulani.repository.impl;
//
///**
// * @author aelmick
// * Des: StringHelper class
// * date: 29 August 2020
// */
//
//import com.thulani.entity.Textbook;
//import com.thulani.repository.TextbookRepository;
//
//import java.util.HashSet;
//import java.util.Set;
//
//
//@Deprecated
//public class TextbookRepositoryImpl implements TextbookRepository {
//
//    // Implementation of Singleton Design Pattern
//    private static TextbookRepository repository = null;
//    private Set<Textbook> textbookDB;
//
//    private TextbookRepositoryImpl()
//    {
//        this.textbookDB = new HashSet<Textbook>();
//    }
//
//    public static TextbookRepository getRepository()
//    {
//        if (repository == null)
//        {
//            repository = new TextbookRepositoryImpl();
//        }
//        return repository;
//    }
//
//    // Methods override from Repository Interface and TextbookRepository Interface
//    @Override
//    public Textbook create(Textbook textbook)
//    {
//        this.textbookDB.add(textbook);
//        return textbook;
//    }
//
//    public Textbook read(String id) {
//        Textbook textbook = this.textbookDB.stream().filter(book -> book.getBookId().trim().equalsIgnoreCase(id)).findAny().orElse(null);
//        return textbook;
////        for (Textbook textbook : this.textbookDB)
////        {
////            if (textbook.getBookId().equalsIgnoreCase(id))
////            {
////                return textbook;
////            }
////        }
////        return null;
//    }
//
//    @Override
//    public Textbook update(Textbook textbook)
//    {
//        boolean deleteTextbook = delete(textbook.getBookId());
//        if (deleteTextbook)
//        {
//            this.textbookDB.add(textbook);
//            return textbook;
//        }
//        return null;
//    }
//
//    @Override
//    public boolean delete(String id)
//    {
//        Textbook textbook = read(id);
//        if (textbook != null)
//        {
//            this.textbookDB.remove(textbook);
//            return true;
//        }
//        return false;
//    }
//
//    @Override
//    public Set<Textbook> getAll()
//    {
//        return this.textbookDB;
//    }
//}
