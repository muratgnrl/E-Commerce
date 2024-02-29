package com.example.interactionservice.mapper;

import com.example.interactionservice.dto.CommentsDto;
import com.example.interactionservice.dto.FavouritesDto;
import com.example.interactionservice.dto.ProductDto;
import com.example.interactionservice.entity.Comments;
import com.example.interactionservice.entity.Favourites;
import com.example.interactionservice.entity.Product;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-26T14:47:39+0300",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 21.0.1 (Oracle Corporation)"
)
@Component
public class FavouriteMapperImpl implements FavouriteMapper {

    @Override
    public FavouritesDto toDto(Favourites e) {
        if ( e == null ) {
            return null;
        }

        FavouritesDto favouritesDto = new FavouritesDto();

        favouritesDto.favoriteId = e.getFavoriteId();
        favouritesDto.favoriteDesc = e.getFavoriteDesc();
        favouritesDto.productList = productListToProductDtoList( e.getProductList() );

        return favouritesDto;
    }

    @Override
    public Favourites toEntity(FavouritesDto r) {
        if ( r == null ) {
            return null;
        }

        Favourites favourites = new Favourites();

        favourites.setFavoriteId( r.favoriteId );
        favourites.setFavoriteDesc( r.favoriteDesc );
        favourites.setProductList( productDtoListToProductList( r.productList ) );

        return favourites;
    }

    @Override
    public List<FavouritesDto> toDto(List<Favourites> eList) {
        if ( eList == null ) {
            return null;
        }

        List<FavouritesDto> list = new ArrayList<FavouritesDto>( eList.size() );
        for ( Favourites favourites : eList ) {
            list.add( toDto( favourites ) );
        }

        return list;
    }

    @Override
    public List<Favourites> toEntity(List<FavouritesDto> rList) {
        if ( rList == null ) {
            return null;
        }

        List<Favourites> list = new ArrayList<Favourites>( rList.size() );
        for ( FavouritesDto favouritesDto : rList ) {
            list.add( toEntity( favouritesDto ) );
        }

        return list;
    }

    protected CommentsDto commentsToCommentsDto(Comments comments) {
        if ( comments == null ) {
            return null;
        }

        CommentsDto commentsDto = new CommentsDto();

        commentsDto.commentId = comments.getCommentId();
        commentsDto.comment = comments.getComment();
        commentsDto.user = comments.getUser();

        return commentsDto;
    }

    protected List<CommentsDto> commentsListToCommentsDtoList(List<Comments> list) {
        if ( list == null ) {
            return null;
        }

        List<CommentsDto> list1 = new ArrayList<CommentsDto>( list.size() );
        for ( Comments comments : list ) {
            list1.add( commentsToCommentsDto( comments ) );
        }

        return list1;
    }

    protected ProductDto productToProductDto(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductDto productDto = new ProductDto();

        productDto.productId = product.getProductId();
        productDto.productName = product.getProductName();
        productDto.productDescprition = product.getProductDescprition();
        productDto.favourites = product.getFavourites();
        productDto.commentsList = commentsListToCommentsDtoList( product.getCommentsList() );

        return productDto;
    }

    protected List<ProductDto> productListToProductDtoList(List<Product> list) {
        if ( list == null ) {
            return null;
        }

        List<ProductDto> list1 = new ArrayList<ProductDto>( list.size() );
        for ( Product product : list ) {
            list1.add( productToProductDto( product ) );
        }

        return list1;
    }

    protected Comments commentsDtoToComments(CommentsDto commentsDto) {
        if ( commentsDto == null ) {
            return null;
        }

        Comments comments = new Comments();

        comments.setCommentId( commentsDto.commentId );
        comments.setComment( commentsDto.comment );
        comments.setUser( commentsDto.user );

        return comments;
    }

    protected List<Comments> commentsDtoListToCommentsList(List<CommentsDto> list) {
        if ( list == null ) {
            return null;
        }

        List<Comments> list1 = new ArrayList<Comments>( list.size() );
        for ( CommentsDto commentsDto : list ) {
            list1.add( commentsDtoToComments( commentsDto ) );
        }

        return list1;
    }

    protected Product productDtoToProduct(ProductDto productDto) {
        if ( productDto == null ) {
            return null;
        }

        Product product = new Product();

        product.setProductId( productDto.productId );
        product.setProductName( productDto.productName );
        product.setProductDescprition( productDto.productDescprition );
        product.setFavourites( productDto.favourites );
        product.setCommentsList( commentsDtoListToCommentsList( productDto.commentsList ) );

        return product;
    }

    protected List<Product> productDtoListToProductList(List<ProductDto> list) {
        if ( list == null ) {
            return null;
        }

        List<Product> list1 = new ArrayList<Product>( list.size() );
        for ( ProductDto productDto : list ) {
            list1.add( productDtoToProduct( productDto ) );
        }

        return list1;
    }
}
