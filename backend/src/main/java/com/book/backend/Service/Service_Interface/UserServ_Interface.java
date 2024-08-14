package com.book.backend.Service.Service_Interface;

import com.book.backend.Serializer_DTO.User_DTO;

import java.util.List;
public interface UserServ_Interface {
    String login(String user, String pass);
    User_DTO addUser(User_DTO user_dto);
    List<User_DTO> getAllUser();


    User_DTO getUser(String uId);
    User_DTO wish(String uId, String bId);

    User_DTO addRequest(String uid, String newid);
}
