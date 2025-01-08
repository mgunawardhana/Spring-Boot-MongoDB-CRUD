package com.example.mongodb.repository;

import com.example.mongodb.model.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Repository interface for User objects, extending MongoRepository.
 * Provides CRUD operations for User objects in the MongoDB database.
 */
public interface UserRepo extends MongoRepository<User, ObjectId> {
}