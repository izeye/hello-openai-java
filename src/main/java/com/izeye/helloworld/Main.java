package com.izeye.helloworld;

import com.theokanning.openai.completion.CompletionChoice;
import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.image.CreateImageRequest;
import com.theokanning.openai.image.Image;
import com.theokanning.openai.service.OpenAiService;

import java.util.List;

/**
 * Hello world for OpenAI-Java.
 *
 * This is based on <a href="https://github.com/TheoKanning/openai-java/blob/main/example/src/main/java/example/OpenAiApiExample.java">the sample</a> from the library repo.
 *
 * @author Johnny Lim
 */
public class Main {

    public static void main(String[] args) {
        String token = System.getenv("OPENAI_TOKEN");

        OpenAiService service = new OpenAiService(token);

        CompletionRequest completionRequest = CompletionRequest.builder()
                .model("ada")
                .prompt("I'm going to")
                .echo(true)
                .user("testing")
                .n(3)
                .build();
        List<CompletionChoice> choices = service.createCompletion(completionRequest).getChoices();
        choices.forEach(System.out::println);

        CreateImageRequest createImageRequest = CreateImageRequest.builder()
                .prompt("A man running with a dog")
                .build();
        List<Image> images = service.createImage(createImageRequest).getData();
        images.forEach(System.out::println);
    }

}
