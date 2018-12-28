package j2ee.demo.utils;

import com.google.gson.*;

import java.util.List;

public class GetJsonContentUtils {
    private JsonObject jsonObject;

    public GetJsonContentUtils(String json) {
        Gson gson = new Gson();
        jsonObject = gson.fromJson(json, JsonObject.class);
    }

    public static JsonObject transEntityToJsonObject(Object tar){
        //Gson gson = new Gson();
        Gson gson = new GsonBuilder()
                .setExclusionStrategies(new ExclusionStrategy() {
                    @Override
                    public boolean shouldSkipField(FieldAttributes fieldAttributes) {
                        return fieldAttributes.getName().contains("password");
                    }

                    @Override
                    public boolean shouldSkipClass(Class<?> aClass) {
                        return false;
                    }
                })
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();
        return gson.toJsonTree(tar).getAsJsonObject();
    }

    public static JsonArray transListToJsonArray(List list){
        Gson gson = new GsonBuilder()
                .setExclusionStrategies(new ExclusionStrategy() {
                    @Override
                    public boolean shouldSkipField(FieldAttributes fieldAttributes) {
                        return fieldAttributes.getName().contains("password");
                    }

                    @Override
                    public boolean shouldSkipClass(Class<?> aClass) {
                        return false;
                    }
                })
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();
        return gson.toJsonTree(list).getAsJsonArray();
    }

    public static JsonArray transUsersListToSummaryUserInfoJsonArray(List list){
        Gson gson = new GsonBuilder()
                .setExclusionStrategies(new ExclusionStrategy() {
                    @Override
                    public boolean shouldSkipField(FieldAttributes fieldAttributes) {
                        boolean isSkip = true;
                        if(fieldAttributes.getName().matches("(?:titleId)|(?:name)|(?:id)|(?:avatar)"))
                            isSkip = false;
                        return isSkip;
                    }

                    @Override
                    public boolean shouldSkipClass(Class<?> aClass) {
                        return false;
                    }
                })
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();
        return gson.toJsonTree(list).getAsJsonArray();
    }

    public static JsonObject transNotiToJsonObject(Object tar){
        //Gson gson = new Gson();
        Gson gson = new GsonBuilder()
                .setExclusionStrategies(new ExclusionStrategy() {
                    @Override
                    public boolean shouldSkipField(FieldAttributes fieldAttributes) {
                        return fieldAttributes.getName().contains("senderId");
                    }

                    @Override
                    public boolean shouldSkipClass(Class<?> aClass) {
                        return false;
                    }
                })
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();
        return gson.toJsonTree(tar).getAsJsonObject();
    }

    public int getContentAsInt(String key){
        return jsonObject.get(key).getAsInt();
    }

    public String getContentAsString(String key){
        return jsonObject.get(key).getAsString();
    }

    public int getMemberOfObjectAsInt(String object, String member){
        return jsonObject.getAsJsonObject(object).get(member).getAsInt();
    }

    public String getMemberOfObjectAsString(String object, String member){
        return jsonObject.getAsJsonObject(object).get(member).getAsString();
    }
}
