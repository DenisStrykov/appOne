package ru.denis_strykov.appone.service;

import ru.denis_strykov.appone.model.Data;

import java.util.List;

public interface GRPCDataService {

    void send(Data data);
    void send(List<Data> data);

}
