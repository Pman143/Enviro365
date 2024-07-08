package com.enviro.assessment.senior001.princesemenya.service;

import com.enviro.assessment.senior001.princesemenya.configuration.OpenAIProperties;
import com.enviro.assessment.senior001.princesemenya.exceptions.SuggestionsException;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@Slf4j
public class OpenApiService {

    private final OpenAIProperties openAIProperties;

    public OpenApiService(OpenAIProperties openAIProperties) {
        this.openAIProperties = openAIProperties;
    }

    public List<String> getSuggestions(String organizationName, String industry) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = getHttpPost(organizationName, industry);

        try (CloseableHttpResponse response = httpClient.execute(httpPost)) {
            String jsonResponse = EntityUtils.toString(response.getEntity());
            JSONObject responseObject = new JSONObject(jsonResponse);
            String content = responseObject.getJSONArray("choices").getJSONObject(0).getJSONObject("message").getString("content");
            return Stream.of(content.split("\\n"))
                    .filter(c -> !c.isEmpty())
                    .map(c -> c.replaceFirst("^\\d+\\.\\s*", ""))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            log.error("Exception occurred {}", e.getMessage());
            throw new SuggestionsException(e.getMessage());
        }
    }

    private HttpPost getHttpPost(String organizationName, String industry) {
        HttpPost httpPost = new HttpPost(openAIProperties.getUrl());

        httpPost.setHeader("Content-Type", "application/json");
        httpPost.setHeader("Authorization", "Bearer " + openAIProperties.getKey());

        JSONObject json = getJsonObject(organizationName, industry);

        StringEntity entity = new StringEntity(json.toString(), "UTF-8");
        httpPost.setEntity(entity);
        return httpPost;
    }

    private JSONObject getJsonObject(String organizationName, String industry) {
        String prompt = "Suggest ways for the organization named " + organizationName + " in the " + industry + " industry to improve their environmental sustainability.";
        JSONObject json = new JSONObject();
        json.put("model", "gpt-3.5-turbo");

        JSONArray messages = new JSONArray();
        JSONObject message = new JSONObject();
        message.put("role", "user");
        message.put("content", prompt);
        messages.put(message);

        json.put("messages", messages);
        json.put("max_tokens", 150);
        return json;
    }
}
