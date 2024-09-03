package messagingapp.controller;

import messagingapp.model.Message;
import messagingapp.service.MessageService;
import messagingapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class MessageController {
    @Autowired
    private MessageService messageService;

    @GetMapping("/messages")
    public String getMessages(HttpSession session, Model model) {
        String phoneNumber = (String) session.getAttribute("phoneNumber");
        if (phoneNumber == null) {
            return "redirect:/login";
        }

        List<Message> messages = messageService.getMessagesForUser(phoneNumber);
        model.addAttribute("messages", messages);

        return "messages";
    }

    @PostMapping("/send")
    public String sendMessage(HttpSession session, @RequestParam String receiverPhoneNumber, @RequestParam String content) {
        String senderPhoneNumber = (String) session.getAttribute("phoneNumber");
        if (senderPhoneNumber == null) {
            return "redirect:/login";
        }

        messageService.sendMessage(senderPhoneNumber, receiverPhoneNumber, content);
        return "redirect:/messages";
    }
}

