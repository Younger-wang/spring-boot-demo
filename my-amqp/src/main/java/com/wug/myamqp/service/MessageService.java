package com.wug.myamqp.service;

import java.util.Map;

public interface MessageService {
    void receive(Map<String, Object> objectMap);
}
