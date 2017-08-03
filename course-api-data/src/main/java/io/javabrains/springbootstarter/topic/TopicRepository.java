package io.javabrains.springbootstarter.topic;

import org.springframework.data.repository.CrudRepository;

interface TopicRepository extends CrudRepository<Topic, String> { }