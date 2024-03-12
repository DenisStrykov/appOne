package ru.denis_strykov.appone.web.mapper;

import org.mapstruct.Mapper;
import ru.denis_strykov.appone.model.test.DataTestOptions;
import ru.denis_strykov.appone.web.dto.DataTestOptionsDto;

@Mapper(componentModel = "spring")
public interface DataTestOptionsMapper
        extends Mappable<DataTestOptions, DataTestOptionsDto> {
}
