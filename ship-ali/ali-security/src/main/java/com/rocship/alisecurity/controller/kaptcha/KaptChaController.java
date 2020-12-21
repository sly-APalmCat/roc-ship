package com.rocship.alisecurity.controller.kaptcha;/**
 * Description: <br/>
 * date: 2020/12/21 15:11<br/>
 *
 * @version
 */

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import com.rocship.alisecurity.config.kaptcha.KaptChaConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

/**
 * ClassName: KaptChaController <br/>
 * Description: <br/>
 * date: 2020/12/21 15:11<br/>
 * @author 15438<br />
 */
@RestController
@RequestMapping("/kaptcha")
public class KaptChaController {

    @Autowired
    private DefaultKaptcha defaultKaptcha;

    /**
     * @param response
     * @return
     */
    @RequestMapping("/getKaptchaImg")
    public void getKaptChaImg(HttpServletResponse response){
        defaultKaptcha.setConfig(KaptChaConfig.getKaptchaColor());
        String text = defaultKaptcha.createText();
        BufferedImage image = defaultKaptcha.createImage(text);
        try {
            ServletOutputStream stream = response.getOutputStream();
            ImageIO.write(image,"jpg",stream);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}
