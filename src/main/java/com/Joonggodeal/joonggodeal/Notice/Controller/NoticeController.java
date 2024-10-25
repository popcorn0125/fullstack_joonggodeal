package com.Joonggodeal.joonggodeal.Notice.Controller;

import com.Joonggodeal.joonggodeal.Notice.Service.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notice")
@RequiredArgsConstructor
public class NoticeController {
    private final NoticeService noticeService;

    @PostMapping("/getAllBoard")
    public ResponseEntity<?> getAllBoards() {
        System.out.println("NoticeController - 실행 - getAllBoards");
        return ResponseEntity.ok(noticeService.getAllBoards());
    }
}
