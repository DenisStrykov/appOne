package ru.denis_strykov.appone.web.mapper;

import org.mapstruct.Mapper;
import ru.denis_strykov.appone.model.Data;
import ru.denis_strykov.appone.web.dto.DataDto;

@Mapper(componentModel = "spring")
public interface DataMapper extends Mappable<Data, DataDto> {

}
