package com.example.demo.Controller;
import com.example.demo.service.Reviewservice;
import com.example.demo.service.request.ReviewRequest;
import com.example.demo.service.response.ReviewResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/review")
public class ReviewController {
    @Autowired
    Reviewservice reviewService;
    @PostMapping("/add")
    public void addReview(@RequestBody ReviewRequest reviewRequest){
    reviewService.addReview(reviewRequest.toReview());
    }
    @GetMapping("/find")
    public ReviewResponse getReview(@RequestParam Long reviewID){
    return reviewService.getReviewById(reviewID);
    }
}
