package com.campudual.appamazing.model.dto.dtomapper;


import com.campudual.appamazing.model.Category;
import com.campudual.appamazing.model.dto.CategoryDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import java.util.List;

@Mapper
public interface CategoryMapper {
    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    CategoryDto toDTO(Category category);
    List<CategoryDto> toDTOList(List<Category> categories);
    Category toEntity(CategoryDto contactDto);
}
