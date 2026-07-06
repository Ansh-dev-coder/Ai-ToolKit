package com.ai.AiToolkit.Service;

import org.springframework.ai.chat.model.ChatModel;


public class ChatService
{
    //Taking the instance of the chat model to call the model and get the response
    private final ChatModel chatModel;

//Constructor to initialize the chat model
    public ChatService(ChatModel chatModel){
        this.chatModel=chatModel;
    }
//Method to get the response from the chat model
    public String getResponse(String prompt){
       return chatModel.call(prompt);
    }
    
}
