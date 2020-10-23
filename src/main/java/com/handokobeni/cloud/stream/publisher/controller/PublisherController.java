package com.handokobeni.cloud.stream.publisher.controller;

import com.handokobeni.cloud.stream.publisher.entity.Author;
import com.handokobeni.cloud.stream.publisher.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PublisherController {

    @Autowired
    private MessageChannel output;

    @PostMapping("/publish")
    public Book publishBook(@RequestBody Book book) {
        output.send(MessageBuilder.withPayload(book).build());

        return book;
    }

    @PostMapping("/author")
    public Author publishAuthor(@RequestBody Author author) {
        output.send(MessageBuilder.withPayload(author).build());

        return author;
    }
}
