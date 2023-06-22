package com.yufunghang.demo.controller;

import com.yufunghang.demo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/demo")
public class DemoController
{
   private DemoService demoService;

   @Autowired
   public DemoController(DemoService demoService) {
      this.demoService = demoService;
   }

   @PostMapping("/mq")
   public ResponseEntity<?> demoMethod(@RequestParam String content)
   {
      demoService.demoMethod(content);
      return ResponseEntity.ok(null);
   }
}