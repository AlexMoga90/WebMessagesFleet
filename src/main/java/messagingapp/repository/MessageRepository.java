package com.example.messagingapp.repository;

import com.example.messagingapp.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {
    List<Message> findByReceiverPhoneNumber(String receiverPhoneNumber);
}

