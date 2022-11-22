package com.demo.moudleOne.alert.controller;

import com.demo.moudleOne.alert.service.SgAlertService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author LXW
 * @date 2020/04/10 20:04
 */
@RestController
@RequestMapping("/moudleOne")
public class SgAlertController {
	@Resource
	SgAlertService sgAlertService;


	@GetMapping("/sgalert")
	public String sgalert(){
		return sgAlertService.sgAlert();
	}

	@GetMapping("/test")
	public String test(){
		return "网关测试";
	}




}
