package uz.pdp.appdemowebsocketinspring.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.appdemowebsocketinspring.model.Message;
import uz.pdp.appdemowebsocketinspring.model.OutputMessage;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class OutputMessageController {

    private List<OutputMessage> group1 = new ArrayList<>();
    private List<OutputMessage> group2 = new ArrayList<>();


    @MessageMapping("/chat")
    @SendTo("/topic/messages")
    public OutputMessage send(Message message) throws Exception{
        String time = new SimpleDateFormat("HH:mm").format(new Date());
        OutputMessage outputMessage = new OutputMessage(message.getFrom(), message.getText(), time);
        group1.add(outputMessage);
        return outputMessage;

    }



    @MessageMapping("/chat2")
    @SendTo("/topic/messages")
    public OutputMessage send2(Message message) throws Exception{
        String time = new SimpleDateFormat("HH:mm").format(new Date());
        OutputMessage outputMessage = new OutputMessage(message.getFrom(), message.getText(), time);
        group2.add(outputMessage);
        return outputMessage;
    }

    @MessageMapping("/getGroup1Chat")
    @SendTo("")

}
