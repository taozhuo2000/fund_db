package com.software_project.controller;

import com.software_project.pojo.Comment;
import com.software_project.pojo.User;
import com.software_project.service.CommentService;
import com.software_project.service.UserService;
import com.software_project.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RequestMapping("comment")
@RestController
public class CommentController {
    @Autowired
    private CommentService commentService;

    @Autowired
    private UserService userService;

    @PostMapping("addComment")
    public Result addComment(@RequestBody Comment comment){
        commentService.insertComment(comment);
        return new Result(200, true, "添加评论成功");
    }

    @GetMapping("deleteComment")
    public Result deleteComment(int id){
        commentService.deleteComment(id);
        return new Result(200, true, "删除评论成功");
    }

    @GetMapping("getCommentsByFundCode")
    public Result getCommentsByFundCode(String fundCode){
        List<Comment> comments = commentService.getCommentsByFundCode(fundCode);
        for (Comment comment : comments) {
            String nickName = getUserName(comment.getUserEmail());
            comment.setNickname(nickName);
        }
        return new Result(200, comments, "通过基金代码获取所有评论");
    }

    @GetMapping("getCommentsByID")
    public Result getCommentsByID(int id) {
        List<Comment> comments = commentService.getRespondCommentsByID(id);
        for (Comment comment : comments) {
            String nickName = getUserName(comment.getUserEmail());
            comment.setNickname(nickName);
        }
        return new Result(200, comments, "通过评论ID获取所有回复");
    }

    @GetMapping("getCommentByUserEmail")
    public Result getCommentByUserEmail(String userEmail) {
        List<Comment> comments = commentService.getCommentByUserEmail(userEmail);
        for (Comment comment : comments) {
            String nickName = getUserName(comment.getUserEmail());
            comment.setNickname(nickName);
        }
        return new Result(200, comments, "获取一个用户的所有评论");
    }

    String getUserName(String userEmail) {
        User user = userService.findUserByEmail(userEmail);
        return user.getNickname();
    }
}