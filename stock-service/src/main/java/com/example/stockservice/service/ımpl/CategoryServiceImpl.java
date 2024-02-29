package com.example.stockservice.service.ımpl;

import com.example.stockservice.dto.CategoryDto;
import com.example.stockservice.exception.CategoryDeleteException;
import com.example.stockservice.exception.CategoryGetAllException;
import com.example.stockservice.exception.CategoryNotCreate;
import com.example.stockservice.exception.CategoryNotFoundException;
import com.example.stockservice.mapper.CategoryMapper;
import com.example.stockservice.model.Category;
import com.example.stockservice.repository.CategoryRepository;
import com.example.stockservice.response.CategoryRespone;
import com.example.stockservice.response.Meta;
import com.example.stockservice.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    @Override
    public CategoryRespone saveCategory(CategoryDto dto) throws CategoryNotCreate {
        Category category = CategoryMapper.mapToEntity(dto);
        category=categoryRepository.save(category);
        if (category !=null){
            CategoryRespone categoryRespone =new CategoryRespone();
            categoryRespone.meta=new Meta(200,"Kategori oluşturuldu");
            categoryRespone.category=CategoryMapper.mapToDto(category);
            return categoryRespone;
        }else {
            throw new CategoryNotCreate();
        }
    }

    @Override
    public List<CategoryDto> getAllCategory() throws CategoryGetAllException {
        List<CategoryDto> categoryDtoList = new ArrayList<>();

        try {
            Iterable<Category> categories = categoryRepository.findAll();
            for (Category category : categories) {
                CategoryDto categoryDto = CategoryMapper.mapToDto(category);
                categoryDtoList.add(categoryDto);
            }
        } catch (Exception ex) {
            // Hata durumunda istisna fırlat
            throw new CategoryGetAllException();
        }

        return categoryDtoList;
    }

    @Override
    public CategoryRespone findCategory(long categoryId) throws CategoryNotFoundException {
        Category category =findByCategory(categoryId);
        if (category!=null){
            CategoryRespone categoryRespone =new CategoryRespone();
            categoryRespone.category=CategoryMapper.mapToDto(category);
            categoryRespone.meta=new Meta(200,"Kategori bulundu");
            return categoryRespone;
        }else {
            throw new CategoryNotFoundException();
        }
    }

    public Category findByCategory(long categoryId) {
        Category category = categoryRepository.findByCategoryId(categoryId);
        return category;
    }

    @Override
    public CategoryRespone deletedCategory(long categoryId) throws CategoryDeleteException {
        Category category =categoryRepository.findByCategoryId(categoryId);
        if (category!=null){
            CategoryRespone categoryRespone =new CategoryRespone();
            categoryRespone.category=CategoryMapper.mapToDto(category);
            categoryRespone.meta=new Meta(200,"Kategori silindi");
            categoryRepository.delete(category);
            return categoryRespone;
        }else {throw new CategoryDeleteException();
        }
    }
}
