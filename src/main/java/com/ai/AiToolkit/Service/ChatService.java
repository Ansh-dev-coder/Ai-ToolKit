package com.ai.AiToolkit.Service;

import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.google.genai.GoogleGenAiChatOptions;
import org.springframework.stereotype.Service;

@Service
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
//Method to get the response from the chat model
    public String getResponseOptions(String prompt){
       ChatResponse response= chatModel.call(new Prompt(
               prompt,
               GoogleGenAiChatOptions.builder()
                       .model("gemini-2.5-flash")
                       .googleSearchRetrieval(true)
//                       .includeServerSideToolInvocations(true)
                       .build()

       ));
       return  response.getResult().getOutput().getText();
    }
    
}
