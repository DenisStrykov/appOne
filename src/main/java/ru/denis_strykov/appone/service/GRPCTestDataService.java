package ru.denis_strykov.appone.service;

import ru.denis_strykov.appone.model.test.DataTestOptions;

public interface GRPCTestDataService {

    void sendMessages(DataTestOptions testOptions);

}
