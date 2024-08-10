package com.book.backend.Service.Service_Class;

import com.book.backend.Mapper.UserMapper;
import com.book.backend.Models.User;
import com.book.backend.Repo.UserRepo;
import com.book.backend.Serializer_DTO.User_DTO;
import com.book.backend.Service.Service_Interface.UserServ_Interface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserServ implements UserServ_Interface {
    @Autowired
    private UserRepo r;

    public User_DTO addUser(User_DTO user_dto) {
        user_dto.setWishlist(Set.of());
        User user = UserMapper.convertToUser(user_dto);
        if(user.getFriendrequest()==null)
            user.setFriendrequest(Set.of());
        if(user.getWishlist()==null)
            user.setWishlist(Set.of());
        if(user.getFriendlist()==null)
            user.setFriendlist(Set.of());
        User savedUser = r.save(user);
        return UserMapper.convertToUser_Dto(savedUser);
    }

    public List<User_DTO> getAllUser() {
        List<User> allUsers = r.findAll();
        return allUsers.stream().map(UserMapper::convertToUser_Dto)
                .collect(Collectors.toList());
    }

    public String login(String user, String pass) {
        User u = r.login(user);
        if (u == null)
            return "User not found";
        if (u.getPassword().equals(pass))
            return u.getId();
        else
            return "Incorrect Password";
    }

    public User_DTO getUser(String id) {
        User u = r.findById(id).orElse(null);
        if (u == null)
            return null;
        return UserMapper.convertToUser_Dto(u);
    }

    public User_DTO wish(String uId, String bId) {
        User u = r.findById(uId).orElse(null);
        if (u == null)
            return null;
        if (u.getWishlist().contains(bId)) {
            u.getWishlist().remove(bId);
            r.save(u);
        } else {
            u.getWishlist().add(bId);
            r.save(u);
        }
        return UserMapper.convertToUser_Dto(u);
    }
    public User_DTO addRequest(String uid, String newid){
        User u=r.findById(uid).orElse(null);
        if(u==null){
            return null;
        }
        // confidence is because of each adding one user i will set into empty list or set so if any column is null it will initialized so no null
        u.getFriendrequest().add(newid);
        r.save(u);
        return UserMapper.convertToUser_Dto(u);
    }
}
