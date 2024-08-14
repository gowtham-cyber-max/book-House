package com.book.backend.Service.Service_Class;

import com.book.backend.Mapper.PublicReviewMapper;
import com.book.backend.Models.PublicReview;
import com.book.backend.Repo.PublicReviewRepo;
import com.book.backend.Serializer_DTO.PublicReview_DTO;
import com.book.backend.Service.Service_Interface.PublicReview_Interface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PublicReviewServ implements PublicReview_Interface{
    @Autowired
    PublicReviewRepo r;

@Autowired
BookServ Bs;
    public PublicReview_DTO addOneReview(PublicReview_DTO pr_dto) {
        PublicReview pr=PublicReviewMapper.convertToPublicReview(pr_dto);
        r.save(pr);
        Bs.addOneReview(pr.getId(),pr.getBookid(),pr.getStars());
 //no need
        return PublicReviewMapper.convertToPublicReview_DTO(pr);
    }
    public List<PublicReview_DTO> getByBookUserId(String id) {
        List<PublicReview> li=r.getReviewByUserId(id);
        return li.stream().map(PublicReviewMapper::convertToPublicReview_DTO)
                .collect(Collectors.toList());
    }

    public PublicReview_DTO getOneReview(String id) {
        PublicReview pr=r.findById(id).orElse(null);
        if(pr==null){
            return null;
        }
        return PublicReviewMapper.convertToPublicReview_DTO(pr);
    }

    public String deleteOneReview(String id) {
        r.deleteById(id);
        return "sucess";
    }
    public PublicReview_DTO updateOneReview(String id,PublicReview_DTO pr){
        pr.setId(id);
        PublicReview p=PublicReviewMapper.convertToPublicReview(pr);
        r.save(p);
        return PublicReviewMapper.convertToPublicReview_DTO(p);
    }
}
