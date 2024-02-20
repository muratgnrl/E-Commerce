package com.example.help.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Scanner;
@RestController
@RequestMapping("/feedback")
public class FeedBack {
    @GetMapping("/feedaback")
    public int feedBack(){
        Scanner reader=new Scanner(System.in);
        System.out.println("Lütfen siparişiniz'e 1 ile 5 arasında bir puan veriniz.");
        int degerlendirme=reader.nextInt();
        System.out.println(degerlendirme+" puan verdiğiniz için teşekkürler.");
        return degerlendirme;
    }

}
