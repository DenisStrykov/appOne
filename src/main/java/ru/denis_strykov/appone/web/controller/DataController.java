package ru.denis_strykov.appone.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.denis_strykov.appone.model.Data;
import ru.denis_strykov.appone.model.test.DataTestOptions;
import ru.denis_strykov.appone.service.KafkaDataService;
import ru.denis_strykov.appone.service.TestDataService;
import ru.denis_strykov.appone.web.dto.DataDto;
import ru.denis_strykov.appone.web.dto.DataTestOptionsDto;
import ru.denis_strykov.appone.web.mapper.DataMapper;
import ru.denis_strykov.appone.web.mapper.DataTestOptionsMapper;

@RestController
@RequestMapping("api/v1/data")
@RequiredArgsConstructor
public class DataController {

    private final KafkaDataService kafkaDataService;
    private final TestDataService testDataService;

    private final DataMapper dataMapper;
    private final DataTestOptionsMapper dataTestOptionsMapper;

    @PostMapping("/send")
    public void send(
            @RequestBody DataDto dto
    ) {
        Data data = dataMapper.toEntity(dto);
        kafkaDataService.send(data);
    }

    @PostMapping("/test/send")
    public void testSend(@RequestBody DataTestOptionsDto testOptionsDto) {
        DataTestOptions testOptions = dataTestOptionsMapper.toEntity(testOptionsDto);
        testDataService.sendMessages(testOptions);
    }

}
