package com.example.bookmanager.repository;

import com.example.bookmanager.entity.UserBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserBookRepository extends JpaRepository<UserBook, Long> {

    //Comprueba si existe
    boolean existsByUserIdAndBookId(Long userId, Long bookId);
    List<UserBook> findByUserId(Long id);
    Optional<UserBook> findByUserIdAndBookId(Long userId, Long bookId);

    @Query("SELECT DISTINCT ub FROM UserBook ub JOIN FETCH ub.book b JOIN FETCH b.authors WHERE ub.user.id = :userId")
    List<UserBook> findByUserIdWithBookAndAuthors(@Param("userId") Long id);

}
