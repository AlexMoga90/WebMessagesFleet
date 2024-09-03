package messagingapp.service;

import messagingapp.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.messagingapp.repository.MessageRepository;

import java.util.List;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public List<Message> getMessagesForUser(String receiverPhoneNumber) {
        return messageRepository.findByReceiverPhoneNumber(receiverPhoneNumber);
    }

    public void sendMessage(String senderPhoneNumber, String receiverPhoneNumber, String content) {
        Message message = new Message();
        message.setSenderPhoneNumber(senderPhoneNumber);
        message.setReceiverPhoneNumber(receiverPhoneNumber);
        message.setContent(content);
        messageRepository.save(message);

    }
}
