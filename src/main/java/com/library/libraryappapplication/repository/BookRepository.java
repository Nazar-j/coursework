package com.library.libraryappapplication.repository;

import com.library.libraryappapplication.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    void deleteByTitleAndFirstNameAndLastName(String title, String firstName, String lastName);

    List<Book> findAllByOrderByLastNameAsc();

    List<Book> findAllByOrderByPublishYearAsc();
}
