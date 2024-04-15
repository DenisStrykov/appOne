package ru.denis_strykov.appone.model.test;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.denis_strykov.appone.model.Data;

@NoArgsConstructor
@Getter
@Setter
public class DataTestOptions {

    private int delayInSeconds;
    private Data.MeasurementType[] measurementTypes;

}
