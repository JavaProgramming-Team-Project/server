package jcw.javaTeamProjectServer.controller;

import jcw.javaTeamProjectServer.dto.ReviewListDto;
import jcw.javaTeamProjectServer.entity.Review;
import jcw.javaTeamProjectServer.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/review")
public class ReviewController {

    private final ReviewService reviewService;

    @PostMapping("")
    public void writeReview(@RequestBody Review review) {
        reviewService.write(review);
    }

    @GetMapping("/item/{item}")
    public List<ReviewListDto> reviewByItem(@PathVariable("item") Long itemKey) {
        return reviewService.reviewListByItem(itemKey);
    }

    @DeleteMapping("/{id}")
    public void deleteReview(@PathVariable("id") Long id) {
        reviewService.delete(id);
    }
}
