package ru.denis_strykov.appone.service;

import ru.denis_strykov.appone.model.Data;

public interface KafkaDataService {

    void send(Data data);

}
