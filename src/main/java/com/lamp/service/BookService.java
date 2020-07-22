package com.lamp.service;

import com.lamp.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class BookService {
   // @Qualifier( "bookDao")
    @Autowired
    BookDao B;
    public   void display(){
         System.out.println(B);
    }
}
