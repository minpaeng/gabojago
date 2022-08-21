package com.hanium.gabojago.controller;

import com.hanium.gabojago.domain.User;
import com.hanium.gabojago.dto.bookmark.SpotBookmarkPageResponse;
import com.hanium.gabojago.service.SpotService;
import com.hanium.gabojago.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;


@RequiredArgsConstructor
@RequestMapping("users")
@RestController
public class UserController {
    private final UserService userService;
    private final SpotService spotService;

    //사용자 북마크 조회
    @GetMapping("bookmark")
    public SpotBookmarkPageResponse userBookmarks(HttpServletRequest httpServletRequest,
                                                  @RequestParam(required = false, defaultValue = "1", value = "page")int page,
                                                  @RequestParam(required = false, defaultValue = "10", value = "size")int size) {

        String token = httpServletRequest.getHeader("Authorization");
        User user = userService.findUserByJwtToken(token);

        return spotService.getUserBookmarks(user, page - 1, size);
    }
}
