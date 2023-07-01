package com.ybus.ybusapiserver.Controller;

import com.ybus.ybusapiserver.DTO.board.CommentDTO;
import com.ybus.ybusapiserver.DTO.board.PostDTO;
import com.ybus.ybusapiserver.Service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/board")
public class BoardController {
    private BoardService boardService;

    @Autowired
    public BoardController(BoardService boardService){
        this.boardService = boardService;
    }

    @PostMapping(value = "/post")
    public String writePost(@RequestBody PostDTO postDTO){
        try{
            System.out.println(postDTO.toString());
            boardService.writePost(postDTO);
            return "성공";
        }
        catch (Exception e){
            return "실패!";
        }

    }

//{"subject":"테스트임ㅎㅎ",
// "content":"아주 빠르게 치는중ㅎㅎ",
// "writerName":"ghddudrhkd",
// "tag":"테스트"}

    @PostMapping(value = "/comment")
    public String writeComment(@RequestBody CommentDTO commentDTO){
        try{
            boardService.writeComment(commentDTO);
            return "성공";
        }
        catch (Exception e){
            return "실패!";
        }

    }
//    {"content":"Content","writerName":"Writer","postSeq":123456789}

    @GetMapping(value = "/post")
    public String getPostInfo(@RequestParam(required = false,value = "postseq") Long postSeq){

        if(postSeq == null){
            String postInfo = boardService.getPostInfoAll();
         return postInfo;
        }
        else {
            String postInfo = boardService.getPostInfoToSeq(postSeq);
            return postInfo;
        }
    }

    @GetMapping(value = "/comment")
    public String getCommentInfo(@RequestParam("postseq") Long postSeq){
        String postInfo = boardService.getCommentInfo(postSeq);
        return postInfo;
    }

}
