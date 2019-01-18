package com.wuyou.captcha;

import com.wuyou.base.BaseRequest;
import com.wuyou.base.BaseResponse;
import com.wuyou.base.HttpCodeMessage;
import com.wuyou.base.util.PhoneNoUtils;
import com.wuyou.captcha.repository.Captcha;
import com.wuyou.captcha.service.MobileVerificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/captcha")
public class CaptchaEndPoint {

    @Autowired
    MobileVerificationService mobileVerificationService;

    @RequestMapping(method = RequestMethod.POST)
    public BaseResponse applyVerificationCode(@RequestBody BaseRequest<String> request) {
        if (!PhoneNoUtils.isValidPhoneNo(request.getValue())) {
            return new BaseResponse(HttpStatus.BAD_REQUEST,HttpCodeMessage.TC020007);
        }
        if (mobileVerificationService.send(request.getValue())) {
            return new BaseResponse(HttpStatus.OK,HttpCodeMessage.TC020049);
        } else {
            return new BaseResponse(HttpStatus.BAD_GATEWAY,HttpCodeMessage.TC020047);
        }
    }

    @RequestMapping(value = "/check", method = RequestMethod.POST)
    public BaseResponse checkVerificationCode(@RequestBody Captcha captcha) {
        if (mobileVerificationService.verify(captcha.getMobile(), captcha.getCaptcha())) {
            return new BaseResponse(HttpStatus.OK);
        }
        return new BaseResponse(HttpStatus.BAD_REQUEST, HttpCodeMessage.TC020001);
    }
}