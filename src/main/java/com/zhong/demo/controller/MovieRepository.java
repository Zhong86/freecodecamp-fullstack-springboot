package com.zhong.demo.controller;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.zhong.demo.Movie;

@Repository
public interface MovieRepository extends MongoRepository<Movie, ObjectId>{
}
