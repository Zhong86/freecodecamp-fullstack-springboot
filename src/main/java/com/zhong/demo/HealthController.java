package com.zhong.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/health")
public class HealthController {

  @Autowired
  private MongoTemplate mongoTemplate;

  @GetMapping
  public ResponseEntity<String> checkConnection() {
    try {
      org.bson.Document result = mongoTemplate.getDb()
      .runCommand(new org.bson.Document("connectionStatus", 1));

      org.bson.Document authInfo = (org.bson.Document) result.get("authInfo");

      return ResponseEntity.ok("Connected to db: " + mongoTemplate.getDb().getName() 
        + "\nAuth info: " + authInfo.toJson());
    } catch (Exception e) {
      return ResponseEntity.status(500).body("Failed: " + e.getMessage());
    }
  }
}
