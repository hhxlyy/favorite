package com.favorites.controller;

import com.favorites.domain.Letter;
import com.favorites.domain.view.LetterSummary;
import com.favorites.service.ILetterService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/letter")
public class LetterController {

    @Resource
    private ILetterService letterService;

    @RequestMapping("/sentLetter")
    public int sentLetter(Letter letter, Long baseUserId){
        try {
            letter.setSendUserId(baseUserId);
            letterService.sentLetter(letter);
        }catch (Exception e){
            return 0;
        }
        return 1;
    }

    @RequestMapping("findLetterList")
    public List<LetterSummary> findLetterList(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                              @RequestParam(value = "size", defaultValue = "15") Integer size,Long baseUserId){
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = PageRequest.of(page, size,sort);
        List<LetterSummary> letterList = letterService.findLetter(baseUserId,pageable);
        return letterList;
    }
}
