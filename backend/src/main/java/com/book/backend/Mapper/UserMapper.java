package com.book.backend.Mapper;

import com.book.backend.Models.Book;
import com.book.backend.Models.User;
import com.book.backend.Serializer_DTO.User_DTO;
import org.xmlunit.util.Mapper;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class UserMapper {
    // converting User Model into User_DTO Serializer

    public static User_DTO convertToUser_Dto(User user) {
        // ASSIGN THE VALUES based on our control
        return new User_DTO(
                user.getId(),
                user.getUser(),
                user.getEmail(),
                null,
                user.getWishlist(),
                user.getFriendlist(),
                user.getFriendrequest()
        );
    }

    public static User convertToUser(User_DTO user_dto) {
        User user = new User(
                user_dto.getId(),
                user_dto.getUser(),
                user_dto.getEmail(),
                user_dto.getPassword(),
                user_dto.getWishlist(),
                user_dto.getFriendlist(),
                user_dto.getFriendrequest()
        );
        return user;
    }

}
