package com.thulani.controller;

import com.thulani.entity.Textbook;
import com.thulani.factory.TextbookFactory;
import com.thulani.service.impl.TextbookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

/**
 * @author aelmick
 * Des: Textbook Controller
 * date: 27 September 2020
 */

@RestController
@RequestMapping("/textbook")
public class TextbookController
{

    @Autowired
    private TextbookServiceImpl textbookService;

    @PostMapping("/create")
    public Textbook create(@RequestBody Textbook textbook)
    {
        Textbook newTextbook = TextbookFactory.createTextbook(textbook.getBookName(), textbook.getBookEdition(),textbook.getBookDescription(), textbook.getBookISBN(), textbook.getBookVolume(), textbook.getBookPrice());
        return textbookService.create(newTextbook);
    }

    @GetMapping("all")
    public Set<Textbook> getall()
    {
        return textbookService.getAll();
    }
}
