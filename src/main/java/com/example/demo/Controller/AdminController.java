package com.example.demo.Controller;
import com.example.demo.service.AdminService;
import com.example.demo.service.request.MovieRequest;
import com.example.demo.service.response.MovieResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;
    @PostMapping("movie/add")
    public ResponseEntity<MovieResponse> addMovies(@RequestBody MovieRequest movieRequest){
        return new ResponseEntity<>(adminService.addmovie(movieRequest.toMovie()).toMovieResponse(),HttpStatus.CREATED);
    }
}
