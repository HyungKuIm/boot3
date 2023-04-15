package com.oraclejava;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Integer>{
    //정렬
    List<Movie> findAll(Sort sort);
    //페이징
    Page<Movie> findAll(Pageable pageable);
}
