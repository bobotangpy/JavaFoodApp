package com.tutorial.food.controller;

import com.tutorial.food.model.Food;
import com.tutorial.food.service.FoodService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FoodController {
    private FoodService foodService;

    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    // Handle POST Request
    @PostMapping("home")
    public String addFood(Model model, Food food) {
        // Validation
        if (food.getPrice() > 1000) {
            model.addAttribute("errMessage", String.format("Could not add because overpriced,  ", food.getName()));

        // vvv Handle error if cannot add food successfully => food wld be smaller than 1
        } else if (foodService.addFood(food) < 1) {
            model.addAttribute("errMessage", String.format("Could not add ", food.getName()));
        } else {
            model.addAttribute("successMessage", String.format("Successfully added  ", food.getName()));
        }

        Food[] foods = foodService.getFoods();
        model.addAttribute("foods", foods);

        return "home";
    }

    // Handle GET Request
        @GetMapping("/home")
        public String getHome(Model model, Food food) {
                model.addAttribute("message", "Message sending from FoodController");

            Food[] foods = foodService.getFoods();
            model.addAttribute("foods", foods);

                // Return home.html
                return "home";
        }
}
