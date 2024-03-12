package ru.denis_strykov.appone.service.implementation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.kafka.sender.KafkaSender;
import ru.denis_strykov.appone.model.Data;
import ru.denis_strykov.appone.service.KafkaDataService;

@Service
@RequiredArgsConstructor
public class KafkaDataServiceImpl implements KafkaDataService {

    private final KafkaSender<String, Object> sender;

    @Override
    public void send(Data data) {

    }

}
